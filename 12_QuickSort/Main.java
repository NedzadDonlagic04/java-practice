// Useful links
// https://www.toptal.com/developers/sorting-algorithms/quick-sort
// https://www.youtube.com/watch?v=Vtckgz38QHs
// https://www.youtube.com/watch?v=h8eyY7dIiN4

import java.util.Random;

public class Main{
    public static void main(String[] args)
    {
        int[] arr = new int[10];

        generateArray(arr);

        System.out.println("Before sort:");
        outputArray(arr);

        quickSort(arr, 0, arr.length - 1);
        
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
    static void quickSort(int[] arr, int start, int end)
    {
        if(start >= end)
        {
            return;
        }

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
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