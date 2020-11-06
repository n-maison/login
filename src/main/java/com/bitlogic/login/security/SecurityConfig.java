package com.bitlogic.login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomDetailService customDetailService;
    @Value("app.api-version")
    private String apiVersion;
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
      auth.userDetailsService(customDetailService).passwordEncoder(encoder());
    }
    @Override
    public void configure(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers(apiVersion+ "/").authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
