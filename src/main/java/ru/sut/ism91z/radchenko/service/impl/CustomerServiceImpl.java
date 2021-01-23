package ru.sut.ism91z.radchenko.service.impl;

import org.springframework.stereotype.Service;
import ru.sut.ism91z.radchenko.model.Customer;
import ru.sut.ism91z.radchenko.service.CustomerService;

import java.util.Random;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private static final Random random = new Random();

    @Override
    public Integer printAbout(Customer c) {
        if (c != null) {
            System.out.println(c.toString());
        }
        return random.nextInt();
    }
}
