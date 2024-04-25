package se.epelsc.iv1350.seminar3.test.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.seminar3.source.controller.Controller;
import se.epelsc.iv1350.seminar3.source.integration.Printer;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
  /*
   * Variables
   */
  private Controller instanceToTest;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Controller(new Printer());
  }

  @AfterEach
  public void tearDown() {
    this.instanceToTest = null;
  }

  /*
   * Testing the basic functionallity of starting a sale (creating an instance of sale in controller)
   */
  @Test
  public void testStartSale() {
    this.instanceToTest.startSale();

    assertNotEquals(null, this.instanceToTest.getSale(), "Basic functionallity of startSale works!");
  }
}
