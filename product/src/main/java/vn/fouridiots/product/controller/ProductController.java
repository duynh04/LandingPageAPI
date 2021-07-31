package vn.fouridiots.product.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.model.QProduct;
import vn.fouridiots.product.service.ProductService;

@RestController
@RequestMapping("v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/product/find")
    public ResponseEntity<Iterable<Product>> find(@RequestParam Long id, @RequestParam String name) {
        QProduct product = QProduct.product;
        BooleanExpression hasId = product.id.eq(id);
        BooleanExpression hasName = product.category.name.contains(name);
        Iterable<Product> products = productService.findProductBy(hasId.and(hasName));
        return ResponseEntity.ok(products);
    }
}
