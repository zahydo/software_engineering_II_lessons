
package co.edu.unicauca.openmarket.main;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.presentation.GUICategories;
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
        
        IProductRepository repository = Factory.getInstance().getProductRepository("default");
        ProductService productService = new ProductService(repository);
        
        GUIProducts instanceP = new GUIProducts(productService);
        instanceP.setVisible(true);
        
        ICategoryRepository repositoryC =  Factory.getInstance().getCategoryRepository("default");
        CategoryService categoryService = new CategoryService(repositoryC);
        
        GUICategories instanceC = new GUICategories(categoryService);
        instanceC.setVisible(true);
    }
    
}
