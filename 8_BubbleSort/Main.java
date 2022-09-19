// Useful link
// https://www.toptal.com/developers/sorting-algorithms/bubble-sort
// https://www.youtube.com/watch?v=Dv4qLJcxus8

import java.util.Random;

public class Main{
    public static void main(String[] args) 
    {
        int[] arr = new int[10];

        generateArray(arr);

        System.out.println("Before sort:");
        outputArray(arr);

        bubbleSort(arr);
        
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
    static void bubbleSort(int[] arr)
    {
        boolean skip;

        for(int i=0; i<arr.length - 1; i++)
        {   
            skip = true;
            for(int j=0; j<arr.length - 1 - i; j++)
            {
                if(arr[j] > arr[j+1])
                { 
                    /*  This is also a way to do with only 2 variables
                     *  arr[j] += arr[j+1];
                     *  arr[j+1] = arr[j] - arr[j+1];
                     *  arr[j] -= arr[j+1];
                     */

                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;

                     skip = false;
                }
            }
            if(skip)
            {
                break;
            }
        }
    }
}
