// Useful link
// https://www.toptal.com/developers/sorting-algorithms/selection-sort
// https://www.youtube.com/watch?v=EwjnF7rFLns

import java.util.Random;

public class Main{
    public static void main(String[] args)
    {
        int[] arr = new int[10];

        generateArray(arr);

        System.out.println("Before sort:");
        outputArray(arr);

        selectionSort(arr);
        
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
    static void selectionSort(int[] arr)
    {
        int min, temp;
        for(int i=0; i<arr.length; i++)
        {
            min = i;
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[min] > arr[j])
                {
                    min = j;
                }
            }

            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}