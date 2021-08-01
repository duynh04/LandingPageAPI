package vn.fouridiots.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.repository.ProductRepository;
import vn.fouridiots.product.service.ProductService;
import vn.fouridiots.product.specification.ProductSpecification;

import java.util.List;
import java.util.Optional;

/**
 * @author DUY
 * @author ThanhNT
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findProductBy(Optional<String> category, Optional<Short> power, Optional<Short> luminousFlux) {
        return productRepository.findAll(Specification.where(
                ProductSpecification.hasCategory(category)
                .and(ProductSpecification.hasPower(power))
                .and(ProductSpecification.hasFlux(luminousFlux))
        ));
    }
}
