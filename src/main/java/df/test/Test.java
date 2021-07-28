package df.test;

public class Test {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return binarySearch(arr, target, 0, arr.length);
    }

    private static int binarySearch2(int[] arr, int target, int b, int e) {
        if (b >= e) {
            return -1;
        }
        int mid = (b+e)/2;
        if(target == arr[mid]) {
            return mid;
        }else if(target > arr[mid]){
            return binarySearch(arr, target, mid+1, e);
        } else {
            return binarySearch(arr, target, b, mid-1);
        }
    }

    private static int binarySearch(int[] arr, int target, int b, int e) {
        int mid;
        while(b<e){
            mid = (b+e)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                b = mid + 1;
            } else{
                e = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 1));
        System.out.println(search(new int[]{}, 1));
        System.out.println(search(new int[]{1,3,4,5}, 6));
        System.out.println(search(new int[]{1,3,4,5}, 4));
    }
}
