package SpringSecurityDemo1.springSecurityDemo01.Repository;

import SpringSecurityDemo1.springSecurityDemo01.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query(value = "select * from cart where product_id=:id",nativeQuery = true)
    public Cart getSingleCartProduct(@Param("id") int id);


    @Query(value = "select * from cart where cart_id=:id",nativeQuery = true)
    public Cart getSingleCartProductByCartId(@Param("id")int id);
}
