public class InvalidTriangleException extends RuntimeException {
  private double a, b, c;

  public InvalidTriangleException(){}
  
  public InvalidTriangleException(double a, double b, double c) {
    // TODO:
    // use keyword super to invoke the constructor of RuntimeException with an error message
    // set the three sides
    super("Invalid triangle with sides: " + a + ", " + b + ", " +c);
    this.a = a;
    this.b = b;
    this.c = c;
  }
  // TODO:
  // complete three public getters
  public double getA(){
    return a;}

  public double getB(){
    return b;}

  public double getC(){
    return c;}
  
}