package se.epelsc.iv1350.seminar3.test.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import se.epelsc.iv1350.seminar3.source.model.Payment;
import se.epelsc.iv1350.seminar3.source.model.Register;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
  private Payment instanceToTest;

  @Before
  public void preSetUp() {
    this.instanceToTest = new Payment(new Register());
  }

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Payment(new Register());
  }

  @AfterEach
  public void tearDown() {
    instanceToTest = null;
  }

  @Test
  public void testUpdateRegisterAmount() {
    double cashRecievedFromCustomer = 1337;
    double totalCost = 1221;

    double expectedOutput = (cashRecievedFromCustomer - totalCost) + this.instanceToTest.getRegister().getMoneyInRegister();
    
    this.instanceToTest.updateRegisterAmount(cashRecievedFromCustomer, totalCost);
    double givenOutput = this.instanceToTest.getRegister().getMoneyInRegister();

    assertEquals(expectedOutput, givenOutput, "updateRegisterAmount does not update with the right amount");
  }
}
