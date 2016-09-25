package com.adapsy.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@Order(-1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	static final String PROCESSING_URL = "/_app/sign_in";
	static final String USERNAME_PARAMETER = "adtruster_account[email]";
	static final String PASSWORD_PARAMETER = "adthruster_account[password]";
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select email, mot_de_passe, actif from utilisateur where email=?")
		.authoritiesByUsernameQuery("select email, role from utilisateur_role where email=?");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs");
		web.ignoring().antMatchers("/configuration/ui");
		web.ignoring().antMatchers("/swagger-resources");
		web.ignoring().antMatchers("/configuration/security");
		web.ignoring().antMatchers("/swagger-ui.html");
		web.ignoring().antMatchers("/webjars/**");
		web.ignoring().antMatchers("/static/**");
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/js/**");
		web.ignoring().antMatchers("/img/**");
		web.ignoring().antMatchers("/");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
		http.formLogin().loginProcessingUrl(PROCESSING_URL).usernameParameter(USERNAME_PARAMETER).passwordParameter(PASSWORD_PARAMETER);
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/login**").anonymous();
		http.authorizeRequests().antMatchers(PROCESSING_URL).anonymous();
		http.authorizeRequests().antMatchers("/logout").anonymous();
		http.logout().logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}

}
