// Useful link
// https://www.toptal.com/developers/sorting-algorithms/insertion-sort
// https://www.youtube.com/watch?v=8mJ-OhcfpYg

import java.util.Random;

public class Main{
    public static void main(String[] args)
    {
        int[] arr = new int[10];

        generateArray(arr);

        System.out.println("Before sort:");
        outputArray(arr);

        insertionSort(arr);
        
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
    static void insertionSort(int[] arr)
    {
        int temp, j;

        for(int i=1; i<arr.length; i++)
        {
            temp = arr[i]; 
            j = i - 1;
            
            while(j >= 0 && arr[j] > temp)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}