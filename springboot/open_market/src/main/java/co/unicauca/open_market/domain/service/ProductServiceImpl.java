package co.unicauca.open_market.domain.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.open_market.access.dao.IProductRepository;
import co.unicauca.open_market.domain.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    @Transactional(readOnly=true)
    public List<Product> findAll() {
        return (List<Product>) this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product find(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public Product create(Product product) {
        return this.repository.save(product);
    }

    @Override
    @Transactional(readOnly = false)
    public Product update(Long id, Product product) {
        product = find(id);
        return this.repository.save(product);
    }
    @Override
    @Transactional(readOnly = false)
    public Product delete(Long id) {
        Product deleteProduct = find(id);
        this.repository.delete(deleteProduct);
        return deleteProduct;
    }


}
