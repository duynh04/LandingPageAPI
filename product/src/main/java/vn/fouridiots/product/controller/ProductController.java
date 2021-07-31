package vn.fouridiots.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.service.ProductService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/list")
    public ResponseEntity<Page<Product>> getAllProductList(@RequestParam("1") int page,
                                                           @RequestParam("10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.getAllProduct(pageable);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/product/create")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product){
        try {
            productService.createProduct(product);
            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
