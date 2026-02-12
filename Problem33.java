public class Problem33 {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int center = -1;
        while (left <= right) {
            center = (left + right) / 2;
            if (nums[center] == target) {
                return center;
            } else if (nums[center] < target) {
                left = center + 1;
            } else {
                right = center - 1;
            }

        }

        return right + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 5, 6 };
        int target = 2;
        Problem33 p = new Problem33();
        System.out.println(p.searchInsert(nums, target));
    }
}