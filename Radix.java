public class Radix{
  public static int nth(int n, int col){
    int x = ((n / (int)Math.pow(10, col)) % 10);
    return x;
  }
}
