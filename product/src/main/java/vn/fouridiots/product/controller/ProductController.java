package vn.fouridiots.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import vn.fouridiots.product.config.ProductUriNaming;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.requestmodel.SearchingParamRequestModel;
import vn.fouridiots.product.service.ProductService;

/**
 * @author DUY
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(ProductUriNaming.API_VERSION)
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * Search Product By Filter
     * @param params filter value
     * @param page page number
     * @return List of product corresponding to page number
     */
    @GetMapping(ProductUriNaming.PRODUCT_FILTER)
    public ResponseEntity<Page<Product>> searchProduct(
            @RequestBody SearchingParamRequestModel params,
            @PathVariable short page
    ) {
        Page<Product> products = productService.findProductBy(params, page, params.getSize());
        return ResponseEntity.ok(products);
    }

    @GetMapping(ProductUriNaming.PRODUCT)
    public ResponseEntity<Page<Product>> getAllProductList(@RequestParam(defaultValue = "1") int page,
                                                           @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.getAllProduct(pageable);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(products);
    }

    @PostMapping(ProductUriNaming.PRODUCT)
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product){
        try {
            productService.createProduct(product);
            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
