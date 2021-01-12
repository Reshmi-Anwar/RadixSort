public class Radix{
  public static int nth(int n, int col){
    int x = ((n / (int)Math.pow(10, col)) % 10);
    return Math.abs(x);
  }

  public static int length(int n){
    if (n==0){
      return 1;
    }
    if (n < 0){
      n = Math.abs(n);
    }
    int lengthNum = (int) Math.log10(n) + 1;
    return lengthNum;
  }

  //simple tester cases from class notes
  public static void main(String args[]){
    System.out.println("Nth");
    System.out.println(nth(123, 1));
    System.out.println(nth(-123, 1));
    System.out.println(nth(123, 2));
    System.out.println(nth(-123, 2));
    System.out.println("Length");
    System.out.println(length(0));
    System.out.println(length(15));
    System.out.println(length(-10));
    System.out.println(length(4759));
  }
}
