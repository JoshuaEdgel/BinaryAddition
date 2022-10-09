//Joshua Edgel
//Jan 25,2021
public class Binary {
    public static void main(String args[]) {
        int[] a = { 0, 2, 4, 6, 8 };
        System.out.print("Contents of Array A: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int search = 6;
        int search2 = 1;
        BinarySearch(a, search);
        BinarySearch(a, search2);
        boolean[] A = { false, true, false };
        boolean[] B = { true, true, false };
        System.out.print("Boolean Array A: ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        System.out.print("Boolean Array B: ");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println();
        System.out.print("Boolean Array A+B= ");
        boolean[] C = BinaryAddition(A, B);
        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i] + " ");
        }
    }

    public static boolean[] BinaryAddition(boolean[] A, boolean[] B) {
        if (A.length == B.length) {
            boolean[] C = new boolean[A.length + 1];
            for (int i = 0; i < A.length; i++) {
                if (A[i] && B[i] && C[i]) {
                    C[i] = true;
                    C[i + 1] = true;
                } else if (A[i] || B[i] && C[i]) {
                    C[i] = false;
                    C[i + 1] = true;
                } else if (A[i] && B[i] && !C[i]) {
                    C[i] = false;
                    C[i + 1] = true;
                } else if (A[i] && !B[i] && !C[i]) {
                    C[i] = true;
                    C[i + 1] = false;
                } else if (!A[i] && B[i] && !C[i]) {
                    C[i] = true;
                    C[i + 1] = false;
                } else if (!A[i] && !B[i] && C[i]) {
                    C[i] = true;
                    C[i + 1] = false;
                } else {
                    C[i] = false;
                    C[i + 1] = false;
                }
            }
            return C;
        } else {
            System.out.println("Error. boolean array lengths not equal.");
            return null;
        }
    }

    // Help from https://www.baeldung.com/java-binary-search
    public static int BinarySearch(int a[], int key) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == key) {
                System.out.println("Integer " + key + " found at spot " + m +
                        " in the array.");
                return m;
            } else if (a[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println("Integer " + key + " not found in array");
        return -1;
    }
}