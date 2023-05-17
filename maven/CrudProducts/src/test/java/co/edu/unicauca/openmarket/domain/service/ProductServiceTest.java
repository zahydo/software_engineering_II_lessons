package co.edu.unicauca.openmarket.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService service;
    private IProductRepository repository;

    public ProductServiceTest() {
        repository = Factory.getInstance().getRepository("adapter");
        service = new ProductService(repository);
    }

    @Test
    public void testSaveProduct() {
        boolean result = this.service.saveProduct("Test Product", "This is a test product.");
        assertTrue(result);
    }

    @Test
    public void testSaveProductInvalidName() {
        boolean result = this.service.saveProduct("", "This is an invalid product.");
        assertFalse(result);
    }

    @Test
    public void testFindAllProducts() {
        this.service.saveProduct("Test Product", "This is a test product.");
        List<Product> products = this.service.findAllProducts();
        assertEquals(1, products.size());
    }

    @Test
    public void testFindProductById() {
        this.service.saveProduct("Test Product", "This is a test product.");
        Product firstProduct = this.service.findAllProducts().get(0);
        Product product = this.service.findProductById(firstProduct.getProductId());
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
        this.service.saveProduct("Test Product", "This is a test product.");
        Product firstProduct = this.service.findAllProducts().get(0);
        boolean result = this.service.deleteProduct(firstProduct.getProductId());
        assertTrue(result);
    }

    @Test
    public void testDeleteProductNotFound() {
        boolean result = this.service.deleteProduct(10L);
        assertFalse(result);
    }

    @Test
    public void testEditProduct() {
        this.service.saveProduct("Test Product", "This is a test product.");
        Product firstProduct = this.service.findAllProducts().get(0);
        Product product = new Product();
        product.setProductId(firstProduct.getProductId());
        product.setName("Test Product");
        product.setDescription("This is an updated product.");
        boolean result = this.service.editProduct(firstProduct.getProductId(), product);
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

}
