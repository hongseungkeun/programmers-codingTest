package Lv1;

/**
 *  프로그래머스 : 나머지가 1이 되는 수 찾기
 *
 *  문제 설명
 *  자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를
 *  return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.
 *
 *  제한 사항
 *  - 3 ≤ n ≤ 1,000,000
 *
 *  풀이 과정
 *  - 단순 연산이므로 stream으로 하기엔 너무 좋지 않은 방법이라고 생각해 for문 사용
 *  - 제한 사항에 n이 3이상이므로 3일 때 나머지가 1인 2로 반복문을 시작
 *  - 찾게 되면 더 계산 없이 break를 통해 반복 탈출
 *
 */

public class FindNumberTheRestBecomeOne {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if(n % i == 1){
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        FindNumberTheRestBecomeOne findNumberTheRestBecomeOne = new FindNumberTheRestBecomeOne();
        System.out.println(findNumberTheRestBecomeOne.solution(n));
    }
}