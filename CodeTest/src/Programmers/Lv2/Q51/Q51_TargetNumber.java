package Programmers.Lv2.Q51;

public class Q51_TargetNumber {

    public static int[] nums;
    public static int tar;
    public static int total = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        nums = numbers;
        tar = target;

        dfs(0, 0);
        System.out.println(total);
    }

    public static void dfs(int idx, int acc){
        int plus = nums[idx] + acc;
        int minus = (nums[idx] * -1) + acc;
        int nextIdx = idx + 1;

        // 순회가 전부 끝난 경우
        if(idx == nums.length - 1){
            // 타겟 넘버에 도달한 경우
            if(plus == tar || minus == tar){
                total++;
            }
            return;
        }

        dfs(nextIdx, plus);
        dfs(nextIdx, minus);
    }
}