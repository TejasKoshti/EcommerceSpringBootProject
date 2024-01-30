package SpringSecurityDemo1.springSecurityDemo01.Service;

import SpringSecurityDemo1.springSecurityDemo01.Model.Product;
import SpringSecurityDemo1.springSecurityDemo01.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> displayProduct(){
        List<Product>  p=null;                      //To handle Bugs
        try{
            p=productRepository.getAllProducts();
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public void deleteProductById(int id){
        //To handle Bugs
        try{
            productRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fetchProductObject(int id) {
        try{
            productRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCurrentProduct(Product p) {
        productRepository.save(p);
    }
    public void addNewProduct(Product p) {
        productRepository.save(p);
    }
}
