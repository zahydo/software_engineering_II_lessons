package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductArrayService {

  private List<Product> products;

  public ProductArrayService() {
    this.products = new ArrayList<>();
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> pProducts) {
    this.products = pProducts;
  }

  public Product upsertProduct(Product product, boolean createNewOne) {
    Product prod = null;
    for (Product p : products) {
      if (
        product.getProductId() != null &&
        p.getProductId().equals(product.getProductId())
      ) {
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategory(product.getCategory());
        p.setDescription(product.getDescription());
        p.setLocation(product.getLocation());
        p.setUser(product.getUser());

        prod = p;
        break;
      }
    }
    if (prod == null && createNewOne) {
      product.setProductId((long) (products.size() + 1));
      products.add(product);
      prod = product;
    }
    return prod;
  }

  public boolean deleteProduct(Long id) {
    for (Product p : products) {
      if (p.getProductId().equals(id)) {
        products.remove(p);
        return true;
      }
    }
    return false;
  }

  public Product findProductById(Long id) {
    for (Product p : products) {
      if (p.getProductId().equals(id)) {
        return p;
      }
    }
    return null;
  }

  public List<Product> findProductByName(String name) {
    List<Product> productsByName = new ArrayList<>();
    for (Product p : products) {
      if (p.getName().equals(name)) {
        productsByName.add(p);
      }
    }
    return productsByName;
  }
}