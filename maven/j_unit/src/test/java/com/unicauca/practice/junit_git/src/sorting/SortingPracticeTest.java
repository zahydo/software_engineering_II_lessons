/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.practice.junit_git.src.sorting;

import com.unicauca.practice.junit_git.src.sorting.util.SortingUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sahydo
 */
public class SortingPracticeTest {

    private final int[] testArray = new int[]{4, 5, 2, 3, 1};
    private final int[] orderedArray = new int[]{1, 2, 3, 4, 5};

    public SortingPracticeTest() {
    }

    /**
     * Test of sort method, of class SortingPractice.
     */
    @Test
    @DisplayName("Bubble sorting test")
    public void testBubbleSort() {
        SortingPractice sortingPractice = new SortingPractice(testArray.clone(), SortingUtil.BUBBLE_SORT);
        sortingPractice.sort();
        assertArrayEquals(orderedArray, sortingPractice.getArray());
    }

    @Test
    @DisplayName("Insertion sorting test")
    public void testInsertionSort() {
        SortingPractice sortingPractice = new SortingPractice(testArray.clone(), SortingUtil.INSERTION_SORT);
        sortingPractice.sort();
        assertArrayEquals(orderedArray, sortingPractice.getArray());
        fail("The test has failed");
    }

    @Test
    @DisplayName("Selection sorting test")
    public void testSelectionSort() {
        SortingPractice sortingPractice = new SortingPractice(testArray.clone(), SortingUtil.SELECTION_SORT);
        sortingPractice.sort();
        assertArrayEquals(orderedArray, sortingPractice.getArray());
    }

    @Test
    @DisplayName("Quick sorting test")
    public void testQuickSort() {
        // Not implemented yet
    }

}
