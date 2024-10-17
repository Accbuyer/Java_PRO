package courses.Java_PRO.task_5.repository;

import courses.Java_PRO.task_5.dto.Product;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final DataSource dataSource;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveProduct(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO products (account_number, balance, product_type) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, product.getAccountNumber());
                statement.setDouble(2, product.getBalance());
                statement.setString(3, product.getProductType());
                statement.executeUpdate();

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        product.setId(generatedKeys.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product findProductById(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM products WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Product(resultSet.getLong("id"),
                                resultSet.getString("account_number"),
                                resultSet.getDouble("balance"),
                                resultSet.getString("product_type"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM products";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    products.add(new Product(resultSet.getLong("id"),
                            resultSet.getString("account_number"),
                            resultSet.getDouble("balance"),
                            resultSet.getString("product_type")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> findProductsByUserId(Long userId) {
        List<Product> products = new ArrayList<>();
        // Предполагается, что в таблице есть поле user_id
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM products WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        products.add(new Product(resultSet.getLong("id"),
                                resultSet.getString("account_number"),
                                resultSet.getDouble("balance"),
                                resultSet.getString("product_type")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
