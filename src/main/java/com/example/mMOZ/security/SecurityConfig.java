package com.example.mMOZ.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
  public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
            http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/order/**").authenticated()
                .antMatchers("/form/**").authenticated()
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/");
        return http.build();
    }
//
//    @Autowired
//    private SpringDataUserDetailsService customUserDetailsService;
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().and().authorizeRequests()
////                .antMatchers("/all").hasAnyRole("USER")
////                .anyRequest().permitAll()
////                .and()
////                .formLogin()
////                .loginProcessingUrl("/")
////                .usernameParameter("username").passwordParameter("password")
////                .successHandler(
////                        (request, response, authentication) -> response.sendRedirect("/")
////                )
////                .and()
////                .logout()
////                .logoutSuccessUrl("/afterlogout")
////                .invalidateHttpSession(true)
////                .deleteCookies("JSESSIONID")
////                .and()
////                .httpBasic()
////                .and()
////                .csrf().disable();
////    }
////
////    @Bean
////    public DaoAuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
////        authenticationProvider.setUserDetailsService(customUserDetailsService);
////        authenticationProvider.setPasswordEncoder(passwordEncoder());
////        return authenticationProvider;
////
////    }
////
////    @Bean
////    public SpringDataUserDetailsService customUserDetailsService() {
////        return new SpringDataUserDetailsService();
////    }
//
////    @Bean
////    public CorsConfigurationSource corsConfigurationSource() {
////        final CorsConfiguration configuration = new CorsConfiguration();
////        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081"));
////        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
////        configuration.setAllowCredentials(true);
////        configuration.setAllowedHeaders(Arrays.asList("*"));
////        configuration.setExposedHeaders(Arrays.asList("x-auth-token", "xsrf-token"));
////        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", configuration);
////        return source;
////    }
//
}
