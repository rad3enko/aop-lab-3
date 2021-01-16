package ru.sut.ism91z.radchenko.service;

import ru.sut.ism91z.radchenko.model.Customer;

public interface CustomerService {
    /**
     * Just for the AOP demo this method returns a random int generated inside the method
     * @param c customer
     */
    Integer printAbout(Customer c);
}
