package com.androidproj.doki.config;

import com.androidproj.doki.dao.UserDao;
import com.androidproj.doki.entity.User;
import com.androidproj.doki.service.UserService;
import com.androidproj.doki.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.ChannelSecurityConfigurer.RequiresChannelUrl;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public SecurityConfig() {

    }

    @Bean
    UserDetailsService userService() {
       return new UserServiceImpl();
    }

    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity)((RequiresChannelUrl)((HttpSecurity)((AuthorizedUrl)((AuthorizedUrl)((AuthorizedUrl)((AuthorizedUrl)((AuthorizedUrl)((HttpSecurity)((HttpSecurity)((FormLoginConfigurer)http.formLogin().loginPage("/login").loginProcessingUrl("/login/signIn")).successForwardUrl("/login/return0").failureForwardUrl("/login/return1").usernameParameter("username").passwordParameter("password").and()).logout().logoutUrl("/login/signOut").logoutSuccessUrl("/login/return0").and()).authorizeRequests().antMatchers(new String[]{"/user/**"})).authenticated().antMatchers(new String[]{"/student/**"})).hasAnyRole(new String[]{"STUDENT", "ADMIN"}).antMatchers(new String[]{"/teacher/**"})).hasAnyRole(new String[]{"TEACHER", "ADMIN"}).antMatchers(new String[]{"/admin/**"})).hasRole("ADMIN").anyRequest()).permitAll().and()).requiresChannel().antMatchers(new String[]{"register", "login"})).requiresSecure().and()).csrf().disable();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService());
    }
}
