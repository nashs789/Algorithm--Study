# **[ 정보 ]**
1. 소요 시간: 60분 초과 
2. 날짜: 2023.01.05(목)
3. 저자: 이 인복

# **[ 접근 순서 ]**
1. 신고 문자열 어떻게 나눠서 신고자와 신고당한 사람을 관리할까?
   

2. 신고 정보 관리하는 콜렉션에서 어떻게 신고당한 사람을 카운트하고 처리 결과 메세지를 받을 사람들을 산출할지?
   

3. 중복된 신고와 자기 자신을 신고하는 케이스를 어떻게 처리할지?

# **[ 구현 순서 ]**
1. HashMap<String, HashSet<String>> 자료 구조 선정
   - {muzi=[apeach], neo=[muzi, frodo], frodo=[muzi, apeach]} '신고당한 사람'=[신고자, 신고자, 신고자]의
     형태로 관리하도록 선언
     

2. setReportInfo 메소드 구현
   - 앞서 구현한 자료 구조를 초기화 하는 함수 구현
   
   
3. setReportTotal 메소드 구현
   - 주어진 최대 경고 횟수 k를 기준으로 해당하는 유저들을 선정하고, 처리 결과를 메일로 받을 
     유저들을 선정
   
4. 주어진 배열에 유저 정보 순서대로 처리 메일 숫자를 선정해야 하기 때문에 반복문 추가 (main 로직)

# **[ 문제점 ]**
- 1차 시도: 5 / 24 ===> 로직 확인 결과를 보니 본인이 본인 신고하는 경우 처리하지 않음 (실패:19개 시간초과: 0개)
  

- 2차 시도: 5 / 24 ===> 1차에서 시도했던 로직을 처리 했지만 결과가 같아서 확인 해보니 신고 회수 로직을 제대로 처리하지 못했음
                      신고회수 2이면 2만 체크하고 그 이상 신고받은 사람은 체크를 하지 않았음(실패: 19개 시간초과: 0개)


- 3차 시도: 3차: 22/24 ===> 로직 수정 ( ? == k 에서 ? >= k) 후 시간초과 발생 (실패: 0개 시간초과: 2개)
   - 코드 분석 결과: 선형 탐색이 너무 많아서 성능을 저하 시키는 요인으로 판단
   
         [ 문제의 코드 ]
   
           public class ReportResultMessage {
           public static void main(String[] args) {
           String[] id_list = {"muzi", "frodo", "apeach", "neo", "a", "bb", "ccc", "c", "bbb", "aaa", "aa", "b"};
           String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "muzi muzi"};
           int k = 2;
           int[] answer = new int[id_list.length];
   
           Map<String, Integer> reportCntMap = getStrArrToMap(id_list);
           Map<String, String> reportInfoMap = setReportMap(report, reportCntMap);
   
           for(String reportedName : reportCntMap.keySet()){
               if(reportCntMap.get(reportedName) >= k){    // 신고 누적 횟수가 max인 사람
                   for(String reporterName : reportInfoMap.keySet()){
                       if(reportedName.equals(reporterName.substring(reporterName.indexOf(" ") + 1))){
                           String getMessageUser = reporterName.substring(0, reporterName.indexOf(" ")); // 처리결과 메일을 받는 유저
   
                           for(int idx = 0; idx < id_list.length; idx++){
                               if(id_list[idx].equals(getMessageUser)){
                                   answer[idx] += 1;
                               }
                           }
                       }
                   }
               }
           }
   
                 for(int i : answer){
                     System.out.print(i);
                 }
           }
   
           private static Map<String, String> setReportMap(String[] report, Map<String, Integer> reportCntMap) {
           Map<String, String> map = new HashMap<>();
         
                 for(int idx = 0; idx < report.length; idx++){
                     String reportInfo = report[idx];
                     int boundary = reportInfo.indexOf(" ");
                     String reporter = reportInfo.substring(0, boundary);
                     String reportedMan = reportInfo.substring(boundary + 1);
         
                     if(map.get(reportInfo) == null && !reportedMan.equals(reporter)){
                         map.put(reportInfo, reporter);
                         reportCntMap.put(reportedMan, reportCntMap.get(reportedMan) + 1);
                     }
                 }
         
                 return map;
           }
         
           private static Map<String, Integer> getStrArrToMap(String[] id_list){
           Map<String, Integer> map = new HashMap<>();
         
                 for(int idx = 0; idx < id_list.length; idx++){
                     map.put(id_list[idx], 0);
                 }
         
                 return map;
           }


# **[ 결과 ]**
<img width="427" alt="스크린샷 2023-01-15 오전 11 20 05" src="https://user-images.githubusercontent.com/59809278/212519630-a39a0576-fec4-42be-b27a-35dbf7ab1aaf.png">
