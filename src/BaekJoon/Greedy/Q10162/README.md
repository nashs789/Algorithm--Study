# **[ 정보 ]**
1. 소요 시간: 
2. 날짜: 2023.01.28(토)
3. 저자: 이 인복

# **[ 신경 썼던 케이스 ]**

# **[ 접근 순서 ]**

# **[ 문제점 ]**
- 1차 시도: 시간 초과
    - O(N^2)의 시간 복잡도를 갖는 로직

          
          [ 초기 2중 for문 로직 ]
          public class Q1946_NewRecruits {
              public static void main(String[] args) throws IOException {
                  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  int cnt = Integer.parseInt(br.readLine());
  
                  for(int idx = 0; idx < cnt; idx++){
                      int peopleCnt = Integer.parseInt(br.readLine());
                      int[][] score = new int[peopleCnt][2];
                      int answer = peopleCnt;
          
                      for(int idx2 = 0; idx2 < score.length; idx2++){
                          int[] eachScore = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                          score[idx2][0] = eachScore[0];
                          score[idx2][1] = eachScore[1];
                      }
  
                      for(int i = 0; i < score.length; i++){
                          for(int j = 0; j < score.length; j++){
                              if(score[i][0] > score[j][0]){
                                  if(score[i][1] > score[j][1]){
                                      answer--;
                                      break;
                                  }
                              }
                          }
                      }
          
                      System.out.println(answer);
                  }
              }
          }

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**



         
