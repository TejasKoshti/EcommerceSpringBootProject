package SpringSecurityDemo1.springSecurityDemo01.Controller;

import SpringSecurityDemo1.springSecurityDemo01.Model.Cart;
import SpringSecurityDemo1.springSecurityDemo01.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/addProductToCart/{id}")
    public String addProductToCart(@PathVariable int id){
        cartService.addProductToCart(id);
        return "redirect:/product/display";
    }

    @GetMapping("/displayCart")
    public String displayCartProducts(Model model){
       List<Cart> cartList= cartService.getAllCartProduct();
       model.addAttribute("cartList",cartList);
       return "cartProduct";
    }

    @GetMapping("/increaseProductToCart/{id}")
    public String increaseProductToCart(@PathVariable int id){
        cartService.addProductToCart(id);
        return "redirect:/cart/displayCart";
    }

    @GetMapping("/decreaseProductToCart/{id}")
    public String decreaseProductToCart(@PathVariable int id){
        cartService.decreaseProductToCart(id);
        return "redirect:/cart/displayCart";
    }

    @GetMapping("/decreaseProductQty/{id}")
    public String decreaseProductQty(int id){
        cartService.decreaseProductQty(id);
        return "redirect:/cart/displayCart";
    }

    @GetMapping("/increaseProductQty/{id}")
    public String increaseProductQty(int id){
        cartService.increaseProductQty(id);
        return "redirect:/cart/displayCart";
    }
}
