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
    for (char c : str.toCharArray()) {
      if (c == '(') {
        parens.put(c);
      } else if (c == ')') {
        try {
          parens.pop();
        } catch (Exception e) {
          return false;
        }
      } // else if
    } // for

    return parens.isEmpty();
  } // checkMatching
} // class StringUtils    

