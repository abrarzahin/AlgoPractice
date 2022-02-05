class Solution {
      // two pointer approach, time- ON, space- O1
    public int maxArea(int[] height) {
        int maxArea = 0; 
        if(height == null){
            return maxArea;
        }
        int left = 0;
        int right = height.length - 1; 
        while(left < right){
            int area = (right - left) * Math.min(height[left], 
height[right]);
            maxArea = Math.max(maxArea, area);
            
            if(height[left] < height[right]){
                left ++;
            }
            else {
                right --;
            }
        }
        return maxArea;
        
    }
}
