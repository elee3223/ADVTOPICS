import java.util.Scanner;
import java.util.Random;

class Main {

  //checks to see if the entered index is within bounds
public static boolean notOutOfBounds(int l, int in){
  if((in >= 0) && (in <  l))
    return true;
  else
    return false;
}

  public static void main(String[] args) {

    //declare variables
    int length;
    int index;
    boolean oob;
    Scanner input = new Scanner(System.in);

    //prompt the user for length of array until it is more than 0
  do{
    System.out.println("Please enter the length of an array: ");

    length = input.nextInt();
  }while(length <= 0);

  //prompts the user for an index until it is out of bounds
    
  do{
    System.out.println("Please enter an index: ");

    index = input.nextInt();

      oob =notOutOfBounds(length,index);

    if(oob){
      Random rand = new Random();
      int[] arr = new int[length];
      for(int i = 0; i < length; i++){
        arr[i] = rand.nextInt(10);
      }

      System.out.println("The array element at index " + index + " is " + arr[index]);
    }
    else{
      System.out.println("Index " + index + " is out of bound [0, " + (length-1) + "]");
      break;
    }
      
      
    }while(oob);
  }
}