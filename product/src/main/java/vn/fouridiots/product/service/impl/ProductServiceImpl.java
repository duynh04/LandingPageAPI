package vn.fouridiots.product.service.impl;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.repository.ProductRepository;
import vn.fouridiots.product.service.ProductService;

import java.util.List;

/**
 * @author DUY
 * @author ThanhNT
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Iterable<Product> findProductBy(Predicate predicate) {
        return productRepository.findAll(predicate);
    }
}
