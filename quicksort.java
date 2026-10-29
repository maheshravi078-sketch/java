
import java.util.Random;
import java.util.Scanner;

public class quicksort {
    static int max = 2000;

    int partition(int[] a, int low, int high) {
        int p = a[low];
        int i = low + 1;
        int j = high;
        int temp;

        while (i <= j) {
            while (i <= high && a[i] <= p)
                i++;

            while (a[j] > p)
                j--;

            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        temp = a[low];
        a[low] = a[j];
        a[j] = temp;

        return j;
    }

    void sort(int[] a, int low, int high) {
        if (low < high) {
            int s = partition(a, low, high);
            sort(a, low, s - 1);
            sort(a, s + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("Enter the array size");
        int n = sc.nextInt();

        if (n < 1 || n > max) {
            System.out.println("Enter a size between 1 and 2000");
            sc.close();
            return;
        }

        int[] a = new int[max];

        for (int i = 0; i < n; i++)
            a[i] = generator.nextInt(100);

        System.out.println("Array before sorting");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        long startTime = System.nanoTime();

        quicksort m = new quicksort();
        m.sort(a, 0, n - 1);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;

        System.out.println("\nTime taken to sort array is: "
                + elapsedTime + " nanoseconds");

        System.out.println("Sorted array is");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        sc.close();
    }
}
