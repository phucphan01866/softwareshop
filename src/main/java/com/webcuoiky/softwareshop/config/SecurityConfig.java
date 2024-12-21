package com.webcuoiky.softwareshop.config;

import com.webcuoiky.softwareshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(@Lazy BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

      @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

//
//        http.authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().permitAll());
//
//        return http.build();
          http
                  .authorizeHttpRequests(authorize -> authorize
                          //Chỉnh lại cái , đang đảo ngược lại/**
                          //.requestMatchers("/").authenticated()  // Cho phép truy cập mà không cần đăng nhập
                          .requestMatchers("/admin/product-list", "/admin/product-list/add-product").hasRole("ADMIN")
                          .anyRequest().permitAll()  // Các yêu cầu khác yêu cầu người dùng đăng nhập
                  )
                  .formLogin(form -> form.usernameParameter("email")
                          .loginPage("/login")
                          .defaultSuccessUrl("/index", true)
                          .permitAll()
                  )
                  .logout(logout -> logout
                          .logoutUrl("/logout")
                          .logoutSuccessUrl("/login?logout")
                          .permitAll()
                  )
                  .csrf(csrf -> csrf.disable());

          return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
