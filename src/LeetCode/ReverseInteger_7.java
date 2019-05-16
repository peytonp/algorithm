package LeetCode;

/**
 * @ClassName ReverseInteger_7
 * @Author xy
 * @Date 2019/4/911:22
 * @Version 1.0
 */
public class ReverseInteger_7 {
    public static int reverse(int x) {
        long reverseNumber=0;
        int flag=1;
        if(x<0){
            x=-1*x;
            flag=0;
        }
        while(x>0){
            reverseNumber=reverseNumber*10+x%10;
            x/=10;
        }
        if(reverseNumber>Integer.MAX_VALUE) return 0;
        return flag==0?(int)(-1*reverseNumber): (int)reverseNumber;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1463847422));
    }
}
