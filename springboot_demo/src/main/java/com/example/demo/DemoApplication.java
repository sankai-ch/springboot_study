package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);


    public static void main(String[] args) throws UnknownHostException {
//        SpringApplication.run(DemoApplication.class, args);
        SpringApplication application = new SpringApplication(DemoApplication.class);
        Environment environment = application.run(args).getEnvironment();

        log.info("\n----------------------------------------------------------\n\t"
                        + "Application'{}' is running! Access URLs:\n\t"
                        + "Local:\t\thttp://localhost:{}\n\t"
                        + "External: \thttp://{}:{}\n----------------------------------------------------------",
                environment.getProperty("spring.application.name"), environment.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(),
                environment.getProperty("server.port"));

    }

}
