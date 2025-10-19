package net.youssouf.customerservice;

import net.youssouf.customerservice.entities.Customer;
import net.youssouf.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
					.name("Youssouf")
					.email("youssouf@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Tangara")
					.email("tangara@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("salma")
					.email("salma@gmail.com")
					.build());

			customerRepository.findAll().forEach(customer ->{
				System.out.println("========================================================");
				System.out.println(customer.toString());
				System.out.println("========================================================");
			} );
		};
	}
}
