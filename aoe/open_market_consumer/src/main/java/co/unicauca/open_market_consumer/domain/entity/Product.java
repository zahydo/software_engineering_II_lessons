/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.open_market_consumer.domain.entity;

import lombok.Data;

/**
 *
 * @author RodAlejo
 */
@Data
public class Product {
    private Long productId;
    private String name;
    private double price;
}
