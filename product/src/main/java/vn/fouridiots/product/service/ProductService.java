package vn.fouridiots.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.validation.BindingResult;
import vn.fouridiots.product.entity.Product;
import vn.fouridiots.product.requestmodel.SearchingParamRequestModel;

/**
 * @author DUY
 */
public interface ProductService {

    /**
     * Search product by category, power, luminous flux
     *
     * @param searchingParamRequestModel filter value
     * @param page page number
     * @param size size of page
     * @return Product List
     */
    Page<Product> findProductBy(SearchingParamRequestModel searchingParamRequestModel, short page, short size);

    Page<Product> getAllProduct(Pageable pageable);

    void createProduct(Product product, BindingResult bindingResult);
}
