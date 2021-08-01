package vn.fouridiots.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.fouridiots.product.model.Product;
import vn.fouridiots.product.service.ProductService;

import java.util.List;
import java.util.Optional;


/**
 * @author DUY
 */
@RestController
@RequestMapping("v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Tìm kiếm sản phẩm API
     * @param category tên category
     * @param power giá trị power
     * @param luminousFlux giá trị flux
     * @return Danh sách sản phẩm tìm được
     */
    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProduct(
            @RequestParam Optional<String> category,
            @RequestParam Optional<Short> power,
            @RequestParam Optional<Short> luminousFlux
    ) {
        List<Product> products = productService.findProductBy(category, power, luminousFlux);
        return ResponseEntity.ok(products);
    }
}
