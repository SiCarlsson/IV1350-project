package se.epelsc.iv1350.higherGradeTasks.tests.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.epelsc.iv1350.higherGradeTasks.source.model.Register;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {
  Register instanceToTest;

  @BeforeEach
  public void setUp() {
    this.instanceToTest = new Register();
  }

  @AfterEach
  public void tearDown() {

  }

  @Test
  public void testUpdateRegisterCorrectIncrementation() {
    double testedInput = 110.87;
    double expectedOutput = this.instanceToTest.getMoneyInRegister() + testedInput;
    
    this.instanceToTest.updateRegister(testedInput);

    double givenOutput = this.instanceToTest.getMoneyInRegister();

    assertEquals(expectedOutput, givenOutput, "updateRegister does not update with the right amount");
  }

}
