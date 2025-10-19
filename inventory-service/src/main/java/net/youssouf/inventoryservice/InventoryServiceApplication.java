package net.youssouf.inventoryservice;

import net.youssouf.inventoryservice.entities.Product;
import net.youssouf.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Computer")
                            .price(3200)
                            .quantity(11)
                            .build());
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Phone")
                            .price(1200)
                            .quantity(12)
                            .build());
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Tablet")
                            .price(800)
                            .quantity(13)
                            .build());
            productRepository.findAll().forEach(product ->{
                System.out.println("========================================================");
                System.out.println(product.toString());
                System.out.println("========================================================");
            } );
        };
    }
}
