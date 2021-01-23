package ru.sut.ism91z.radchenko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sut.ism91z.radchenko.model.Customer;

import java.util.concurrent.atomic.AtomicLong;

@Configuration
public class CustomerConfig {

    private static final AtomicLong idCounter = new AtomicLong(1);

    @Bean
    public Customer regularCustomer() {
        return new Customer(idCounter.getAndIncrement(), "Regular Customer", "sut.ru", "Magadan", false);
    }
}
