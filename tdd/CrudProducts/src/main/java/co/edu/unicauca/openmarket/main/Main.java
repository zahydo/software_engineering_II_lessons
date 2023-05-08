
package co.edu.unicauca.openmarket.main;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.presentation.GUICategories;
import co.edu.unicauca.openmarket.presentation.GUIProducts;
import com.sun.tools.classfile.Attribute;

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
        ICategoryRepository categoryRep = Factory.getInstance().getCategoryRepository("default");
        
        ProductService productService = new ProductService(repository);
        CategoryService categoryService = new CategoryService(categoryRep);
        
        GUIProducts instance = new GUIProducts(productService, categoryService);
        GUICategories categoryInstance = new GUICategories(categoryService);
        
        instance.setVisible(true);
        categoryInstance.setVisible(true);
        
    }
    
}
