package se.epelsc.iv1350.higherGradeTasks.task2;

public class MainRandom {
  public static void main(String[] args) {

    /**
     * Execute class using inheritance
     */
    RandomInheritance randomInheritance = new RandomInheritance();
    System.out.println("Using EnhancedRandom (Inheritance):");
    for (int i = 0; i < 5; i++) {
      System.out.println("Even Random Int: " + randomInheritance.nextEvenInt(0, 1000));
    }

    /**
     * Execute class using composition
     */
    RandomComposition randomComposition = new RandomComposition();
    System.out.println("\nUsing RandomComposition:");
    for (int i = 0; i < 5; i++) {
      System.out.println("Even Random Int: " + randomComposition.nextEvenInt(0, 1000));
    }
  }
}
