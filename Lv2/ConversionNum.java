package Lv2;

/**
 *  프로그래머스 : 숫자 변환하기
 *
 *  문제 설명
 *
 *  자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
 *  - x에 n을 더합니다
 *  - x에 2를 곱합니다.
 *  - x에 3을 곱합니다.
 *  자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를
 *  return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 *
 *  제한 사항
 *  - 1 ≤ x ≤ y ≤ 1,000,000
 *  - 1 ≤ n < y
 *
 *  풀이 과정
 *  - x부터 y까지 하나씩 숫자(i)를 올려가면서 i/2, i/3, i-n을 했을 때의 값을 가져와 비교한다
 *      - i/2, i/3, i-n을 했을 때 x보다 작다면 연산에서 제외한다
 *      - i/2, i/3가 자연수가 아니라면 연산에서 제외한다
 *  - i/2, i/3, i-n을 했을 때의 값들을 각각 가져와 최솟값을 구하고 그 최솟값이 제한사항보다 작다면 배열에 최솟값 + 1을 넣어준다
 *  - 이런식으로 계속 진행하여 만들 수 있을 때마다 +1을 해줘서 최소 방법을 구하고 배열[y]가 제한보다 작다면 배열[y] 값을, 아니라면 -1을 리턴한다
 */

public class ConversionNum {
    public static final int LIMIT = 1000001;

    public int solution(int x, int y, int n) {
        int[] comparisonNum = new int[y + 1];

        for (int i = x + 1; i < y + 1; i++) {
            int checkDiv2 = LIMIT, checkDiv3 = LIMIT, checkSubN = LIMIT;

            if(isHigherThanX(x, i / 2) && isDivided(i,2)){
                checkDiv2 = comparisonNum[i / 2];
            }
            if(isHigherThanX(x, i / 3) && isDivided(i, 3)){
                checkDiv3 = comparisonNum[i / 3];
            }
            if(isHigherThanX(x, i - n)){
                checkSubN = comparisonNum[i - n];
            }

            int min = Math.min(Math.min(checkDiv2, checkDiv3), checkSubN);

            comparisonNum[i] = min < LIMIT ? min + 1 : LIMIT;
        }

        return comparisonNum[y] < LIMIT ? comparisonNum[y] : -1;
    }

    private static boolean isHigherThanX(int x, int i) {
        return x <= i;
    }

    private static boolean isDivided(int i, int divide){
        return (i / divide > 0 && i % divide == 0);
    }

    public static void main(String[] args) {
        int x = 10, y = 40, n = 5;
        ConversionNum conversionNum = new ConversionNum();
        System.out.println(conversionNum.solution(x, y, n));
    }
}