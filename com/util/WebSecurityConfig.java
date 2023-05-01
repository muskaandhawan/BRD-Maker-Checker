package com.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                        .antMatchers("/").permitAll()
                        .antMatchers("/maker", "/registerCustomer", "/displayCustomer", "/updatePage",
                                "/updateCustomer", "/deletePage", "/logoutPage", "/fileUpload", "/display", "/uploadFile",
                                "/bulkInsert", "/fetchRecords").hasAuthority("maker")
                        .antMatchers("/checker", "/approveRecord", "/rejectRecord", "/show").hasAuthority("checker")
                        .anyRequest().authenticated()
                        .and().formLogin()
                        .and()
                        .csrf().disable()
                        .logout().logoutUrl("/logout");
    }

}
