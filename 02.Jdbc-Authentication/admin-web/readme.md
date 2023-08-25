# Jdbc Authentication

```java

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService users(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public static PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
```

http://localhost:8080/
username and password: user/password

<img width="1156" alt="Screenshot 2023-08-24 at 10 23 16 PM" src="https://github.com/javaHelper/Spring-Spring-Security/assets/54174687/5795dccb-192b-494d-808f-e8f76c1b6976">

<img width="1337" alt="Screenshot 2023-08-24 at 10 23 26 PM" src="https://github.com/javaHelper/Spring-Spring-Security/assets/54174687/065c596a-2ec0-4e1a-95fd-086569b98f28">

<img width="1141" alt="Screenshot 2023-08-24 at 10 23 34 PM" src="https://github.com/javaHelper/Spring-Spring-Security/assets/54174687/50aa5cba-ec6e-443f-8753-8d9f0af61919">



