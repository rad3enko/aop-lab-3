package ru.sut.ism91z.radchenko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sut.ism91z.radchenko.model.Customer;

@Configuration
public class CustomerConfig {

    private static long idCounter = 1;

    @Bean
    public Customer regularCustomer() {
        return new Customer(idCounter++, "Regular Customer", "sut.ru", "Magadan", false);
    }
}
