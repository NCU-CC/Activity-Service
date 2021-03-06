package tw.edu.ncu.cc.activity.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableScheduling
import tw.edu.ncu.cc.activity.server.config.BeanConfig
import tw.edu.ncu.cc.activity.server.config.CacheConfig
import tw.edu.ncu.cc.activity.server.config.MvcConfig
import tw.edu.ncu.cc.activity.server.config.SecurityConfig
import tw.edu.ncu.cc.springboot.config.hikaricp.EnableHikariConfiguration

@EnableHikariConfiguration
@EnableScheduling
@SpringBootApplication( exclude = [ ErrorMvcAutoConfiguration ] )
@Import( [ SecurityConfig, BeanConfig, MvcConfig, CacheConfig ] )
public class Application extends SpringBootServletInitializer {

    public static void main( String[] args ) {
        SpringApplication.run( Application.class, args )
    }

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder builder ) {
        return builder.sources( Application.class )
    }

}

