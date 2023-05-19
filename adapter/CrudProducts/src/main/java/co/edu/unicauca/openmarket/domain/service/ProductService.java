package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.IProductRepository;
import co.unicauca.openmarket.client.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brayan
 */
public class ProductService  {
      
    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
   public ProductService(){
    
   }
   
   
    private IProductRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }
    

    public boolean saveProduct(String name, String description,Long categoryId) {
        
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setCategoryId(categoryId);
        
        
        //Validate product
        if (newProduct.getName().isBlank() ) {
            return false;
        }

        return repository.save(newProduct);

    }

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();

        return products;
    }
    
    public Product findProductById(Long id){
        return repository.findById(id);
    }
    public List<Product> findProductsByName(String name) {
        List<Product> products = new ArrayList<>();
        products = repository.findByName(name);

        return products;
    }
    public List<Product> findProductsByCategory(Long  categoryId) {
        List<Product> products = new ArrayList<>();
        products = repository.findByCategory(categoryId);

        return products;
    }
    public boolean deleteProduct(Long id){
        
        return repository.delete(id);
       
    }

    public boolean editProduct(Long productId, String name,String description,Long categoryId) {
        Product producto=new Product();
        producto.setName(name);
        producto.setDescription(description);
        producto.setCategoryId(categoryId);
        //Validate product
        if (productId == null || producto.getName().isBlank() ) {
            return false;
        }
        return repository.edit(productId,producto);

    }

  

}