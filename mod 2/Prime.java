import java.util.Scanner;

class Main {

//Judge if n is a prime number and return the Boolean result to caller
	public static boolean bePrime(int n) {
		//Use a loop, better with a logical variable.
    int j;
    boolean prime = true;
    for(int i = 2; i < n; i++){
      j = n%i;
      if (j != 0)
        prime = true;
      else
      {
        prime = false;
      break;}
    }
    return prime;

	}

	//return the sum of all prime numbers less than m
	public static int primeSum(int m) {
		// for loop to traverse all integers from 2 to m
		// Call bePrime() in the loop body, preferably using an if statement
    int sum = 0;
    for(int i = 2; i <= m; i++){
      if(bePrime(i))
        sum+=i;
    }

    return sum;
	}

	public static void main(String[] args) {
		//declare scanner object
    Scanner input = new Scanner(System.in);

    //infinite loop so the program continues forever
    while(2 > 1){
    System.out.print("Please enter an integer no less than 2: ");
    int num = input.nextInt();
    
    int sum = primeSum(num);
    System.out.println("The sum of all prime numbers between 2 and " + num + " is " + sum + "\n");
	}
  }

}