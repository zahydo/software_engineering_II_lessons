package co.edu.unicauca.openmarket.access.adapter;

import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Product;
import java.util.List;

public class MemoryAdapterProductRepository implements IProductRepository {

    private final ProductArrayService productArrayService;

    public MemoryAdapterProductRepository() {
        productArrayService = new ProductArrayService();
    }


    @Override
    public boolean save(Product newProduct, Long categoryId) {
        newProduct.setCategoryId(categoryId);
        return this.productArrayService.upsertProduct(newProduct, true) != null;
    }

    @Override
    public boolean edit(Long id, Product product, Long categoryId) {
        product.setProductId(id);
        return this.productArrayService.upsertProduct(product,false)!=null;
    }

    @Override
    public boolean delete(Long id) {
        return this.productArrayService.deleteProduct(id);
    }

    @Override
    public Product findById(Long id) {
        return this.productArrayService.findProductById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.productArrayService.findProductByName(name);
    }

    @Override
    public List<Product> findByCategory(String categoryName) {
        return this.productArrayService.findProductByName(categoryName);
    }

    @Override
    public List<Product> findAll() {
        return this.productArrayService.getProducts();
    }
}
