import java.lang.reflect.Array;

public class InterviewProblem {
    //1、输出1-100的质数
    public static void printPrimeNumber(int n){
        for(int i=1;i<=100;i++){
            boolean flag=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){flag=false;}
            }
            if (flag){System.out.println("素数有"+i);}
        }
    }
    //2、求两个数的最大公约数
    public static int gcb(int a,int b){
        if(b==0) return a;
        return gcb(b,a%b);
    }

    //3、一个人可以最多上三层台阶，从最底层上到第N层，有多少种走法。
    public static int countNumber(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;
        return countNumber(n-1)+countNumber(n-2)+countNumber(n-3);
    }
    //迭代的方法求解 f(n)=f(n-1)+f(n-2)+f(n-3)
    public static int countNumberIteration(int n){
        if(n<=2) return n;
        if(n==3) return 4;
        int first=1,second=2,third=4;
        int four = 0;
        for(int i=4;i<=n;i++){
            four=first+second+third;
            first=second;
            second=third;
            third=four;
        }
        return four;
    }
    //4、冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=1;i<arr.length;i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("\nbubble");
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
    //5、插入排序
    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                } else break;
            }
        }
        System.out.println("\ninsert");
        for(int x:arr){
            System.out.print(x+" ");
        }
    }

    //6、选择排序
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int k=i;
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[j]<arr[k]){
                    k=j;
                }
            }
            if(k!=i) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println("\nselect");
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
    //@todo 归并排序



    //快速排序，L为0，R为数组最后一个下标
    public static void quickSort(int[] arr,int L,int R){
        if(L<R){
            //随机选取一个数，降低特殊情况的出现
            int i=L+(int)(Math.random()*(R-L+1));
            int temp=arr[i];
            arr[i]=arr[R];
            arr[R]=temp;
            int[] p=sortPartition(arr,L,R);
            quickSort(arr,L,p[0]);
            quickSort(arr,p[1],R);
        }
    }
    public static int[] sortPartition(int[] arr,int L,int R){
        //最小区的右边界应该从第0个数开始
        int less=L-1;
        //最大区的左边界从对比值处开始即可，最后需要交换最大区的左边界和对比值。
        int more=R;
        //定义下标，当下标大于等于more的时候，即可终止
        for(int i=L;i<more;){
            //如果当前下标的值比对比值大，则将大区的左边界向左移动，并交换当前下标与左边界的值，不用增加下标值，因为交换了。
            if(arr[i]>arr[R]){
                swap(arr,i,--more);

            }
            //如果当前下标的值比对比值小，则将小区的右边界向右移动，并交换当前下标与右边界的值
            else if(arr[i]<arr[R]){
                //@还需要交换，有可能存在相等的情况，需要交换
                swap(arr,++less,i++);
            }
            //如果碰到相等的情况，下标直接增加即可，不对边界进行操作
            else i++;
        }
        //交换比对值和最大区的左边界
        swap(arr,more,R);
        return new int[]{less,more+1};
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //O(n)利用快速排序查找第K大的元素;
    //n+n/2+n/4+...+1,等比求和，最后为2n-1O,所以时间复杂度为(n)
    public static int quickFindK(int[] arr,int K,int L,int R){
        if(L<R) {
            int[] p = sortPartition(arr, L, R);
            System.out.println();
            for (int x : arr) {
                System.out.print(x + " ");
            }
            //如果右边界比第K大值小，则取右边界
            if (p[1] <= (R - K + 1)) {
                return quickFindK(arr, K, p[1], R);
                //如果左边界比第K大值大，则取左边界
            } else if (p[0] >= (R - K + 1)) {
                return quickFindK(arr, K, L, p[0]);
            }
            else return arr[(p[0]+1)];
        }
        else if(L>R) return -1;
        else return arr[R];
    }

    //鸡尾酒排序（双冒泡排序）
    public static void doubleBubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            boolean flag=false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag=true;
                }
            }
            //注意倒排的起始，是从数组最大未排序位即（arr.length-1-i-1)开始递减
            for(int j=arr.length-i-2;j>0;j--){
                if(arr[j]<arr[j-1]);{
                    swap(arr,j,j-1);
                    flag=true;
                }
                if(!flag) break;
            }
        }
    }

    //把两个已经有序的数组，组合成一个有序的数组
    public static int[] mergeArrSort(int[] arr1,int[] arr2){
        int[] arr3=new int[arr1.length+arr2.length];
        int i=0,j=0,temp=0;
        for(;i<arr1.length&&j<arr2.length;temp++){
            if(arr1[i]>arr2[j]){
                arr3[temp]=arr2[j];
                j++;
            }
            else{
                arr3[temp]=arr1[i];
                i++;
            }
        }
        if(i>=arr1.length){
            for (;j<arr2.length;j++,temp++){
                arr3[temp]=arr2[j];
            }
        }
        else{
            for (;i<arr1.length;i++,temp++){
                arr3[temp]=arr1[i];
            }
        }
        return arr3;
    }
    //7、求一个字符串J的字符,在另一个字符串S中出现的数量,(J不重复，区分大小写)
    public static int numJInS(String j,String s){
        char[] index=new char['z'+1];
        System.out.println("index length :"+index.length);
        int count=0;
        for(char x:j.toCharArray()) index[x]=1;
        for(char x:s.toCharArray()) count+=index[x];
        return count;
    }

    //8、给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    //输入：[-4,-1,0,2,3,10]
    //输出：[0,1,4,9,16,100]
    public static int[] arrSquare(int[] arr){
        int num=0;
        //获取数组中比第一个数小的数量
        for(int x:arr){
            if(x*x<=arr[0]*arr[0]) num+=1;//5
            else break;
        }

        for(;arr[0]<0&&num>0;num--){
            System.out.println("num:"+num+" "+arr[0]);
            if(arr[0]*arr[0]>arr[num-1]*arr[num-1]){
                int temp=arr[0];
                for(int j=0;j<num-1;j++){
                    arr[j]=arr[j+1];
                }
                arr[num-1]=temp;
            }
            for(int x:arr){
                System.out.print(x+" ");
            }

        }

        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]*arr[i];
        }
        return arr;
    }

    //创建新数组 @todo
    public static int[] arrSquare2(int[] arr){
        int[] arr2;
        int start=0;
        //获取比0小的最后一位
        while(start<arr.length&&arr[start]<0){
            start++;
        }
        //int i=start-1;

        for(int t=0;t<arr.length;t++){
            //arr[t++]=1;
        }
        return null;
    }

    //对有序数组进行二分查找法 for循环
    public static int binarySearch(int[] arr,int search){
        int end=arr.length-1;
        int start=0;
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if(arr[mid]==search) return mid;
            if(arr[mid]<search){
                start=mid+1;
            }else if(arr[mid]>search){
                end=mid-1;
            }
        }
        return -1;
    }
    //对有序数组进行二分查找法递归
    public static int binarySearchRecursion(int[] arr,int start,int end,int search){
        //终止条件
        if(start>end) return -1;
        int mid=start+((end-start)>>1);
        if(arr[mid]==search) return mid;
        else if(arr[mid]<search) return binarySearchRecursion(arr,mid+1,end,search);
        else return binarySearchRecursion(arr,start,mid-1,search);
    }

    //二分查找变形问题:1、查找第一个等于给定值的下标
    public static int findFirstEqualKey(int[] arr,int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+((end-start)>>1);
            if(arr[mid]<key){
                start=mid+1;
            }
            else if(arr[mid]>=key){
                //需要注意可能是第一个元素，所以mid-1可能存在越界情况，需要判断如果mid=0，且等于key则返回mid
                if((mid==0||arr[mid-1]!=key)&&arr[mid]==key) return mid;
                else end=mid-1;
            }
        }
        return -1;
    }

    //二分查找变形问题:2、查找最后一个等于给定值的下标
    public static int findLastEqualKey(int[] arr,int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+((end-start)>>2);
            if(arr[mid]<key){
                start=mid+1;
            }else if(arr[mid]>key){
                end=mid-1;
            }else{
                //如果是最后一个，且第二个元素不等于key，则返回mid
                if(mid==arr.length-1||arr[mid+1]!=key) return mid;
                else start=mid+1;
            }
        }
        return -1;
    }

    //二分查找变形问题:3、查找第一个大于等于给定值的元素
    public static int findFirstMoreKey(int[] arr,int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+((end-start)>>1);
            if(arr[mid]>=key){
                if(mid==0||arr[mid-1]<key) return mid;
                else end=mid-1;
            }
            else if(arr[mid]<key){
                start=mid+1;
            }
        }
        return -1;
    }


    /**
     * @FunctionName: findLastLessKey
     * @Description: 二分查找变形问题:4、查找最后一个小于等于给定值的元素
     * @Author: xy
     * @Date: 2019/4/2 10:16
     * @Version: 1.0
     * @Param: [arr, key]
     * @Return: int
     */
    public static int findLastLessKey(int[] arr,int key){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+((end-start)>>1);
            if(arr[mid]>key){
                end=mid-1;
            }else{
                if(mid==arr.length-1||arr[mid+1]>key) return mid;
                else start=mid+1;
            }
        }
        return -1;
    }


    //@todo 求一个数的平方根，精确到6位小数
    public static int sqrt(int number){
        int x=0;

        if(x*x-number<0.000001&&x*x-number>0){
          return x;
        }
        return 0;
    }

    //@todo 二叉查找树



    /**
     * @todo
     * @FunctionName: findKeyInTwoDimensionalArray
     * @Description: 剑指offer 1、二维数组，从左到右，从上往下依次递增，设计一个函数，传入二维数组和给定值，判断给定值是否存在数组内
     * @Author: xy
     * @Date: 2019/4/2 10:16
     * @Version: 1.0
     * @Param: [arr, key]
     * @Return: int[][]
     */
    public boolean findKeyInTwoDimensionalArray(int[][] arr,int key){

        return false;
    }



    public static void main(String[] args){
        //printPrimeNumber(100);
//        System.out.println(gcb(10,20));
//        System.out.println(countNumber(5));
//        System.out.println(countNumberIteration(5));
//        bubbleSort(new int[]{3,2,1,4});
        //insertSort(new int[]{3,2,1,4});
        //selectSort(new int[]{3,2,1,4});
//        for(int x:mergeArrSort(new int[]{1,2,7,9,10},new int[]{3,4,5,8})){
//            System.out.println(x);
//        }
        //System.out.println(numJInS("AaBcd","AABBCCddEdf"))
//        for(int x:arrSquare(new int[]{-1})){
//            System.out.println(x);
//        }

//        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7},9));
//        System.out.println(binarySearchRecursion(new int[]{1,2,3,4,5,6,7},0,6,8));
        int[] arr=new int[]{8,2,3,4,3,3,2,1};
//        quickSort(arr,0,arr.length-1);
//        for(int x:arr){
//            System.out.println(x);
//        }
//        System.out.println(quickFindK(arr,2,0,arr.length-1));

//        doubleBubbleSort(arr);
//        for(int x:arr){
//            System.out.println(x);
//        }
        int[] arr1=new int[]{1,2,3,5,5,5,6,6,7,7};
//        System.out.println(findFirstEqualKey(arr1,9));
//        System.out.println(findLastEqualKey(arr1,3));
//        System.out.println(findFirstMoreKey(arr1,1));
        System.out.println(findLastLessKey(arr1,4));
    }
}
