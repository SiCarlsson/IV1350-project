package se.epelsc.iv1350.seminar4.source.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Textfiles {
  /**
   * Function creates textfile if necessary
   * 
   * @throws IOException if file cannot be created
   */
  public static void createTextFile(String FILE_NAME) {
    File textFile = new File(FILE_NAME);

    try {
      textFile.createNewFile();
    } catch (IOException e) {
      System.out.println("An error occurred while creating " + FILE_NAME);
    }
  }

  /**
   * Writes accumulated revenue to the textfile
   * 
   * @throws IOException if file cannot be written to
   */
  public static void writeToTextFile(String FILE_NAME, String content) {
    try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
      writer.write(content + System.lineSeparator());
    } catch (IOException e) {
      System.out.println("An error occurred while writing to " + FILE_NAME);
    }
  }
}
