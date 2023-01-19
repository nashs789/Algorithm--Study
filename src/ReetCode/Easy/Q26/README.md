# **[ 정보 ]**
1. 소요 시간: 60분 초과(오래 걸림....)
2. 날짜: 2023.01.19(목)
3. 저자: 이 인복

# **[ 접근 순서 ]**
**1. 규칙 찾기**
- 이게 이 문제의 알파이자 오메가 였던것 같다.

1.     0011122334
2.     0111122334
3.     0111122334
4.     0111122334
5.     0121122334
6.     0121122334
7.     0123122334
8.     0123122334
9.     0123422334

# **[ 문제점 ]**
규칙 찾는게 힘들었음....

- 1차 시도: 성공

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int point = 0;

        for(int idx = 1; idx < nums.length; idx++){
            if(nums[point] < nums[idx]){
                nums[++point] = nums[idx];
            }
        }

        System.out.println(point + 1);

- 2차 시도: 성공 (성능 향상을 위한 break 추가)

        int point = 0;

        for(int idx = 1; idx < nums.length; idx++){
            if(nums[point] < nums[idx]){
                nums[++point] = nums[idx];
            } else if(nums[point] > nums[idx]){
                break;
            }
        }

        return point + 1;

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
- 1차 시도: 

- 2차 시도:


         
