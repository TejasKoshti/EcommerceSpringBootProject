package SpringSecurityDemo1.springSecurityDemo01.Controller;

import SpringSecurityDemo1.springSecurityDemo01.Model.Product;
import SpringSecurityDemo1.springSecurityDemo01.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/display")
    public String displayProducts(Model model){
        List<Product> productList=productService.displayProduct();
        model.addAttribute("productList",productList);
        return "displayProducts";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProductById(id);
        return "redirect:/display";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable int id, Model model){
        productService.fetchProductObject(id);
        return "redirect:/display";
    }

    @GetMapping("/createNewProduct")
    public String createNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "addNewProduct";
    }

    @PostMapping("/addNewProduct")
    public String addProduct(Product p){
        productService.addNewProduct(p);
        return "redirect:/product/display";
    }

}
