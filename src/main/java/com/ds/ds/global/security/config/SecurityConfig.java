package com.ds.ds.global.security.config;

import com.ds.ds.global.security.authentication.CustomAuthenticationEntryPoint;
import com.ds.ds.global.security.exception.handler.JwtExceptionHandler;
import com.ds.ds.global.security.filter.JwtFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private final JwtExceptionHandler jwtExceptionHandler;
    private final ObjectMapper objectMapper;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .cors().and()
                .csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.OPTIONS,"/**").permitAll()

                //auth
                .antMatchers(HttpMethod.POST,"/auth/signin").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/email/**").permitAll()
                .antMatchers(HttpMethod.GET, "/auth/code/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/search").permitAll()
                .antMatchers(HttpMethod.DELETE, "/auth/logout").authenticated()

                //group
                .antMatchers(HttpMethod.GET, "/group").permitAll()
                .antMatchers(HttpMethod.GET, "/group/detail/**").permitAll()
                .antMatchers(HttpMethod.GET, "/group/information/**").authenticated()
                .antMatchers(HttpMethod.POST, "/group").authenticated()
                .antMatchers(HttpMethod.PATCH, "/group/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/group/**").authenticated()

                //user
                .antMatchers(HttpMethod.GET, "/group").authenticated()
                .antMatchers(HttpMethod.POST, "/group").authenticated()

                .anyRequest().denyAll()

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint(objectMapper))

                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jwtExceptionHandler, JwtFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
