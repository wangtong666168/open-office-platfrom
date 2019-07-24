package zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerApplication extends WebSecurityConfigurerAdapter {


    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/login", "/uaa/**","/user/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.csrf()
				.disable();
    }
}
