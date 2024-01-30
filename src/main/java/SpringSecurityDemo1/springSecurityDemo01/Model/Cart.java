package SpringSecurityDemo1.springSecurityDemo01.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    private int productId;

    private String productName;

    private double productPrice;

    private double productDiscountedPrice;

    private String productQty;

    private int tempQty;
}
