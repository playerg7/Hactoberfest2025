void sortColors(int* nums, int numsSize) {
    for (int i = 0; i < numsSize; i++) {
        int min = i;
        for (int j = i + 1; j < numsSize; j++) {  
            if (nums[min] > nums[j]) {
                min = j;
            }
        }
        int temp = nums[i]; 
        nums[i] = nums[min];
        nums[min] = temp;
    }
}
