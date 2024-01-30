package SpringSecurityDemo1.springSecurityDemo01.Service;

import SpringSecurityDemo1.springSecurityDemo01.Model.Cart;
import SpringSecurityDemo1.springSecurityDemo01.Model.Product;
import SpringSecurityDemo1.springSecurityDemo01.Repository.CartRepository;
import SpringSecurityDemo1.springSecurityDemo01.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addProductToCart(int id){
        Product p=productRepository.getSingleProduct(id);
        Cart temp=cartRepository.getSingleCartProduct(p.getProductId());

        if(temp==null){
            Cart c=new Cart();
            c.setProductId(p.getProductId());
            c.setProductName(p.getProductName());
            c.setProductQty(p.getProductQty());
            c.setProductPrice(p.getProductPrice());
            c.setProductDiscountedPrice(p.getDiscountedPrice());
            c.setTempQty(1);
            cartRepository.save(c);
        }
        else{
            int count=temp.getTempQty();
            temp.setTempQty(++count);
            cartRepository.save(temp);
        }
    }

    public List<Cart> getAllCartProduct(){
        return cartRepository.findAll();
    }

    public void increaseProductToCart(int id){
        Product p=productRepository.getSingleProduct(id);
        Cart temp=cartRepository.getSingleCartProduct(p.getProductId());

        if(temp==null){
            Cart c=new Cart();
            c.setProductId(p.getProductId());
            c.setProductName(p.getProductName());
            c.setProductQty(p.getProductQty());
            c.setProductPrice(p.getProductPrice());
            c.setProductDiscountedPrice(p.getDiscountedPrice());
            c.setTempQty(1);
            cartRepository.save(c);
        }
        else{
            int count=temp.getTempQty();
            temp.setTempQty(++count);
            cartRepository.save(temp);
        }
    }

    public void decreaseProductToCart(int id){
        Product p=productRepository.getSingleProduct(id);
        Cart temp=cartRepository.getSingleCartProduct(p.getProductId());

        if(temp==null){
            Cart c=new Cart();
            c.setProductId(p.getProductId());
            c.setProductName(p.getProductName());
            c.setProductQty(p.getProductQty());
            c.setProductPrice(p.getProductPrice());
            c.setProductDiscountedPrice(p.getDiscountedPrice());
            c.setTempQty(1);
            cartRepository.save(c);
        }
        else{
            int count=temp.getTempQty();
            temp.setTempQty(count-1);
            cartRepository.save(temp);
            if(count==1){
                cartRepository.delete(temp);
            }
        }
    }

    public void decreaseProductQty(int id) {
        Cart c=cartRepository.getSingleCartProductByCartId(id);
        int pQty=c.getTempQty();
        if (pQty==0){
            cartRepository.deleteById(id);
        }
        c.setTempQty(pQty-1);
        cartRepository.save(c);
    }

    public void increaseProductQty(int id) {
        Cart c=cartRepository.getSingleCartProductByCartId(id);
        int pQty=c.getTempQty();

        c.setTempQty(pQty+1);
        cartRepository.save(c);
    }
}
