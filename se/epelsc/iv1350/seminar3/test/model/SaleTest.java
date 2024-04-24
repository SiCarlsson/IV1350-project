package se.epelsc.iv1350.seminar3.test.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar3.source.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
  /*
   * Variables
   */
  private Sale instanceToTest;

  @BeforeEach
  public void setUp() {
    instanceToTest = new Sale();
  }

  @AfterEach
  public void tearDown() {
    instanceToTest = null;
  }

  /*
   * Tests the functionallity of adding items to the current sale
   * 
   * @return
   */
  @Test
  public void testAddItem() {
    int expectedOutput = 4;

    for (int i = 0; i < expectedOutput; i++) {
      this.instanceToTest.addItem(null);
    }

    int givenOutput = this.instanceToTest.getTotalProducts();

    assertEquals(expectedOutput, givenOutput, "testAddItem works as expected!");
  }
}