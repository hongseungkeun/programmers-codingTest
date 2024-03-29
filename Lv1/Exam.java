package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 : 모의고사
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 풀이
 * - 전역변수 array 2차원 배열에 수포자들의 찍는 방식을 넣음
 * - 각각 수포자들의 찍는 방식의 반복되는 숫자 길이가 다름(1번은 5개 반복, 2번은 8개 반복)
 * - 따라서 문제와 수포자의 반복 길이를 나눈 몫으로 계산
 * - 그 중 최대값을 구한 뒤 최대값을 각각 수포자들의 최댓값과 비교 후 리스트에 추가
 * - 리스트를 int[]로 변환 뒤 return
 */
public class Exam {
    private final int[][] array = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
    };
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];
        int max = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(answers[i] == array[j][i%array[j].length]){
                    cnt[j]++;
                }
            }
        }

        for (int i = 0; i < array.length-1; i++) {
            int maxValue = Math.max(cnt[i],cnt[i+1]);
            if(max < maxValue){
                max = maxValue;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(max == cnt[i]){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        Exam exam = new Exam();
        System.out.println(Arrays.toString(exam.solution(answers)));
    }
}
