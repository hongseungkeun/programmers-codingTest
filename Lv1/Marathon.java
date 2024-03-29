package Lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 : 완주하지 못한 선수
 *
 * - 한명의 선수를 제외한 모든 선수는 완주함
 * - 참가자 중에 동명이인이 있을 수 있음
 *
 * 풀이
 * - 먼저 참가자의 이름을 Map의 키값으로 넣음
 * - Map의 기능 getOrDefault를 사용해서 중복이 있다면 +1을 없다면 0을 리턴 해주도록 하여
 *   동명이인이 있더라도 검사할 수 있게 함
 * - 완주자가 만약 Map에 있다면 -1
 * - 위의 로직을 통해 만약 아직 1인 사람이 있다면 그 사람을 완주하지 못한 사람으로 판별
 *
 *
 * - break 추가 : 찾았다면 바로 반복문 탈출
 */
public class Marathon {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Map<String, Integer> people = new HashMap<>();
            for (String p : participant){
                people.put(p,people.getOrDefault(p, 0) + 1);
            }
            for(String c : completion){
                people.put(c, people.get(c) - 1);
            }
            for(String key : people.keySet()){
                if(people.get(key) != 0){
                    answer = key;
                    break;
                }
            }
            return answer;
        }


    public static void main(String[] args) {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        Marathon marathon = new Marathon();
        System.out.println(marathon.solution(part, comp));
    }
}
