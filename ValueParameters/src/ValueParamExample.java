public class ValueParamExample
{
    public static void main(String args[])
    {
        int a = 3;
        System.out.printf("Before: a is %d\n", a);
        m(a);
        System.out.printf("After:  a is %d\n", a);
    }

    public static void m(int p)
    {
        System.out.printf("\tDuring (before): p is %d\n", p);
        p = 20;
        System.out.printf("\tDuring (after): p is %d\n", p);
    }
}
