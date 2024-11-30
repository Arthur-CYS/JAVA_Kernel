package doublePointer;

public class MaxArea {

    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int result = 0;

        if (height == null || height.length == 0){
            return result;
        }

        int front = 0;
        int rear = height.length - 1;

        while (front < rear) {
            int area = Math.min(height[front], height[rear]) * (rear - front);
            if (area > result) {
                result = area;
            }

            if (height[front] < height[rear]) {
                front ++;
            } else {
                rear --;
            }
        }

        System.out.println(result);

        return result;
    }

}
