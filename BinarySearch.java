package Git;

public class BinarySearch {
    public static void main(String[] args){
        int[] values = {0,1,2,3,4};
        int high = values.length - 1;
        int low = 0;
        int key = 1;
        int mid ;
        while(low<=high){
            mid = low + (high-low/2);
            if (key == values[mid]){
                System.out.println(values[mid]);
                break;
            }else if(key > values[mid]){
                low = mid+1;

            }else if(key < values[mid]){
                high = mid-1;
            }
        }
        if(low > high)
            System.out.println("Not Found");

    }
}
