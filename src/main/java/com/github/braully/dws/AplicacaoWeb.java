package com.github.braully.dws;

import com.sun.faces.config.ConfigureListener;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.context.ServletContextAware;

/**
 *
 * @author braully
 */
@EnableWebSecurity
@SpringBootApplication
public class AplicacaoWeb extends WebSecurityConfigurerAdapter implements ServletContextAware {

    public static void main(String... args) {
        SpringApplication.run(AplicacaoWeb.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("usuario")
                .password(passwordEncoder().encode("123"))
                .roles("estagiario").build();

        UserDetails admin = User.withUsername("sky")
                .password(passwordEncoder().encode("net"))
                .roles("fodão", "fodãoSPlus").build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/principal.xhtml").permitAll()
                .antMatchers("/todas-solicitacoes").hasRole("fodão")
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .permitAll().and()
                .logout().permitAll();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.xhtml");
//        ServletRegistrationBean reg = new ServletRegistrationBean(servlet, "*.senac");
//        return reg;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(
                new ConfigureListener());
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        //servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".html");
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }
}
