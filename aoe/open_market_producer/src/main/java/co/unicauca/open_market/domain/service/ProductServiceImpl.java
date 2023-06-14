package co.unicauca.open_market.domain.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.open_market.access.dao.IProductRepository;
import co.unicauca.open_market.domain.entity.LogEntry;
import co.unicauca.open_market.domain.entity.Product;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Transactional(readOnly = true)
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
        Product newProduct = this.repository.save(product);
        rabbitTemplate.convertAndSend("open-market-products-exchange", "", (String)createMessage(newProduct));
        return newProduct;
    }

    @Override
    @Transactional(readOnly = false)
    public Product update(Long id, Product product) {
        Product updateProduct = find(id);
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        rabbitTemplate.convertAndSend("open-market-products-exchange", "", (String)updateMessage(updateProduct));

        return this.repository.save(updateProduct);
    }

    @Override
    @Transactional(readOnly = false)
    public Product delete(Long id) {
        Product deleteProduct = find(id);
        this.repository.delete(deleteProduct);
        rabbitTemplate.convertAndSend("open-market-products-exchange", "", (String)deleteMessage(deleteProduct));

        return deleteProduct;
    }

    private String createMessage(Product product) {
        return buildLogEntryMessage("Create", product);
    }

    private String updateMessage(Product product) {
        return buildLogEntryMessage("Update", product);
    }

    private String deleteMessage(Product product) {
        return buildLogEntryMessage("Delete", product);
    }

    private String buildLogEntryMessage(String action, Product product) {
        LogEntry logEntry = new LogEntry();
        logEntry.setAction(action);
        logEntry.setProductId(product.getProductId());
        logEntry.setName(product.getName());
        logEntry.setPrice(product.getPrice());
        System.out.println("Send: "+ new Gson().toJson(logEntry));
        return new Gson().toJson(logEntry);
    }
}