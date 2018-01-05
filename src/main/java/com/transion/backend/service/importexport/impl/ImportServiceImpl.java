package com.transion.backend.service.importexport.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVReader;
import com.transion.backend.model.Client;
import com.transion.backend.model.ResponsibleUser;
import com.transion.backend.model.importexport.Field;
import com.transion.backend.model.importexport.Field.ImportEnum;
import com.transion.backend.model.importexport.Import;
import com.transion.backend.model.importexport.ImportLine;
import com.transion.backend.model.importexport.Mapping;
import com.transion.backend.repository.importexport.ImportRepository;
import com.transion.backend.service.ClientService;
import com.transion.backend.service.ResponsibleUserService;
import com.transion.backend.service.importexport.FieldService;
import com.transion.backend.service.importexport.ImportLineService;
import com.transion.backend.service.importexport.ImportService;

@Service
public class ImportServiceImpl implements ImportService{

	@Autowired
	ImportRepository importRepository;
	
	@Autowired
	ClientService cService;
	
	@Autowired
	ImportLineService ilService;
	
	@Autowired
	FieldService fService;
	
	@Autowired
	ResponsibleUserService ruService;
	
	@Override
	public Import save(Import import1) {
		return importRepository.save(import1);
	}

	@Override
	public List<Import> save(List<Import> imports) {
		return (List<Import>) importRepository.save(imports);
	}

	@Override
	public Import findOne(Long id) {
		return importRepository.findOne(id);
	}

	@Override
	public List<Import> findAll() {
		return (List<Import>) importRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		importRepository.delete(id);
	}

	@Override
	public void delete(Import import1) {
		importRepository.delete(import1);
	}

	@Override
	public void deleteAll() {
		importRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Import> imports) {
		importRepository.delete(imports);
	}

	@Override
	public Import importData(MultipartFile file, Mapping mapping) throws IOException, InterruptedException, ParseException {
		
		List<Field> fields = fService.findByMapping(mapping);
		
		File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    
		CSVReader reader = new CSVReader(new FileReader(convFile), '\t');
		String[] nextLine;
		int broj = 0;
		List object = reader.readAll();
		
		for(Object o : object) {
			broj++;
			String[] line = (String[])o;
			nextLine = line[0].split(",");
			
			switch (mapping.getType()) {
				case CLIENT:
					Client c = null;
					for(int j = 0; j < fields.size(); j++) {
						if(fields.get(j).getImportEnum() == ImportEnum.CLIENT_EXTERNALUNIQUEKEY) {
							c = cService.findByExternalUniqueKey(nextLine[j]);
						}
					}
					
					if(c == null)
						c = new Client();
					
					for(int i = 0; i < fields.size(); i++) {
						switch (fields.get(i).getImportEnum()) {
							case CLIENT_NAME:
								if(fields.get(i).getType().equals("String"))
									c.setName(nextLine[i]);
								break;
							case CLIENT_PIB:
								if(fields.get(i).getType().equals("String"))
									c.setPib(nextLine[i]);
								break;
							case CLIENT_ADDRESS:
								c.setAddress(nextLine[i]);
								break;
							case CLIENT_EMAIL:
								c.setEmail(nextLine[i]);
								break;
							case CLIENT_TELEPHONE:
								c.setTelephone(nextLine[i]);
								break;
							case CLIENT_EXTERNALUNIQUEKEY:
								c.setExternalUniqueKey(nextLine[i]);
								break;
							default:
								break;
						}
					}
					
					cService.save(c);
					Thread.sleep(10);
					ilService.save(new ImportLine(c.getId(), mapping));
					break;
				default:
					break;
			
            }	
			
		}
		
		Import i = new Import();
		i.setCreatedOn(new Date());
		i.setMapping(mapping);
		return i;
	}

}
