package vn.fouridiots.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.repository.ProductRepository;
import vn.fouridiots.product.requestmodel.SearchingParamRequestModel;
import vn.fouridiots.product.service.ProductService;
import vn.fouridiots.product.specification.ProductSpecification;


/**
 * @author DUY
 * @author ThanhHN
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Page<Product> findProductBy(SearchingParamRequestModel searchingParamRequestModel, short page, short size) {
        return productRepository.findAll(Specification.where(
                ProductSpecification.hasCategory(searchingParamRequestModel.getCategory())
                .and(ProductSpecification.hasPower(searchingParamRequestModel.getPower()))
                .and(ProductSpecification.hasFlux(searchingParamRequestModel.getFlux()))
        ), PageRequest.of(page, size));
    }

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
