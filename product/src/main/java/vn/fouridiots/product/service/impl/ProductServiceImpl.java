package vn.fouridiots.product.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.repository.ProductRepository;
import vn.fouridiots.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
