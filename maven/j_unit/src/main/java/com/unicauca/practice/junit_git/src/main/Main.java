/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.practice.junit_git.src.main;

import com.unicauca.practice.junit_git.src.sorting.SortingPractice;
import com.unicauca.practice.junit_git.src.sorting.util.SortingUtil;
/**
 *
 * @author sahydo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortingPractice practice = new SortingPractice(new int[] {3,25,6,8,83,32,5,7,1}, SortingUtil.BUBBLE_SORT);
        practice.sort();      
    }
    
}
