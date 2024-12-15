package com.webcuoiky.softwareshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
public class SecurityConfig {
      @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().permitAll());
//
//        return http.build();
         http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**", "/img/**").permitAll()
            .anyRequest().authenticated()  // Các yêu cầu khác yêu cầu người dùng đăng nhập
        )
        .formLogin(form -> form
            .loginPage("/login")
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        );

          return http.build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
