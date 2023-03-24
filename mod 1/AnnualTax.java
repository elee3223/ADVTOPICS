import java.util.Scanner;

class Main {

  //Determine the tax rate based on income
  public static double getTax(int in){
    double tax_rate;
    if(in <= 50000)
      tax_rate = 0;
    else if(in <= 100000)
      tax_rate = 0.07;
    else
      tax_rate = 0.09;

    return tax_rate;
    
  }

  //Determine if the user is a senior
  public static boolean getDiscount(int age){
    
    if (age >= 60)
      return true;
    else
      return false;

  }
  public static void main(String[] args) {

    //Declare scanner for user input
    Scanner input = new Scanner(System.in);

    while (100 > 1){
      //Prompts user for input 
      System.out.println("Please enter your income and age:");
      int income = input.nextInt();
      int age = input.nextInt();
  
      double tax_rate = getTax(income);
      boolean senior_discount = getDiscount(age);

      //Determine if senior discount can be applied
      if(senior_discount && (tax_rate > 0))
        tax_rate-=0.03;
  
      System.out.printf("Your tax amount is: " + "%.2f%n",(income*tax_rate));
      

      //Output user's tax rate
      if (age >= 60 && (tax_rate>0))
        System.out.printf("You are qualified for senior discount. Your senior discount percentage rate is: %.2f %%\n\n",(tax_rate*100));
      else
      System.out.printf("Your tax rate is: %.2f %%\n\n",(tax_rate *100));
    }
  }
}