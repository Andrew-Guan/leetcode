class Solution {
    public int trap(int[] height) {
        int num = height.length;
        
        if(num == 0) return 0;
        else {
            // find the positions of the largest value, especially first and last. 
            int max = 0;
            for(int i=0; i<num; i++)
                max = (height[i]>max)? height[i]:max;
            int firstPos = -1;
            for(int i=0; i<num; i++) {
                if(height[i] == max) {
                    firstPos = i;
                    break;
                }else{
                    firstPos = -1;
                }
            }
            int lastPos = -1;
            for(int i = num - 1; i >= 0; i--){
                if(height[i] == max){
                    lastPos = i;
                    break;
                }else{
                    lastPos = -1;
                }
            }
            if(firstPos == lastPos){
                int trapped = 0;
                int currentMax = 0;
                for(int i = 0; i <= firstPos;i++){
                    if(currentMax < height[i]){
                        currentMax = height[i];
                    } else{
                        trapped += currentMax - height[i];
                    }
                }
                currentMax = 0;
                for(int i = num - 1; i>= lastPos; i--){
                    if(currentMax < height[i]){
                        currentMax = height[i];
                    } else{
                        trapped += currentMax - height[i];
                    }
                }
                return trapped;
                
            } else{
                int trapped = 0;
                int currentMax = 0;
                for(int i = 0; i <= firstPos;i++){
                    if(currentMax < height[i]){
                        currentMax = height[i];
                    } else{
                        trapped += currentMax - height[i];
                    }
                }
                for(int i = firstPos; i<= lastPos; i++){
                    trapped += max - height[i];
                }

                currentMax = 0;
                for(int i = num - 1; i>= lastPos; i--){
                    if(currentMax < height[i]){
                        currentMax = height[i];
                    } else{
                        trapped += currentMax - height[i];
                    }
                }
                return trapped;                
            }  
        }
    }
}
