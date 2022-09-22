import java.util.Random;

public class Main{
    public static void main(String[] args)
    {
        int[] arr = getArr(10000, 100000);

        BubbleSort.test(arr.clone());
        InsertionSort.test(arr.clone());
        SelectionSort.test(arr.clone());
        MergeSort.test(arr.clone());
        QuickSort.test(arr.clone());
    }

    private static int[] getArr(int length, int range)
    {
        int[] arr = new int[length];
        
        Random random = new Random(); 

        for(int i=0; i<length; i++)
        {
            arr[i] = random.nextInt(range);
        }

        return arr;
    }
}

// Class with some methods which I'll use in each comparison
abstract class Sort{

    static long time;

    protected static void startTime()
    {
        time = System.nanoTime();
    }

    protected static void stopTime()
    {
        time = System.nanoTime() - time;
    }

    protected static void printTimeTaken(String sortType) 
    {
        System.out.print(sortType + " - Time Taken in Seconds: ");
        System.out.println( (double) time / 1_000_000_000 );
    }

    protected static void printArr(int[] arr, String text)
    {
        System.out.println(text);

        for(int i : arr)
        {
            System.out.print(i + " ");
        }

        System.out.println("");
    }
}

// Class used to represent bubble sort
class BubbleSort extends Sort{
    public static void test(int[] arr)
    {
        printArr(arr, "Before: ");

        startTime();
        sort(arr);
        stopTime();
        
        printArr(arr, "\nAfter: ");

        printTimeTaken("BubbleSort");

        System.out.println("");
    }

    public static void sort(int[] arr)
    {
        for(int i=0; i<arr.length - 1; i++)
        {
            for(int j=0; j<arr.length - 1 -i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int index1,int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

// Class used to represent insertion sort
class InsertionSort extends Sort{
    public static void test(int[] arr)
    {
        printArr(arr, "Before: ");

        startTime();
        sort(arr);
        stopTime();
        
        printArr(arr, "\nAfter: ");

        printTimeTaken("InsertionSort");

        System.out.println("");
    }

    public static void sort(int[] arr)
    {
        int j;
        for(int i=1; i<arr.length; i++)
        {
            j = i;
            while(j > 0 && arr[j - 1] > arr[j])
            {
                swap(arr, j-1, j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int index1,int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

// Class used to represent selection sort
class SelectionSort extends Sort{
    public static void test(int[] arr)
    {
        printArr(arr, "Before: ");

        startTime();
        sort(arr);
        stopTime();
        
        printArr(arr, "\nAfter: ");

        printTimeTaken("SelectionSort");

        System.out.println("");
    }

    public static void sort(int[] arr)
    {
        int temp;
        for(int i=0; i<arr.length; i++)
        {
            temp = i;
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[temp] > arr[j])
                {
                    temp = j;
                }
            }
            swap(arr, i, temp);
        }
    }

    private static void swap(int[] arr, int index1,int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

// Class used to represent merge sort
class MergeSort extends Sort{
    public static void test(int[] arr)
    {
        printArr(arr, "Before: ");

        startTime();
        sort(arr);
        stopTime();
        
        printArr(arr, "\nAfter: ");

        printTimeTaken("MergeSort");

        System.out.println("");
    }

    public static void sort(int[] arr)
    {
        if(arr.length < 2)
        {
            return;
        }

        int leftLen = arr.length / 2;
        int rightLen = arr.length - leftLen;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for(int i=0; i<leftLen; i++)
        {
            leftArr[i] = arr[i];
        }

        for(int i=leftLen; i<arr.length; i++)
        {
            rightArr[i - leftLen] = arr[i];
        }

        sort(leftArr);
        sort(rightArr);
        merge(leftArr, rightArr, arr);
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] arr)
    {
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;
        int i = 0, r = 0, l = 0;

        while(l < leftLen && r < rightLen)
        {
            if(leftArr[l] < rightArr[r])
            {
                arr[i] = leftArr[l];
                l++;
            }
            else
            {
                arr[i] = rightArr[r];
                r++;
            }
            i++;
        }

        while(l < leftLen)
        {
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        while(r < rightLen)
        {
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }
}

// Class used to represent quick sort
class QuickSort extends Sort{
    public static void test(int[] arr)
    {
        printArr(arr, "Before: ");

        startTime();
        sort(arr);
        stopTime();
        
        printArr(arr, "\nAfter: ");

        printTimeTaken("QuickSort");

        System.out.println("");
    }

    public static void sort(int[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int start, int end)
    {
        if(start >= end)
        {
            return;
        }

        int pivot = partition(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int start, int end)
    {
        int pivotIndex = new Random().nextInt(end - start) + start;
        int pivot = arr[pivotIndex];
        int i = start - 1;

        for(int j=start; j<=end; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        i++;

        swap(arr, i, end);        

        return i;
    }

    static void swap(int[] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}