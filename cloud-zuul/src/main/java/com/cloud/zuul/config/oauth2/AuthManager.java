//package com.cloud.zuul.config.oauth2;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
//
//@Configuration
//public class AuthManager extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public AuthenticationManager customAuthenticationManager() throws Exception {
//        return authenticationManager();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout().logoutUrl("/logout")
//                .logoutSuccessUrl("/hello")
//                .permitAll();
////        http.addFilterBefore(customizeFilterSecurityInterceptor, FilterSecurityInterceptor.class)
////                .csrf().disable();
////        http
////                .authorizeRequests()
////                .antMatchers("/", "/home").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll();
//        http.csrf().disable();
//
//    }
//}