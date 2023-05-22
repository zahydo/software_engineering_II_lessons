package co.edu.unicauca.openmarket.domain.service;

import java.util.List;

import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Product;

/**
 *
 * @author Libardo, Julio
 */
public class ProductService {

    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
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

    public boolean saveProduct(String name, String description) {

        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);

        //Validate product
        if (newProduct.getName().isEmpty()) {
            return false;
        }

        return repository.save(newProduct);

    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }

    public Product findProductById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteProduct(Long id) {
        return repository.delete(id);
    }

    public boolean editProduct(Long productId, Product prod) {

        //Validate product
        if (prod == null || prod.getName().isEmpty()) {
            return false;
        }
        return repository.edit(productId, prod);
    }

}
