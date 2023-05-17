package co.edu.unicauca.openmarket.main;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.*;
import co.edu.unicauca.openmarket.domain.service.*;
import co.edu.unicauca.openmarket.presentation.GUI;

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

        ICategoryRepository repositoryCategory = Factory.getInstance().getRepositoryCategory("default");
        CategoryService categoryService = new CategoryService(repositoryCategory);

        GUI instance = new GUI(productService, categoryService);
        instance.setVisible(true);

    }

}
