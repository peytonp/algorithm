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

    public static void quickSort(int[] arr){

    }

    //交换数组中两个元素
    public static void swap(int[] arr,int i,int j){
        int c=arr[i];
        arr[i]=arr[j];
        arr[j]=c;
        System.out.println(arr[j]+" 交换 "+arr[i]);
    }

    public static void main(String[] args){
    int[] arr={6,5,4,3,2,1};
    int[] arr1={6,5,4,3,2,1};
    bubbleSort(arr);//冒泡排序
    selectionSort(arr1);//选择排序
    }
}
