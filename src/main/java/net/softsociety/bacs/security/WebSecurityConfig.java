package net.softsociety.bacs.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * Security 설정
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    @Autowired
    private DataSource dataSource;

    // 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .httpBasic().disable()
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManagement) -> {
                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authorizeRequests((authorizeRequests) -> {
                    authorizeRequests
                            .anyRequest()
                            .permitAll();
                });
//                .antMatchers("/**", "/image/**", "/css/**", "/js/**", "/member/join", "/member/checkid",
//                        "/thymeleaf", "/error", "/**")
//                .permitAll() // 설정한 리소스의 접근을 인증절차 없이 허용
//                .antMatchers("/admin", "/admin/members", "/admin/reply", "/admin/board") // 설정한 리소스의 접근을
//                // 관리자만 허용
//                    .hasRole("ADMIN").anyRequest().authenticated() // 위의 경로 외에는 모두 로그인을 해야 함
//                .and()
//                .formLogin() // 일반적인 폼을 이용한 로그인 처리/실패 방법을 사용
//                    .loginPage("/member/login")
//                    .loginProcessingUrl("/member/login")
//                    .permitAll() // 인증 처리를 하는 URL을 설정. 로그인 폼의 action으로 지정
//                .usernameParameter("userId") // 로그인폼의 아이디 입력란의 name
//                .passwordParameter("userPw") // 로그인폼의 비밀번호 입력란의 name
//                .and().logout().logoutUrl("/member/logout") // 로그아웃 처리 URL
//                .logoutSuccessUrl("/").permitAll() // 로그아웃시에 이동할 경로
//                .and().cors().and().httpBasic();
        return http.build();
    }

    // 인증을 위한 쿼리
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                // 인증 (로그인)
                .usersByUsernameQuery("select userId username, userPw password, enabled "
                        + "from BACS_USER " + "where userid = ?")
                // 권한
                .authoritiesByUsernameQuery("select userid username, rolename role_name "
                        + "from BACS_USER " + "where userid = ?");
    }

    // 단방향 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecureRandom secureRandom() throws NoSuchAlgorithmException {
        return SecureRandom.getInstanceStrong(); // use JDK default set
    }

    @Bean
    public Encoder encoder() {
        return Base64.getUrlEncoder().withoutPadding();
    }
}
