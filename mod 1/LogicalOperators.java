import java.util.Scanner;

class Main {

  //function that tests if the first number is divisible by BOTH of the following two
  public static boolean case_one(int a, int b, int c){
    int rem1 = a%b;
    int rem2 = a%c;

    if(rem1 == 0 && rem2 == 0)
      return true;
    else
      return false;
  }

    //function that tests if the first number is divisible by EITHER of the following two
    public static boolean case_two(int a, int b, int c){
    int rem1 = a%b;
    int rem2 = a%c;

    if(rem1 == 0 || rem2 == 0)
      return true;
    else
      return false;
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    //Prompt user for input
    System.out.print("Please enter three integers: ");
    int num1 = input.nextInt();
    int num2 = input.nextInt();
    int num3 = input.nextInt();

    boolean c1 = case_one(num1, num2, num3);
    boolean c2 = case_two(num1, num2, num3);

    System.out.println("Is " + num1 + " divisible by " + num2 + " and " + num3 + "? " + c1);
    System.out.println("Is " + num1 + " divisible by " + num2 + " or " + num3 + "? " + c2);

    //Determine if the first number is divisible by at least one of the following two, but not both and outputs results
    if (c1 == false && c2 == true)
      System.out.println("Is " + num1 + " divisible by " + num2 + " or " + num3 + ", but not both? true");
    else
      System.out.println("Is " + num1 + " divisible by " + num2 + " or " + num3 + ", but not both? false");
  }
}