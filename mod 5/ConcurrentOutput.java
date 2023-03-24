package q1;

import java.util.concurrent.*;

public class ConcurrentOutput {
    public static void main(String[] args) {

      //create executors for thread pooling
      ExecutorService ex = Executors.newFixedThreadPool(1);
      
      //new runnable
      Runnable printA = new PrintChar('a', 100);
      Runnable printB = new PrintChar('b', 100);
      Runnable print100 = new PrintNum(100);
  
      //new threads
      Thread thread1 = new Thread(printA);
      Thread thread2 = new Thread(printB);
      Thread thread3 = new Thread(print100);
   
      //new executors
      ex.execute(thread1);      
      ex.execute(thread2);      
      ex.execute(thread3);

      ex.shutdown();
    }
  }
  
  class PrintChar implements Runnable {
    private char charToPrint;
    private int times;
  
    public PrintChar(char c, int t) {
      charToPrint = c;
      times = t;
    }
  
    @Override
    public synchronized void run() {
      //try/catch block for printing character
      try{
        for (int i = 0; i < times; i++) {
          System.out.print(charToPrint);
        }

        Thread.sleep(200);
      }
      catch(InterruptedException ex){

      }
      


      }
    }
  
  
  class PrintNum implements Runnable {
    private int lastNum;

    public PrintNum(int n) {
      lastNum = n;
    }
  
    @Override
    public synchronized void run() {
      //try/catch block for printing numbers
      try{
        for (int i = 1; i <= lastNum; i++) {
          System.out.print(" " + i);
        }

        Thread.sleep(200);
      }
      catch(InterruptedException ex){}
      

    }
  }
