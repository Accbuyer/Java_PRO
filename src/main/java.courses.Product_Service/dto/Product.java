package src.main.java.courses.Product_Service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String accountNumber;
    private double balance;
    private ProductType productType;
    private String userId;

    public Product() {
    }

    public Product(Long id, String accountNumber, double balance, ProductType productType, String userId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
        this.userId = userId;
    }

}