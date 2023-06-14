/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.openmarket.util;

/**
 *
 * @author brayan
 */
public class Constants {
    public final static String HOST_NAME = "localhost";
    public final static String EXCHANGE_TYPE = "fanout";
    public static void printStringList(String[] list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
}
