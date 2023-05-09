package co.edu.unicauca.openmarket.main;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.presentation.GUICategory;
import co.edu.unicauca.openmarket.presentation.GUIProducts;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       IProductRepository repository = Factory.getInstance().getRepository("default");
        ICategoryRepository repository2 =  Factory.getInstance().getCatRepository("default");
        ProductService productService = new ProductService(repository);
        CategoryService categoryService=new CategoryService(repository2);
        
        

        GUICategory instance1=new GUICategory(categoryService);
        instance1.setVisible(true);
        instance1.setSize(595, 380);
        instance1.setLocation(0,0);
        GUIProducts instance2 = new GUIProducts(productService);
        instance2.setVisible(true);
         instance2.setLocation(590, 0);
    }
    
}
