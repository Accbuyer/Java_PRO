package courses.Java_PRO.task_5.controller;

import courses.Java_PRO.task_5.dto.Product;
import courses.Java_PRO.task_5.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productRepository.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @GetMapping("/user/{userId}")
    public List<Product> getProductsByUserId(@PathVariable Long userId) {
        return productRepository.findProductsByUserId(userId);
    }
}
