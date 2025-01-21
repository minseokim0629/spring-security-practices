package config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigEx05 {
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

 // 정규표현식 form ^내용$   ?(write|delete|modify|reply) -> 이중에 하나가 있던지 없던지(아예 없어도 됨) .* -> 모두 허용. 뒤에 없어도 됨
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
			.formLogin((formLogin) -> {
				formLogin.loginPage("/user/login");
			})
			.authorizeHttpRequests((authorizeRequests) -> {
				/* ACL */
				// new RegexRequestMatcher("^/board/?(write|delete|modify|reply).*$", null 이것에 대해서는 인증을 받고 나머지는 모두 통과 
				// null -> get, post 둘다 가능
				authorizeRequests
					.requestMatchers(new RegexRequestMatcher("^/board/?(write|delete|modify|reply).*$", null)).authenticated()
					.anyRequest()
					.permitAll();
			});
        return http.build();
    }
}
