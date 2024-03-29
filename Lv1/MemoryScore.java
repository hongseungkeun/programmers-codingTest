package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 추억 점수
 *
 *  문제 설명
 *  사진들을 보며 추억에 젖어 있던 루는 사진별로 추억 점수를 매길려고 합니다.
 *  사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다.
 *  예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가
 *  [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다. 다른 사진 속 인물의 이름이
 *  ["kali", "mari", "don", "tony"]이고 ["kali", "mari", "don"]의 그리움 점수가 각각
 *  [11점, 1점, 55점]]이고, "tony"는 그리움 점수가 없을 때, 이 사진의 추억 점수는 3명의 그리움 점수를
 *  합한 67(11 + 1 + 55)점입니다.
 *
 *  그리워하는 사람의 이름을 담은 문자열 배열 name, 각 사람별 그리움 점수를 담은 정수 배열 yearning,
 *  각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때,
 *  사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - key와 value가 각각 이름과 추억 점수인 HashMap과 2차원 배열 반복을 통해 이름이 HashMap에 있다면
 *  - 그 이름으로 추억 점수를 가져오는 방식으로 풀이
 */

public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> memory = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            memory.put(name[i], yearning[i]);
        }

        for (String[] photos : photo) {
            int score = 0;
            for (String p : photos) {
                if (memory.containsKey(p)) {
                    score += memory.get(p);
                }
            }
            list.add(score);
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        MemoryScore memoryScore = new MemoryScore();
        System.out.println(Arrays.toString(memoryScore.solution(name,yearning,photo)));
    }
}
