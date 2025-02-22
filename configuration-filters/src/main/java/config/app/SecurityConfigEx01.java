package config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigEx01 {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web
                    .ignoring()
                    .requestMatchers(new AntPathRequestMatcher("/assets/**"));
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	//formLogin().loginPage("").successUrl("/") 5.대 버전 지금은 폐지되고 이렇게 구현하는 방식으로 변경
    	/*
    	 * http
    		.formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>(){

				@Override
				public void customize(FormLoginConfigurer<HttpSecurity> t) {
					// TODO Auto-generated method stub
					
				}
    		
    		});
    	 */
    	http
    		.formLogin((formLogin) -> {
    		});

        return http.build();
    }
}
