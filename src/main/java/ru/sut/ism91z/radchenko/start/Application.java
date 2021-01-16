package ru.sut.ism91z.radchenko.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import ru.sut.ism91z.radchenko.model.Customer;
import ru.sut.ism91z.radchenko.service.CustomerService;

@ComponentScan(basePackages = "ru.sut.ism91z.radchenko.config," +
                              "ru.sut.ism91z.radchenko.service," +
                              "ru.sut.ism91z.radchenko.aspect")
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        Customer customer = (Customer) context.getBean("regularCustomer");
        CustomerService customerService = (CustomerService) context.getBean("customerService");

        System.out.println("Calling customer service...");
        System.out.println("****************");
        Integer someValue = customerService.printAbout(customer);
        System.out.println("****************");
        System.out.println("Calling end, returned value is: " + someValue);
    }
}
