import java.util.Scanner;

class Main {


  public static void main(String[] args) {

    //declare input and new panda class variables
    Scanner input = new Scanner(System.in);
    Panda panda1 = new Panda();
    Panda panda2 = new Panda(0,0,0);

    //get input from user for panda2 
    System.out.print("panda1 is created using the no-arg constructor.\n\npanda2 will be created using the standard constructor, please enter its weight, age, and number of legs:");
    panda2.weight = input.nextDouble();
    panda2.age = input.nextDouble();
    panda2.num_leg = input.nextInt();

    System.out.print("\n");

    //Display panda 1 and panda 2 characteristics
  System.out.println( "panda1 toPrint:");
    panda1.toPrint();
    panda1.climb();
    
    System.out.print("\n");
    System.out.println( "panda2 toPrint:");
    panda2.toPrint();
    panda2.climb();

    //get input from user for panda1 and panda2
    System.out.println("\nLet's change the properties of panda1, please enter its weight, age and number of legs: ");
    panda1.weight = input.nextDouble();
    panda1.age = input.nextDouble();
    panda1.num_leg = input.nextInt();

    System.out.println("\nLet's change the properties of panda2, please enter its weight, age and number of legs: ");
    panda2.weight = input.nextDouble();
    panda2.age = input.nextDouble();
    panda2.num_leg = input.nextInt();

    //Display panda1 and panda 2 characteristics
      System.out.print("\n");
       System.out.println( "panda1 toPrint:");
    panda1.toPrint();
    panda1.climb();
    
    System.out.print("\n");
     System.out.println( "panda2 toPrint:");
    panda2.toPrint();
    panda2.climb();
  }
}
