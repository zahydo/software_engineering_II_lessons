/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.practice.junit_git.src.sorting;

import com.unicauca.practice.junit_git.src.sorting.util.BubbleSort;
import com.unicauca.practice.junit_git.src.sorting.util.InsertionSort;
import com.unicauca.practice.junit_git.src.sorting.util.QuickSort;
import com.unicauca.practice.junit_git.src.sorting.util.SelectionSort;
import com.unicauca.practice.junit_git.src.sorting.util.SortingUtil;

/**
 *
 * @author sahydo
 */
public class SortingPractice {

  private int[] array;
  private String sortingType = SortingUtil.BUBBLE_SORT;

  public SortingPractice(int[] array, String sortingType) {
    this.array = array;
    this.sortingType = sortingType;
  }

  public SortingPractice(int[] array) {
    this.array = array;
  }

  public int[] getArray() {
    return array;
  }

  public void setArray(int[] array) {
    this.array = array;
  }

  public String getSortingType() {
    return sortingType;
  }

  public void setSortingType(String sortingType) {
    this.sortingType = sortingType;
  }

  public void sort() {
    SortingUtil sortingMethod;
    switch (this.getSortingType()) {
      case SortingUtil.BUBBLE_SORT:
        sortingMethod = new BubbleSort(this.getSortingType());
        // parameter by reference
        sortingMethod.sort(this.getArray());
        break;
      case SortingUtil.INSERTION_SORT:
        // sortingMethod = new InsertionSort(this.getSortingType());
        // sortingMethod.sort(this.getArray());
        System.err.println("Insertion sorting pending");
        break;
      case SortingUtil.QUICK_SORT:
        // sortingMethod = new QuickSort(this.getSortingType());
        // sortingMethod.sort(this.getArray());
        System.err.println("Quick sorting pending");
        break;
      case SortingUtil.SELECTION_SORT:
        // sortingMethod = new SelectionSort(this.getSortingType());
        // sortingMethod.sort(this.getArray());
        System.err.println("Selection sorting pending");
        break;
    }
  }
}
