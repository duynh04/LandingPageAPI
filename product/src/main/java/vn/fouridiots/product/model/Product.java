package vn.fouridiots.product.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(value = "product")
public class Product {

    private String id;
    private String name;
    private float price;
}
