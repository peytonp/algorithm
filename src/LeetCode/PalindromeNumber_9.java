package LeetCode;

/**
 * @ClassName PalindromeNumber_9
 * @Author xy
 * @Date 2019/4/810:48
 * @Version 1.0
 */
public class PalindromeNumber_9 {
    /**
     * @FunctionName: isPalindrome
     * @Description: 判断是否为回文数，不使用toString
     * @Author: xy
     * @Date: 2019/4/8 11:00
     * @Version: 1.0
     * @Param: [x]
     * @Return: boolean
     */
    public static boolean isPalindrome(int x) {
        if(x<0|| (x % 10 == 0 && x != 0)) return false;
        int revertedNumber=0;
        int i=x;
        while(i!=0){
            revertedNumber=revertedNumber*10+i%10;
            i/=10;
        }
        if(revertedNumber==x) return true;
        return false;
    }

    public static boolean isPalindrome_2(int x) {
        if(x<0|| (x % 10 == 0 && x != 0)) return false;
        int revertedNumber=0;
        while(x>revertedNumber){
            revertedNumber=revertedNumber*10+x%10;
            x/=10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(-8));
    }
}
