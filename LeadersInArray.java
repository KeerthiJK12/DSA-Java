import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LeadersInArray {

    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = arr.length;
        int max = arr[n - 1];
        res.add(max);

        // traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                res.add(arr[i]);
            }
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // input array
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // get leaders
        ArrayList<Integer> result = leaders(arr);

        // // output
        System.out.println(result);
     
    }
}
