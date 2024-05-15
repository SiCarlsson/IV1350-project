package se.epelsc.iv1350.seminar4.source.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import se.epelsc.iv1350.seminar3.source.util.Calculations;
import se.epelsc.iv1350.seminar4.source.model.RegisterObserver;

public class TotalRevenueFileOutput implements RegisterObserver {

  private static final String FILE_NAME = "total_revenue.txt";

  /**
   * Constructor
   * 
   * @throws IOException if file cannot be created
   */
  public TotalRevenueFileOutput() throws IOException {
    createTextFile();
  }

  /**
   * Writes accumulated revenue to the textfile
   */
  @Override
  public void updateTotalRevenue(double totalRevenue) {
    try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // 'true' means append mode
      writer.write("Total revenue: " + Calculations.roundTwoDecimalPoints(totalRevenue) + System.lineSeparator());
    } catch (IOException e) {
      System.out.println("An error occurred while writing to " + FILE_NAME);
    }
  }

  /**
   * Function creates textfile if necessary
   * 
   * @throws IOException if file cannot be created
   */
  private void createTextFile() throws IOException {
    File textFile = new File(FILE_NAME);

    try {
      textFile.createNewFile();
    } catch (IOException e) {
      System.out.println("An error occurred while creating " + FILE_NAME);
    }
  }
}
