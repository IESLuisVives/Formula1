package com.example.formula1tfc.security;

import com.example.formula1tfc.security.jwt.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/logins").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .antMatchers(HttpMethod.GET, "/usuario/**").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/usuario/**").permitAll()
                .antMatchers(HttpMethod.GET, "/piloto/**").permitAll()
                .antMatchers(HttpMethod.POST, "/piloto/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/piloto/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/piloto/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/circuito/**").permitAll()
                .antMatchers(HttpMethod.POST, "/circuito/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/circuito/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/circuito/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/noticia/**").permitAll()
                .antMatchers(HttpMethod.POST, "/noticia/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/noticia/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/noticia/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/clasificacion/**").permitAll()
                .antMatchers(HttpMethod.POST, "/clasificacion/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/clasificacion/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/clasificacion/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/swagger").permitAll()
                .anyRequest().permitAll();

        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
