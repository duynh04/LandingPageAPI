package vn.fouridiots.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.repository.ProductRepository;
import vn.fouridiots.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void createProduct(Product product) {
        product = new Product();
        this.productRepository.save(product);
    }
}
