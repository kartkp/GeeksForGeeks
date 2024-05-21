import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    private int findCrossOver(int[] arr, int low, int high, int x) {
        if (arr[high] <= x) {
            return high;
        }
        if (arr[low] > x) {
            return low;
        }
        int mid = (low + high) / 2;
        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        } else if (arr[mid] < x) {
            return findCrossOver(arr, mid + 1, high, x);
        }
        return findCrossOver(arr, low, mid - 1, x);
    }

    public int[] printKClosest(int[] arr, int n, int k, int x) {
        int[] result = new int[k];
        int l = findCrossOver(arr, 0, n - 1, x);
        int r = l + 1;
        int count = 0;

        PriorityQueue<Integer> closest = new PriorityQueue<>(Comparator.comparingInt(a -> Math.abs(a - x)));

        while (l >= 0 && r < n && count < k) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                closest.add(arr[l--]);
            } else {
                closest.add(arr[r++]);
            }
            count++;
        }
        while (count < k && l >= 0) {
            closest.add(arr[l--]);
            count++;
        }
        while (count < k && r < n) {
            closest.add(arr[r++]);
            count++;
        }
        for (int i = 0; i < k; i++) {
            result[i] = closest.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        KClosestElements obj = new KClosestElements();
        int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int n = arr.length;
        int k = 4;
        int x = 35;
        int[] result = obj.printKClosest(arr, n, k, x);
        System.out.println("The " + k + " closest elements to " + x + " are:");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
