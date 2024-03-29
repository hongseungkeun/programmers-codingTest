package Lv1;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  프로그래머스 : 둘만의 암호
 *
 *  문제 설명
 *
 *  두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다.
 *  암호의 규칙은 다음과 같습니다.
 *
 *  - 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
 *  - index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
 *  - skip에 있는 알파벳은 제외하고 건너뜁니다.
 *
 *  두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를
 *  return하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *
 *  - 먼저 s, skip을 쪼개고 모든 char들을 리스트에 넣어준다
 *  - char들이 담긴 리스트에서 skip 리스트를 없애준다
 *      - 만약 skip들을 뺀 리스트의 사이즈보다 인덱스가 크거나 같다면 index에서 사이즈만큼 빼준다
 *  - s를 쪼갠 리스트로 반복을 통해 인덱스 위치를 찾고 그 위치에 index 값을 1부터 더하는 반복을 한다
 *      - 만약 더한 값이 리스트 사이즈보다 크거나 같다면 더 이상 진행할 수 없으므로 인덱스에서 반복한 횟수만큼 빼준다
 *      - 리스트에서 인덱스와 index를 더한 인덱스로 찾아 answer에 더해준다
 *
 */

public class BetweenTwoPeople {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String[] splitS = s.split("");
        List<String> splitSkip = Arrays.asList(skip.split(""));
        List<Character> characters = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            characters.add(i);
        }

        List<String> excludeSkip = characters.stream().map(String::valueOf).collect(Collectors.toList());
        excludeSkip.removeAll(splitSkip);

        if(excludeSkip.size() <= index){
            index -= excludeSkip.size();
        }

        for (String split : splitS) {
            int IndexOfS = excludeSkip.indexOf(split);

            for (int j = 1; j <= index; j++) {
                if (excludeSkip.size() <= IndexOfS + j) {
                    IndexOfS = -j;
                    break;
                }
            }

            answer.append(excludeSkip.get(IndexOfS + index));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        BetweenTwoPeople betweenTwoPeople = new BetweenTwoPeople();
        System.out.println(betweenTwoPeople.solution(s, skip, index));
    }
}