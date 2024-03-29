package Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  프로그래머스 : 귤 고르기
 *
 *  문제 설명
 *
 *  귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 할 때 귤 6개를 판매하고 싶다면,
 *  크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로
 *  총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
 *  한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다.
 *  귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 *
 *  풀이 과정
 *
 *  - map의 key와 value를 각각 귤 크기와 귤 개수로 설정
 *  - map을 귤 개수를 개준으로 내림차순으로 정렬
 *  - 반복을 통해 k보다 귤 개수가 많다면 break, 적다면 k에 귤 개수를 빼고 계속 반복 실행
 *
 *  - map의 entry를 통한 정렬과 반복문 때문에 코드가 장황하다고 느껴졌다.
 *  - 다른 좋은 방법이 생각나면 좋을 것 같다.
 *
 */

public class PickTangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> tangerineMap = new HashMap<>();
        for (int tan : tangerine){
            tangerineMap.put(tan,tangerineMap.getOrDefault(tan,0)+1);
        }
        List<Map.Entry<Integer, Integer>> tangerines = new ArrayList<>(tangerineMap.entrySet());
        tangerines.sort(Map.Entry.comparingByValue(((o1, o2) -> o2 - o1)));

        for (Map.Entry<Integer, Integer> entry : tangerines) {
            answer++;
            if(entry.getValue() >= k){
                break;
            }else{
                k -= entry.getValue();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        PickTangerine pickTangerine = new PickTangerine();
        System.out.println(pickTangerine.solution(k,tangerine));
    }
}
