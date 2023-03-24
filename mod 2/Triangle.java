import java.lang.Math;

public class Triangle extends GeometricObject {
   private double a, b, c;

   public Triangle(double a, double b, double c) {
     // TODO:
     // if invalid throw InvalidTriangleException
     // else assign the tree sides respectively

     //checking if triangle is valid by Pythagorean theorem
      double hyp1, hyp2, hyp3;
     hyp1 = Math.sqrt((Math.pow(a,2)) + Math.pow(b,2));
     hyp2 = Math.sqrt((Math.pow(b,2)) + Math.pow(c,2));
     hyp3 = Math.sqrt((Math.pow(a,2)) + Math.pow(c,2));
     boolean hyp = (hyp1 == c || hyp2 == a || hyp3 == b);

     //checking there are no negative values
     boolean pos = (a > 0 && b > 0 && c>0);
     
     if((hyp == false) || (pos == false)){
       throw new InvalidTriangleException(a,b,c);
     }
      else{
       this.a = a;
       this.b = b;
       this.c = c;
       System.out.println("Created triangle with sides: " + a + ", " + b + ", " + c);
       }
       
        
   }
 }
 