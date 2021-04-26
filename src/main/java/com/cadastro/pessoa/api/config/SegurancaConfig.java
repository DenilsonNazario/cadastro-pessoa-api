package com.cadastro.pessoa.api.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SegurancaConfig extends WebSecurityConfigurerAdapter 
{

    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
   	
		
		  http .antMatcher("/**").authorizeRequests() .antMatchers(new String[]{"/",
		  "/api/v1/source"}).permitAll() .anyRequest().authenticated() .and()
		  .oauth2Login() .and().csrf().disable(); }
		 


}
