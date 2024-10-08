package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.Stack;
import edu.grinnell.csc207.linear.LinkedStack;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */ 
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    
  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();
    Stack<Integer> indexes = new LinkedStack<Integer>();
    char []strArr = str.toCharArray();
    for (int i = 0; i < strArr.length; i++) {
      if (strArr[i] == '(') {
        parens.put(strArr[i]);
        indexes.put(i);
      } else if (strArr[i] == ')') {
        try {
          parens.pop();
          indexes.pop();
        } catch (Exception e) {
          System.err.printf("We cannot additional closing paren at index: %d", i);
          return false;
        }
      } // else if
    } // for

    while(!(indexes.isEmpty())) {
      System.err.printf("Error at: ");
      System.out.printf("%d  \n", indexes.get());
    }
    return parens.isEmpty();
  } // checkMatching

  public static void printMatching(String str) throws Exception {
    Stack<Character> chars = new LinkedStack<Character>();
    Stack<Integer> indices = new LinkedStack<Integer>();
    char[] arr = str.toCharArray();
    System.out.println(str);
    try {
      for (int i = 0; i < arr.length; i++) {
        char c = arr[i];
        switch (c) {
          case '(':
            chars.push(c);
            indices.push(i);
            break;
          case ')':
            int index = indices.get();
            String message = " ".repeat(index);
            message += "+";
            message += "-".repeat(i - index - 1);
            message += "+";
            System.out.println(message);
        }
      }
    } catch (Exception e) {
      String error = "Unresolved parens at the following indices: ";
      for (Integer i : indices) {
        error += i + " ";
      }
      throw new Exception(error);
    }

  }
} // class StringUtils    

