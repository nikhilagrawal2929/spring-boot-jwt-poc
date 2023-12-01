import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .httpBasic()
                .and()
            .headers()
                .httpStrictTransportSecurity()
                    .includeSubDomains(true)
                    .maxAgeInSeconds(31536000)
                    .preload(true)
                    .and()
                .contentSecurityPolicy("default-src 'self';")
                .and()
            .xssProtection()
                .block(true)
                .and()
            .frameOptions()
                .deny()
                .and()
            .contentTypeOptions()
                .nosniff()
                .and()
            .referrerPolicy()
                .strictOrigin()
                .and()
            .cacheControl()
                .noCache()
                .and()
            .addHeaderWriter((request, response) -> {
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
                response.setHeader("Access-Control-Allow-Origin", process.env.DOMAIN_NAME);
                response.setHeader("Permissions-Policy", "geolocation=(), midi=(), sync-xhr=(), microphone=(), camera=(), magnetometer=(), gyroscope=(), fullscreen=self, payment=0");
            });
    }

    // Other configurations or beans if needed
}
