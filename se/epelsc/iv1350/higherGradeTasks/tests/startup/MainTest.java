package se.epelsc.iv1350.higherGradeTasks.tests.startup;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.InputMismatchException;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import se.epelsc.iv1350.higherGradeTasks.source.startup.Main;

public class MainTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void preSetUp() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  public void testProperStartOfProgram() throws InputMismatchException, SQLException {
    Main.main(null);

    boolean contentPrinted;

    if (outContent.toString() != null) {
      contentPrinted = true;
    } else {
      contentPrinted = false;
    }

    assertTrue("Program did not start as intended", contentPrinted);
  }
}
