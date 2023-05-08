package co.edu.unicauca.openmarket.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService service;
    private IProductRepository repository;

    public ProductServiceTest() {
        repository = new MockProductRepository();
        service = new ProductService(repository);
    }

    @Test
    public void testSaveProduct() {
        boolean result
                = this.service.saveProduct("Test Product", "This is a test product.");
        assertTrue(result);
    }

    @Test
    public void testSaveProductInvalidName() {
        boolean result
                = this.service.saveProduct("", "This is an invalid product.");
        assertFalse(result);
    }

    @Test
    public void testFindAllProducts() {
        List<Product> products = this.service.findAllProducts();
        assertEquals(2, products.size());
    }

    @Test
    public void testFindProductById() {
        Product product = this.service.findProductById(1L);
        assertNotNull(product);
        assertEquals(1L, product.getProductId().longValue());
    }

    @Test
    public void testFindProductByIdNotFound() {
        Product product = this.service.findProductById(10L);
        assertNull(product);
    }

    @Test
    public void testDeleteProduct() {
        boolean result = this.service.deleteProduct(1L);
        assertTrue(result);
    }

    @Test
    public void testDeleteProductNotFound() {
        boolean result = this.service.deleteProduct(10L);
        assertFalse(result);
    }

    @Test
    public void testEditProduct() {
        Product product = new Product();
        product.setProductId(1L);
        product.setName("Test Product");
        product.setDescription("This is an updated product.");
        boolean result = this.service.editProduct(1L, product);
        assertTrue(result);
    }

    @Test
    public void testEditProductNotFound() {
        Product product = new Product();
        product.setProductId(10L);
        product.setName("Test Product");
        product.setDescription("This is an updated product.");
        boolean result = this.service.editProduct(10L, product);
        assertFalse(result);
    }

    private class MockProductRepository implements IProductRepository {

        private List<Product> products;

        public MockProductRepository() {
            products = new ArrayList<>();
            Product product1 = new Product();
            product1.setProductId(1L);
            product1.setName("Product 1");
            product1.setDescription("This is product 1.");
            Product product2 = new Product();
            product2.setProductId(2L);
            product2.setName("Product 2");
            product2.setDescription("This is product 2.");
            products.add(product1);
            products.add(product2);
        }

        @Override
        public boolean save(Product product) {
            products.add(product);
            return true;
        }

        @Override
        public List<Product> findAll() {
            return products;
        }

        @Override
        public Product findById(Long id) {
            for (Product product : products) {
                if (product.getProductId().equals(id)) {
                    return product;
                }
            }
            return null;
        }

        @Override
        public boolean delete(Long id) {
            Product product = findById(id);
            if (product != null) {
                products.remove(product);
                return true;
            }
            return false;
        }

        @Override
        public boolean edit(Long id, Product product) {
            Product productToUpdate = findById(id);
            if (productToUpdate != null) {
                productToUpdate.setName(product.getName());
                productToUpdate.setDescription(product.getDescription());
                return true;
            }
            return false;
        }

        @Override
        public List<Product> findByName(String name) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
