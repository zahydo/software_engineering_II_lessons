/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.openmarket.config;

import com.unicauca.openmarket.domain.entity.Product;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author brayan
 */
public interface IRabbitMQConfig {
    void connection(Product product, String action) throws IOException, TimeoutException;
}
