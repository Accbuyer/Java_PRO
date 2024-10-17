package courses.Java_PRO.task_5.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private  Long id;
    private  String accountNumber;
    private  double balance;
    private  String productType;

    public Product(Long id, String accountNumber, double balance, String productType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }
}