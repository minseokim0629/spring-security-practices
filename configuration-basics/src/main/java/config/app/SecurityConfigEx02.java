package config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigEx02 {
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() { //customizing
	    return new WebSecurityCustomizer() {
	        @Override
	        public void customize(WebSecurity web) {
	            web
	                .ignoring()
	                .requestMatchers(new AntPathRequestMatcher("/assets/**"));
	        }
	    };
	}
	
	// 요즘 Spring Security는 다 이렇게 쓴다
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Throwable{ // http : SecurityBuilder
		return http.build(); // filterChain 생성
	}
}
