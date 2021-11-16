package za.ac.nwu.ga.web.sb;

import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;
import java.io.*;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootRestApplication
{
    public static void main(String[] args)
    {


        SpringApplication.run(SpringBootRestApplication.class, args);


    }

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry)
        {
            registry.addMapping("/**");
        }};
    }
}
