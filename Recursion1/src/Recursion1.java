
public class Recursion1
{

    static int numComparisons;
    static int numCalls;
    static String combination;
    
    public static void main(String[] args)
    {
        int[] numArray = { 2, 4, 8 };
        
        report(numArray, 10);
        report(numArray, 14);
        report(numArray, 9);
    }
    
    public static void report(int[] nums, int target)
    {
        numComparisons = 0;
        numCalls = 0;
        combination = "";
        
        System.out.println(groupSum(0, nums, target));
        System.out.println(combination);
        System.out.println("Num calls: " + numCalls);
        System.out.println("Num comparisons: " + numComparisons + "\n");
    }

    public static boolean groupSum(int start, int[] nums, int target)
    {
        numCalls++;
        
        if (start >= nums.length)
        {
            numComparisons++;
            return (target == 0);
        }
        
        if (groupSum(start + 1, nums, target - nums[start]))
        {
            numComparisons++;
            combination += nums[start] + "  ";
            return true;
        }

        if (groupSum(start + 1, nums, target))
        {
            numComparisons++;
            return true;
        }

        return false;
    }
}
