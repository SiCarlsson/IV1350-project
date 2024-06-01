package se.epelsc.iv1350.higherGradeTasks.source.integration;

import java.util.InputMismatchException;

public class FaultyItemIdentifierException extends InputMismatchException {
  public FaultyItemIdentifierException(String s) {
    super(s);
  }
}
