class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return nums1;
        if(nums1 == null || nums1.length == 0) return nums1;
        if(nums2 == null || nums2.length == 0 ) return nums2;
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2 = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(pointer1 < len1 && pointer2 < len2){
            if(nums1[pointer1] < nums2[pointer2]){
                pointer1++;
            } else if(nums1[pointer1] > nums2[pointer2]){
                pointer2++;
            }else if(nums1[pointer1] == nums2[pointer2]){
                if(res.size() == 0) res.add(nums1[pointer1]);
                else{
                    if(res.get(res.size()-1) != nums1[pointer1] )
                        res.add(nums1[pointer1]);
                }
                pointer1++;
                pointer2++;
            }
        }
        int length = res.size();
        int[] empty = new int[0];
        if(length == 0) return empty;
        int[] output = new int[length];
        for(int i = 0; i< length; i++){
            output[i] = res.get(i);
        }
        
        return output;
    }
}
