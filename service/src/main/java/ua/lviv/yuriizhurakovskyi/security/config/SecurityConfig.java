package ua.lviv.yuriizhurakovskyi.security.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ua.lviv.yuriizhurakovskyi.security.entrypoint.JwtAuthenticationEntryPoint;
import ua.lviv.yuriizhurakovskyi.security.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
//@Profile("dev")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final UserDetailsService userDetailsService;

    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user")
                .access("hasRole('ADMINISTRATOR') or  hasRole('TEACHER') or  hasRole('STUDENT')")
                .antMatchers(HttpMethod.POST, "/user")
                .access("hasRole('ADMINISTRATOR') or hasRole('TEACHER')")
                .antMatchers(HttpMethod.GET, "/test")
                .access("hasRole('ADMINISTRATOR') or  hasRole('TEACHER') or  hasRole('STUDENT') or hasRole('REGULAR_USER')")
                .antMatchers(HttpMethod.POST, "/test")
                .access("hasRole('ADMINISTRATOR') or hasRole('TEACHER')")
                .antMatchers(HttpMethod.POST, "/test_question")
                .access("hasRole('ADMINISTRATOR') or  hasRole('TEACHER') or  hasRole('STUDENT')")
                .antMatchers("/task")
                .access("hasRole('ADMINISTRATOR') or  hasRole('TEACHER') or  hasRole('STUDENT')")
                .antMatchers("/classwork")
                .access("hasRole('ADMINISTRATOR') or  hasRole('TEACHER') or  hasRole('STUDENT')")
                .antMatchers("/course")
                .access("hasRole('ADMINISTRATOR') or  hasRole('TEACHER') or  hasRole('STUDENT')")
                .antMatchers("/lesson")
                .access("hasRole('ADMINISTRATOR') or  hasRole('TEACHER') or  hasRole('STUDENT')")
                .antMatchers("/authenticate", "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationProvider provider)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
