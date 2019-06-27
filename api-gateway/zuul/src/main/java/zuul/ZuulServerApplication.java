package zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
public class ZuulServerApplication extends WebSecurityConfigurerAdapter {


    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http
                .authorizeRequests().antMatchers("/login", "/client/**").permitAll() //请求路径""允许访问
                .and().authorizeRequests().anyRequest().authenticated()    //其它请求都需要校验才能访问
                .and().csrf().disable(); // 禁用csrf
    }
}
