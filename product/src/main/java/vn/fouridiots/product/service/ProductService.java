package vn.fouridiots.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fouridiots.product.model.Product;

public interface ProductService {
    Page<Product> getAllProduct(Pageable pageable);

    void createProduct(Product product);
}
