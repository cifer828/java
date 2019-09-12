
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1; 
        if (nums.length < 1) return -1;
        while (start < end) {
            int mid = (start + end) / 2;
            System.out.println(nums[mid]);
            if (nums[mid] >= nums[start]){
                if(target <= nums[mid] && target >= nums[start])
                    return binarySearch(nums, start, mid, target);
                else
                    start = mid + 1;
            }
            else {
                if (target >= nums[mid] && target <= nums[end])
                    return binarySearch(nums, mid, end, target);
                else
                    end = mid - 1;
            }
        }
        if (nums[(start + end) / 2] == target) return (start + end) / 2;
        else return -1;
    }
    private static int binarySearch(int[] nums, int left, int right, int tar) {
        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == tar) break;
            else if (nums[mid] > tar) right = mid - 1;
            else left = mid + 1;
        }
        if (nums[(left + right) / 2] == tar) return (left + right) / 2;
        else return -1;
    }
	public static void main(String[] args) {
		int [] test = {5, 1, 3};
		search(test, 25);
	}

}