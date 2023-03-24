
//declaring panda class and components
class Panda {
   double weight;
   int num_leg;
   double age;

  //no arg constructor
  Panda(){
    weight = 100.50;
    age = 2.50;
    num_leg = 4;
    
  }

  //regular constructor
  Panda(double w, int legs, double a){
    weight = w;
    num_leg = legs;
    age = a;
    
  }

    //print panda's characteristics
  public void toPrint(){
  System.out.printf("weight: %.2f \n",weight);
  System.out.printf("age: %.2f \n",age);
  System.out.println("number of legs: " + num_leg);
}

  //climb method
public void climb(){
  System.out.println("I slowly climb just after a meal of bamboo shooters.");
}
  
}