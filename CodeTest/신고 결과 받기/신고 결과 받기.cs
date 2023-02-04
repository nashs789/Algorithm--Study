using System;
using System.Linq;

public class Solution {
    public int[] solution(string[] id_list, string[] report, int k) {
        int[] answer = new int[id_list.Length];
        int[] receive = new int[id_list.Length];

        // 중복 제거
        report = report.Distinct().ToArray();

        // 신고 횟수 누적
        for (int i = 0; i < report.Length; i++) {
            string report_str = report[i].Split(' ')[1];
            int report_index = Array.IndexOf(id_list, report_str);
            receive[report_index]++;
        }

        // 신고 결과 누적
        for (int i = 0; i < report.Length; i++) {
            string[] report_arr = report[i].Split(' ');
            
            int report_index = Array.IndexOf(id_list, report_arr[1]);

            if (receive[report_index] >= k) {
                int send_index = Array.IndexOf(id_list, report_arr[0]);
                answer[send_index]++;
            }
        }

        return answer;
    }
}