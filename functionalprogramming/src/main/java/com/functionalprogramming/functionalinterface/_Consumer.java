package com.functionalprogramming.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer vishal = new Customer("Vishal", "999999");
        //Normal java function
        greetCustomer(vishal);

        // Consumer Functional Interface
        greetCustomerConsumer.accept(vishal);

        greetCustomerConsumerV2.accept(vishal, true);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> 
            System.out.println(
              "Hello " + customer.customerName 
              + ", thanks for registering phone number " + 
                (showPhoneNumber ? customer.customerPhoneNumber : "**********")
              );

    static Consumer<Customer> greetCustomerConsumer = customer -> 
            System.out.println("Hello " + customer.customerName 
              + ", thanks for registering phone number " + 
              customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName 
              + ", thanks for registering phone number " + 
              customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;  
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
          this.customerName = customerName;
          this.customerPhoneNumber = customerPhoneNumber;
        }

    }
}
