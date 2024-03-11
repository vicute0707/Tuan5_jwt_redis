/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package np.com.ngopal.spring.boot.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import np.com.ngopal.spring.boot.redis.jwt.TokenAuthenticationService;
import np.com.ngopal.spring.boot.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    @Autowired
    private RedisService redisService;
    
    @Value("${ENC_KEY}")
    private String encKey;

    @Bean
    public TokenAuthenticationService tokenAuthService() {
        return new TokenAuthenticationService(redisService,encKey);
    }
    
    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
