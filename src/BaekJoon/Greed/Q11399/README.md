# **[ 정보 ]**
1. 소요 시간: 21:51 - 23:09 (1시간 16분)
2. 날짜: 2023.01.24(화)
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. 효율적인 방법 고안
- 오름차순이 가장 합하다고 판단

# **[ 문제점 ]**
- 문제는 간단해서 로직 짜는데는 15분정도 걸렸다. (근데 통과가 안됨)

      public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
          int cnt = Integer.parseInt(br.readLine());
          String[] eachTimes = br.readLine().split(" ");
          int accTime = 0;
          int answer = 0;
  
          Arrays.sort(eachTimes);
  
          for(int idx = 0; idx < cnt; idx++){
              accTime += Integer.parseInt(eachTimes[idx]);
              answer += accTime;
          }
  
          System.out.println(answer);
      }

- BufferedReader 를 사용해서 입력 받다가 Scanner 로 변경하고 통과했음. (아직 이유는 못 찾았다.)


    [ 수정된 코드 ]
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt(); 
        int[] eachTimes = new int[cnt];

        for(int idx = 0; idx < cnt; idx++){
            eachTimes[idx] = sc.nextInt();
        }

        int accTime = 0;
        int answer = 0;

        Arrays.sort(eachTimes);

        for(int idx = 0; idx < cnt; idx++){
            accTime += eachTimes[idx]; 
            answer += accTime;
        }

        System.out.println(answer);
    }

# **[ 새로 알게된 사실 ]**


# **[ 결과 ]**
<img width="1141" alt="스크린샷 2023-01-24 오후 11 24 55" src="https://user-images.githubusercontent.com/59809278/214320236-e93f7f1e-8826-42e2-94cb-89b7bc183df4.png">




         
