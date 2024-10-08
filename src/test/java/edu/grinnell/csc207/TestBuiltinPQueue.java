package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.grinnell.csc207.linear.BuiltinPriorityQueue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.text.RuleBasedCollator;
import java.util.Comparator;

public class TestBuiltinPQueue {

  /**
   * Fields
   */

  /** The BuiltinPriorityQueue to initialize and test with. */
  BuiltinPriorityQueue<Object> stringPQ;

  /**
   * Set up variables for use in tests.
   */
  @BeforeEach
  public void setup() throws Exception {
    // only supports lowercase letters
    String rule = "< a < b < c < d < e < f < g < h < i < j < k < l < m < n < o < p < q < r < s < t < u < v < w < x < y < z";
    Comparator<Object> english = new RuleBasedCollator(rule);
    stringPQ = new BuiltinPriorityQueue<Object>(10, english);
  }

  /**
   * Tests basic functionality of BuiltinPriorityQueue<T>.
   */
  @Test
  public void test1() throws Exception {
    stringPQ.put("hi");
    assertEquals("hi", stringPQ.peek());;
    stringPQ.put("abc");
    assertEquals("abc", stringPQ.peek());;
    assertEquals("abc", stringPQ.get());;
    assertEquals("hi", stringPQ.peek());;
    stringPQ.put("zero");
    assertEquals("hi", stringPQ.get());;
    assertEquals("zero", stringPQ.peek());;
    assertEquals("zero", stringPQ.get());;
    assertEquals(true, stringPQ.isEmpty());;
  }

  /**
   * Tests specific functionality of BuiltinPriorityQueue<T>:
   * Multiple instances of a string.
   */
  @Test
  public void test2() throws Exception {
    
    stringPQ.put("hi");
    stringPQ.put("hi");
    assertEquals("hi", stringPQ.peek());;
    stringPQ.put("abc");
    assertEquals("abc", stringPQ.peek());;
    assertEquals("abc", stringPQ.get());;
    assertEquals("hi", stringPQ.peek());;
    stringPQ.put("zero");
    assertEquals("hi", stringPQ.get());;
    assertEquals("hi", stringPQ.peek());;
    assertEquals("hi", stringPQ.get());;
    assertEquals("zero", stringPQ.peek());;
    assertEquals("zero", stringPQ.get());;
    assertEquals(true, stringPQ.isEmpty());;
  }
}