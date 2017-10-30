package com.transion.backend.security;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.sun.net.httpserver.HttpsParameters;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	public static final String SIGN_UP_URL = "/user/login";
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JWTAuthenticatinProvider jwtAuthenticationProvider;
    
	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	protected JWTAuthenticationFilter buildJWTAuthenticationFilter() throws Exception {
		JWTAuthenticationFilter filter = new JWTAuthenticationFilter("/login");
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);*/
    	auth
    		.jdbcAuthentication()
    		.usersByUsernameQuery(usersQuery)
    		.groupAuthoritiesByUsername(rolesQuery)
    		.passwordEncoder(bCryptPasswordEncoder);
        auth.authenticationProvider(jwtAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.POST, "/role/**").hasAnyRole("ADMIN","NESTO")
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(buildJWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }

    
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	CorsConfiguration customCorsConf = new CorsConfiguration();
    	customCorsConf.addAllowedOrigin("*");
    	customCorsConf.setAllowedMethods(Arrays.asList(
				HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name()));
    	customCorsConf.addAllowedHeader("*");
    	customCorsConf.setAllowCredentials(true);
    	customCorsConf.setMaxAge(1800L);
	    source.registerCorsConfiguration("/**", customCorsConf);
	    
	    return source;
    }
    
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
