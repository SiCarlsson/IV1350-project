package se.epelsc.iv1350.higherGradeTasks.task2;

import java.util.Random;

public class RandomInheritance extends Random {
  public RandomInheritance() {
    super();
  }

  /**
   * Method gives a random even integer between two bounds
   * 
   * @param lowerBound the lowest possible value to be generated
   * @param upperBound the upper limit of the generated number (maximum value is
   *                   upperBound - 1)
   * @return the randomly generated number
   */
  public int nextEvenInt(int lowerBound, int upperBound) {
    int result;
    do {
      result = nextInt(upperBound - lowerBound) + lowerBound;
    } while (result % 2 != 0);
    return result;
  }
}
