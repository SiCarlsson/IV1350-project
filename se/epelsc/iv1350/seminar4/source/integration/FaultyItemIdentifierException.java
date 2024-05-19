package se.epelsc.iv1350.seminar4.source.integration;

import java.util.InputMismatchException;

import se.epelsc.iv1350.seminar4.source.util.Textfiles;

public class FaultyItemIdentifierException extends InputMismatchException {
  public FaultyItemIdentifierException(String FILE_NAME, String s) {
    super(s);
    Textfiles.writeToTextFile(FILE_NAME, s);
  }
}
