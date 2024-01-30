package SpringSecurityDemo1.springSecurityDemo01.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "subCategory")
    private String subCategory;

    @Column(name = "productQty")
    private String productQty;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "discounted_price")
    private double discountedPrice;
}
