package net.youssouf.billingservice;

import net.youssouf.billingservice.entities.Bill;
import net.youssouf.billingservice.entities.ProductItem;
import net.youssouf.billingservice.feign.CustomerRestClient;
import net.youssouf.billingservice.feign.ProductRestClient;
import net.youssouf.billingservice.model.Customer;
import net.youssouf.billingservice.repository.BillRepository;
import net.youssouf.billingservice.repository.ProductItemRepository;
import net.youssouf.billingservice.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient) {
  return args -> {
      try {
          // Récupération des clients
          Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
          
          // Récupération des produits
          Collection<Product> products = productRestClient.getAllProducts().getContent();

          // Création des factures
          customers.forEach(customer -> {
              try {
                  Bill bill = Bill.builder()
                          .billingDate(new Date())
                          .customerId(customer.getId())
                          .build();

                  billRepository.save(bill);

                  // Ajout des produits à la facture
                  products.forEach(product -> {
                      try {
                          ProductItem productItem = ProductItem.builder()
                                  .bill(bill)
                                  .productId(product.getId())
                                  .quantity(1 + new Random().nextInt(10))
                                  .initPrice(product.getPrice())
                                  .build();
                          productItemRepository.save(productItem);
                      } catch (Exception e) {
                          System.err.println("Erreur lors de la création du produit: " + e.getMessage());
                      }
                  });
              } catch (Exception e) {
                  System.err.println("Erreur lors de la création de la facture: " + e.getMessage());
              }
          });
      } catch (Exception e) {
          System.err.println("Erreur lors de l'initialisation des données: " + e.getMessage());
          System.err.println("Le service continue de fonctionner mais sans données initiales.");
      }
  };
  }

}
