package Lv1;

/**
 *  프로그래머스 : 카드 뭉치
 *
 *  원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
 *  한 번 사용한 카드는 다시 사용할 수 없습니다.
 *  카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
 *  기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
 *
 *  문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때,
 *  cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는
 *  solution 함수를 완성해주세요
 *
 *  풀이 과정
 *  - Yes, No를 리턴할 enum 생성 or static final 상수로 선언
 *  - card1, card2의 현재 위치를 나타내줄 checkCard1, checkCard2
 *  - 현재 위치가 길이를 벗어나지 않고 goal의 현재 위치와 동일 하다면 계속 반복, 아니라면 No 리턴
 *
 */

public class BundleOfCards {
    enum Result{
        YES("Yes"),
        NO("No");

        private final String result;

        Result(String result){
            this.result = result;
        }
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int checkCards1 = 0, checkCards2 = 0;

        for (String s : goal) {
            if (cards1.length > checkCards1 && cards1[checkCards1].equals(s)) {
                checkCards1++;
            } else if (cards2.length > checkCards2 && cards2[checkCards2].equals(s)) {
                checkCards2++;
            } else {
                return Result.NO.result;
            }
        }
        return Result.YES.result;
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        BundleOfCards bundleOfCards = new BundleOfCards();
        System.out.println(bundleOfCards.solution(cards1, cards2, goal));
    }
}


