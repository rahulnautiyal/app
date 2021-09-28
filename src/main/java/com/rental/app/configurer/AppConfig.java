package com.rental.app.configurer;

import com.rental.app.service.RentalServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RentalServiceImpl rentalService(){
        return new RentalServiceImpl();
    }

}
