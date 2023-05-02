/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.practice.junit_git.src.sorting.util;

/**
 *
 * @author sahydo
 */
public class BubbleSort extends SortingUtil {

    public BubbleSort(String type) {
        super(type);
        System.out.println("Ordering with " + this.getClass().getSimpleName());
    }

    @Override
    public int[] sort(int[] array) {
        int lastIndex = array.length - 1;
        for (int j = 0; j < lastIndex; j++) {
            for (int i = 0; i < lastIndex - j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        return array;
    }
    
}
