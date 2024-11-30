package doublePointer;

public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[] { 0, 1, 2, 0, 3, 0, 5 });
    }

    /**
     * 递归
     *
     * @param nums
     */
    public static void moveZeroesByRecursion(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // TODO 递归


    }


    /**
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 找0值
            if (nums[i] == 0) {
                for(int j = i + 1; j < nums.length; j++) {
                    // 找非0值
                    if (nums[j] != 0) {
                        // exchange
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
        // print
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
