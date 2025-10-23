package net.youssouf.billingservice.web;

import net.youssouf.billingservice.entities.Bill;
import net.youssouf.billingservice.feign.CustomerRestClient;
import net.youssouf.billingservice.feign.ProductRestClient;
import net.youssouf.billingservice.repository.BillRepository;
import net.youssouf.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    @Autowired
    CustomerRestClient customerRestClient;
   @Autowired
    ProductRestClient productRestClient;

   @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }
}
