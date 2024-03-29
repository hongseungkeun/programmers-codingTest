package Lv1;

/**
 *  프로그래머스 : 문자열 나누기
 *
 *  문제 설명
 *
 *  문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.
 *  - 먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
 *  - 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
 *  - s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
 *  - 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
 *  문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를
 *  return 하는 함수 solution을 완성하세요.
 *
 *  풀이 과정
 *  - 첫글자(x)와 x가 아닌 글자의 count가 같을 시에 answer++
 *  - 마지막에 문자열이 남았다면 answer++를 해주고 반복을 종료해준다
 *
 *  - x의 개수와 x가 아닌 글자 개수 두개를 비교했는데 x라면 count++, x가 아니면 count-- 해주는 방식도 좋아보인다
 */

public class DivideString {
    public static final String NEED_X = "needX";

    public int solution(String s) {
        int answer = 0;
        int xCount = 0;
        int subCount = 0;
        String[] split = s.split("");
        String x = NEED_X;

        for (int i = 0; i < split.length; i++) {
            if(i == split.length-1){
                answer++;
                break;
            }

            if(x.equals(NEED_X)){
                x = split[i];
                xCount++;
                continue;
            }

            if (split[i].equals(x)){
                xCount++;
            }else {
                subCount++;
            }

            if(xCount == subCount){
                answer++;
                x = NEED_X;
                xCount = 0;
                subCount = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        DivideString divideString = new DivideString();
        System.out.println(divideString.solution(s));
    }
}