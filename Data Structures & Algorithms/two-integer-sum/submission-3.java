class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> sample = new HashMap<>();// value -> index
        for (int i =0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (sample.containsKey(diff) && sample.get(diff) !=i) {
                return new int[]{sample.get(diff),i};
            }
            sample.put(nums[i],i);
        }

        return new int[]{0,0};
    }
}
