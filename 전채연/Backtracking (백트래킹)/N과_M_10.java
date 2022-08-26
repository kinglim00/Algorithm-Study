/*
    백준 15664번 : N과 M (10)
    - 문제 유형 : 백트래킹
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;

public class N과_M_10{
    static int N;           // 변수 N
    static int M;           // 변수 M
    static int[] sequence;  // 수열
    static int[] counting;  // 카운팅을 위한 배열
    static int[] number;    // 자연수 배열
    static HashSet<String> answer = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    // 깊이 우선 탐색 메서드
    static void dfs(int depth){
        // M개의 수로 구성된 수열을 완성한 경우
        if (depth == M) {
            // 수열 출력
            String s = "";
            for (int i = 0; i < M; i++)
                s += number[sequence[i]] + " ";
            // 중복된 결과 제거
            if (!answer.contains(s)) {
                answer.add(s);
                sb.append(s);
                sb.append("\n");
            }
            return;
        }

        for (int i = (depth == 0)? 1 : sequence[depth - 1]; i <= N; i++) {
            if (counting[i] == 0) {
                sequence[depth] = i;
                counting[i]++;
                dfs(depth + 1);
                counting[sequence[depth]]--;
            }
        }
        // 조건에 만족하는 수가 없다면 백트래킹
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N 입력
        counting = new int[N + 1];
        number = new int[N + 1];
        M = Integer.parseInt(st.nextToken()); // M 입력
        sequence = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(st.nextToken()); // 자연수 입력
        }
        Arrays.sort(number); // 오름차순 정렬

        dfs(0); // 깊이 우선 탐색 시작

        System.out.println(sb);
    }
}
