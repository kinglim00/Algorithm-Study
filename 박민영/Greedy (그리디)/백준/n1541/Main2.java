/*
 * @author Minyeong Park
 * @date 2022.06.29.
 * 잃어버린 괄호 (다른 코드 공부 1)
 * 원리 및 코드 참고 : https://st-lab.tistory.com/148, https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rain483&logNo=220723525725
 * 문제 링크 : https://www.acmicpc.net/problem/1541
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        int sum = Integer.MAX_VALUE; // 초기 상태 여부 확인을 위한 값으로 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split("-");

        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            String[] temp_arr = arr[i].split("\\+");

            for (int j = 0; j < temp_arr.length; j++) {
                temp += Integer.parseInt(temp_arr[j]);
            }

            // 첫번째 토큰인 경우 temp 값이 첫 번째 수가 됨.
            if (sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }

        System.out.println(sum);
    }
}