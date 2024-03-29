package Lv1;

/**
 *  프로그래머스 : 핸드폰 번호 가리기
 *
 *  문제 설명
 *
 *  전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를
 *  전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
 *
 *  풀이 과정
 *  - 뒤 4글자를 subString을 사용해서 잘라냄
 *  - 앞 부분을 반복을 통해 *로 채운 후 잘라낸 글자와 합쳐서 return
 */

public class CoveringPhoneNumber {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        String[] phoneNum = phone_number.split("");
        int phoneNumLength = phoneNum.length;

        String LastFourNum = phone_number.substring(phoneNumLength - 4, phoneNumLength);

        answer.append("*".repeat(Math.max(0, phoneNumLength - 4)));

        return answer + LastFourNum;
    }

    public static void main(String[] args) {
        String phone_number = "01033334444";
        CoveringPhoneNumber coveringPhoneNumber = new CoveringPhoneNumber();
        System.out.println(coveringPhoneNumber.solution(phone_number));
    }
}