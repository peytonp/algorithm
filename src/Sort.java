/**
 *
 * Created by xy on 2018/6/5.
 */
import java.util.Arrays;

public class Sort {
    /*
    冒泡排序：两两比较，将最大的值放到后面，一次遍历的结果是将最大值依次放到数组最后，
    依此类推直至数组排序完成
     */
    public static void bubbleSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        System.out.println("原数组"+Arrays.toString(arr));
        for(int end=arr.length-1;0<=end;end--){
            for(int i=0;i<end;i++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                    System.out.println("end:"+end+"交换后 Array:"+Arrays.toString(arr));
                }
            }
            System.out.println("end:"+end+"寻找最大值放在end位置:"+Arrays.toString(arr));
        }
    }
    /*
    选择排序：两两比较，记录最小值的标签，遍历一遍之后，将最小值与每次遍历开始的地方交换，
    依此类推直至数组排序完成
     */
    public static void selectionSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        System.out.println("选择排序原数组"+Arrays.toString(arr));
        for(int i=0;i<arr.length-1;i++) {//获取最后一位length-1即可，下面i+1会获取到最后一位作比较
            int k=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
                //k=arr[j]<arr[k]?j:k
            }
            swap(arr,i,k);
            System.out.println("选择排序交换后数组"+Arrays.toString(arr));
        }
    }

    /*
    插入排序：取第n个数(n>=2)与前j个数相比，直到大于前面某一个数，将其插入在其后，
    保证第n次循环保证arr[0]至arr[n]上的顺序正确，
     */
    public static void insertSort(int[] arr){
        if(arr.length<2||arr==null){
            return;
        }
        System.out.println("插入排序原数组"+Arrays.toString(arr));
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;0<=j;j--){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        System.out.println("插入排序第"+i+"次遍历后数组"+Arrays.toString(arr));
        }
    }
    /*
    快速排序：选取数组最后一个数X,将数组分为小于X,等于X，大于X的部分，依此类推。
    1、当前数如果等于划分值，下标跳下一个
    2、当前数如果小于划分值，当前数与小区的下一个数交换，小区向右扩一个位置，下标跳下一个
    3、当前数如果大于划分值，当前数与大区的前一个数交换，大区向左扩一个位置，下标不动
     */
    public static void quickSort(int[] arr){

    }

    public static void Sort(int[] arr){

    }

    //交换数组中两个元素
    public static void swap(int[] arr,int i,int j){
        int c=arr[i];
        arr[i]=arr[j];
        arr[j]=c;
        //前提是i不等于j，x^x=0,就会导致有一个值变为0
        //arr[i]=arr[i]^arr[j]
        //arr[j]=arr[i]^arr[j]
        //arr[i]=arr[i]^arr[j]
        System.out.println(arr[j]+" 交换 "+arr[i]);
    }

    public static void main(String[] args){
    int[] arr={3,6,4,5,7,2,1};
    int[] arr1={3,6,4,5,7,2,1};
    int[] arr2={3,6,4,5,7,2,1};
    bubbleSort(arr);//冒泡排序
    selectionSort(arr1);//选择排序
    insertSort(arr2);
    }
}
