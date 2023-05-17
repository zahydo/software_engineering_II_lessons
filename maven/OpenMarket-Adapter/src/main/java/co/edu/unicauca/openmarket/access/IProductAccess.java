package co.edu.unicauca.openmarket.access;
import co.edu.unicauca.openmarket.domain.Product;
import java.util.List;

/**
 * Interface que define los servicios de persistencia de productos
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IProductAccess {

    boolean save(Product newProduct) throws Exception;
    
    boolean edit(Long id, Product product) throws Exception;
    
    boolean delete(Long id) throws Exception;

    Product findById(Long id) throws Exception;
    
    Product findByName (String name) throws Exception;
    
    List<Product> findAll() throws Exception;
    
    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id del producto
     * @return objeto cliente
     * @throws Exception error al buscar un cliente
     *
    public Product findProduct(String id) throws Exception;

    /**
     * Crea un Product
     *
     * @param Product producto de openMarket
     * @return devuelve el id del producto
     * @throws Exception error crear el producto
     *

    public String createProduct(Product product) throws Exception;
    */
}