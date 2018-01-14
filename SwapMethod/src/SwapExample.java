public class SwapExample
{
   public static void main (String [] args)
   {
      int a = 3;
      int b = 4;
      System.out.printf("Before: a is %d, b is %d\n", a, b);
      swap(a, b);
      System.out.printf("After: a is %d, b is %d\n", a, b);
   }

   public static void swap (int a, int b)
   {
      int temp = a;
      a = b;
      b = temp;
      System.out.printf("During: a is %d, b is %d\n", a, b);
   }
}
