class Main {
  public static void main(String[] args) {
     Triangle t1 = null, t2 = null, t3 = null;
      try {
        t1 = new Triangle(3,4,5);
        t2 = new Triangle(1,2,3);
        t3 = new Triangle(10,4,5);
      }
      catch (InvalidTriangleException ex) {
        System.out.println(ex);
      }
  }
}