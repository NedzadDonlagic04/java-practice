// Useful links
// https://www.toptal.com/developers/sorting-algorithms/merge-sort
// https://www.youtube.com/watch?v=3j0SWDX4AtU
// https://www.youtube.com/watch?v=bOk35XmHPKs
import java.util.Random;

public class Main{
    public static void main(String[] args)
    {
        int[] arr = new int[10];

        generateArray(arr);

        System.out.println("Before sort:");
        outputArray(arr);

        mergeSort(arr);
        
        System.out.println("After sort:");
        outputArray(arr);
    }

    // Generates random numbers for each array index
    static void generateArray(int[] arr)
    {
        Random random = new Random();

        for(int i=0; i<arr.length; i++)
        {
            arr[i] = random.nextInt(100);
        }
    }

    // Output array
    static void outputArray(int[] arr)
    {
        for(int i : arr)
        {
            System.out.printf("%d ", i);
        }
        System.out.println("");
    }

    // Sorting algorithm
    static void mergeSort(int[] arr)
    {
        int length = arr.length;
        if(length < 2)
        {
            return;
        }

        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        for(int i=0; i<middle; i++)
        {
            leftArr[i] = arr[i];
        }

        for(int i=middle; i<length; i++)
        {
            rightArr[i - middle] = arr[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }

    static void merge(int[] leftArr, int[] rightArr, int[] arr)
    {
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize)
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

        while(l < leftSize)
        {
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        while(r < rightSize)
        {
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }
}