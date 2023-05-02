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
public abstract class SortingUtil {
    public static final String BUBBLE_SORT = "bubble";
    public static final String INSERTION_SORT = "insertion";
    public static final String QUICK_SORT = "quick";
    public static final String SELECTION_SORT = "selection";
    
    protected String type;

    public SortingUtil(String type) {
        this.type = type;
    }

    protected String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public abstract int[] sort(int[] array);
}
