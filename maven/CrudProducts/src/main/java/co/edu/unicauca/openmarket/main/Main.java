package co.edu.unicauca.openmarket.main;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.*;
import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.*;


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
        ProductService productService = new ProductService(repository);

         IcategoryRepository repositoryCategory = Factory.getInstance().getRepositoryCategory("default");
        CategoryService categoryService = new CategoryService(repositoryCategory);
        

    

    }

}
