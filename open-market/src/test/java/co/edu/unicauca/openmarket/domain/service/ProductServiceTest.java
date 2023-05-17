package co.edu.unicauca.openmarket.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Product;

public class ProductServiceTest {

  private ProductService service;
  private IProductRepository repository;

  public ProductServiceTest() {
    repository = Factory.getInstance().getRepository("adapter");
    service = new ProductService(repository);
  }

  @BeforeEach
  public void clean() {
    for (Product product : repository.findAll()) {
      repository.delete(product.getProductId());
    }
  }

  @Test
  @DisplayName("Guardar un producto")
  public void testSaveProduct() {
    assertTrue(this.service.saveProduct("Test Product", "This is a test product."));
  }

  @Test
  @DisplayName("Guardar un producto con nombre invalido")
  public void testSaveProductInvalidName() {
    assertFalse(this.service.saveProduct("", "This is an invalid product."));
  }

  @Test
  @DisplayName("Buscar todos los productos")
  public void testFindAllProducts() {
    this.service.saveProduct("Test Product", "This is a test product.");
    List<Product> products = this.service.findAllProducts();
    assertEquals(1, products.size());
  }

  @Test
  @DisplayName("Buscar un producto por id")
  public void testFindProductById() {
    this.service.saveProduct("Test Product", "This is a test product.");
    Product firstProduct = this.service.findAllProducts().get(0);
    Product product = this.service.findProductById(firstProduct.getProductId());
    assertNotNull(product);
    assertEquals(1L, product.getProductId().longValue());
  }

  @Test
  @DisplayName("Buscar un producto por id no encontrado")
  public void testFindProductByIdNotFound() {
    Product product = this.service.findProductById(10L);
    assertNull(product);
  }

  @Test
  @DisplayName("Borrar un producto")
  public void testDeleteProduct() {
    this.service.saveProduct("Test Product", "This is a test product.");
    Product firstProduct = this.service.findAllProducts().get(0);
    boolean result = this.service.deleteProduct(firstProduct.getProductId());
    assertTrue(result);
  }

  @Test
  @DisplayName("Borrar un producto no encontrado")
  public void testDeleteProductNotFound() {
    boolean result = this.service.deleteProduct(10L);
    assertFalse(result);
  }

  @Test
  @DisplayName("Editar un producto")
  public void testEditProduct() {
    this.service.saveProduct("Test Product", "This is a test product.");
    Product firstProduct = this.service.findAllProducts().get(0);
    Product product = new Product();
    product.setProductId(firstProduct.getProductId());
    product.setName("Test Product");
    product.setDescription("This is an updated product.");
    boolean result =
      this.service.editProduct(firstProduct.getProductId(), product);
    assertTrue(result);
  }

  @Test
  @DisplayName("Editar un producto no encontrado")
  public void testEditProductNotFound() {
    Product product = new Product();
    product.setProductId(10L);
    product.setName("Test Product");
    product.setDescription("This is an updated product.");
    boolean result = this.service.editProduct(10L, product);
    assertFalse(result);
  }
}
