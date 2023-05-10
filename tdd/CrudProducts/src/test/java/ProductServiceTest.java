

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ProductServiceTest {

  private ProductService service;
  private IProductRepository repository;



  public ProductServiceTest() {
    repository = new MockProductRepository();
    service = new ProductService(repository);
  }

  @Test
  public void testSaveProduct() {
    boolean result =
      this.service.saveProduct("Test Product", "This is a test product.",new Category(1L,"categoria1"));
    assertTrue(result);
  }

  @Test
  public void testSaveProductInvalidName() {
    boolean result =
      this.service.saveProduct("", "This is an invalid product.",new Category());
    assertFalse(result);
  }

  @Test
  public void testFindAllProducts() {
    List<Product> products = this.service.findAllProducts();
    assertEquals(3, products.size());
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

  @Test
  public void testFindBynameAssert(){
    List<Product> productos = new ArrayList<>();
    productos = this.service.findByName("Product 1");
    assertEquals(1L, productos.get(0).getProductId().longValue());
  }

  @Test
  public void testFindBynameNotFound(){
    List<Product> productos = new ArrayList<>();
    productos = this.service.findByName("Product 3");
    assertEquals(0, productos.size());
  }

  @Test
  public void testFindByCategoryIdAssert(){
    List<Product> productos = new ArrayList<>();
    productos = this.service.findByCategoryID(1L);
    assertEquals(1L, productos.get(0).getProductId().longValue());
  }

  @Test
  public void testFindByCategoryIdNotFound(){
    List<Product> productos = new ArrayList<>();
    productos = this.service.findByCategoryID(3L);
    assertEquals(0, productos.size());
  }

  private class MockProductRepository implements IProductRepository {

    private List<Product> products;

    public MockProductRepository() {
      products = new ArrayList<>();
      Category categoria1 = new Category(1L,"category1");
      Category categoria2 = new Category(2L,"category2");
      Product product1 = new Product();
      product1.setProductId(1L);
      product1.setName("Product 1");
      product1.setDescription("This is product 1.");
      product1.setCategory(categoria1);
      Product product2 = new Product();
      product2.setProductId(2L);
      product2.setName("Product 2");
      product2.setDescription("This is product 2.");
      product2.setCategory(categoria2);
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
   public List<Product> findByName(String name){
    List<Product> productos = new ArrayList<>();
    for (Product product : products) {
      if (product.getName().equals(name)) {
        productos.add(product);
      }
    }
    return productos;
   }

   @Override
   public List<Product> findByCategoryID(Long id){
    List<Product> productos = new ArrayList<>();
    for (Product product : products) {
      if (product.getCategory().getCategoryId().equals(id)) {
        productos.add(product);
      }
    }
    return productos;
   }



    
  }
}