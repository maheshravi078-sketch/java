
import java.util.Random;
import java.util.Scanner;

public class mergesort {
    static int max = 10000;

    void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        int[] resarray = new int[max];

        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                resarray[k++] = array[i++];
            } else {
                resarray[k++] = array[j++];
            }
        }

        while (i <= mid)
            resarray[k++] = array[i++];

        while (j <= high)
            resarray[k++] = array[j++];

        for (int m = low; m <= high; m++)
            array[m] = resarray[m];
    }

    void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            sort(array, low, mid);
            sort(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("Enter the array size");
        int n = sc.nextInt();

        if (n < 1 || n > max) {
            System.out.println("Enter a size between 1 and 10000");
            sc.close();
            return;
        }

        int[] array = new int[max];

        for (int i = 0; i < n; i++)
            array[i] = generator.nextInt(100);

        System.out.println("Array before sorting");
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");

        long startTime = System.nanoTime();

        mergesort m = new mergesort();
        m.sort(array, 0, n - 1);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;

        System.out.println("\nTime taken to sort array is: "
                + elapsedTime + " nanoseconds");

        System.out.println("Sorted array is:");
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");

        sc.close();
    }
}
