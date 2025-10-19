package net.youssouf.customerservice.repository;

import net.youssouf.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource  //demander a spring de demarer automatiquement un web service resfull permettant d'acceder a toute les methode de cette interface
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
