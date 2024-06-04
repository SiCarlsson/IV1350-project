package se.epelsc.iv1350.higherGradeTasks.task2;

import java.util.Random;

public class RandomComposition {
  private Random random;

  /**
   * constructor
   */
  public RandomComposition() {
    this.random = new Random();
  }

  /**
   * Method gives a random even integer between two bounds
   * 
   * @param lowerBound the lowest possible value to be generated
   * @param upperBound the upper limit of the generated number (maximum value is
   *                   upperBound - 1)
   * @return the randomly generated number
   */
  public int randomEvenInt(int lowerBound, int upperBound) {
    int result;
    do {
      result = random.nextInt(upperBound - lowerBound) + lowerBound;
    } while (result % 2 != 0);
    return result;
  }
}
