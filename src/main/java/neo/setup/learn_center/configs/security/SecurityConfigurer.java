package neo.setup.learn_center.configs.security;

import lombok.RequiredArgsConstructor;
import neo.setup.learn_center.configs.encryption.PasswordEncoderConfigurer;
import neo.setup.learn_center.configs.security.filters.CustomAuthenticationFilter;
import neo.setup.learn_center.configs.security.filters.CustomAuthorizationFilter;
import neo.setup.learn_center.service.auth.token.AuthTokenService;
import neo.setup.learn_center.service.auth.user.AuthUserService;
import neo.setup.learn_center.utils.BaseUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    public static final String[] WHITE_LIST = {
            "/swagger-ui/**",
            "/swagger-documentation/**",
            BaseUtils.PATH + "/login",
            BaseUtils.PATH + "/auth/login",
            BaseUtils.PATH + "/language/**",
            BaseUtils.PATH + "/auth/register"
    };

    private final AuthUserService service;
    private final AuthTokenService authTokenService;
    private final PasswordEncoderConfigurer configurer;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(configurer.encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeRequests()
                .antMatchers(WHITE_LIST)
                .permitAll()
                .anyRequest()
                .authenticated();

        http.addFilter(new CustomAuthenticationFilter(authTokenService, authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
