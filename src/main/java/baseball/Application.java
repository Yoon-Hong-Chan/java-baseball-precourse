package baseball;

import  camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static String question= "숫자를 입력해주세요 : ";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true)
            if(playGame().equals("2"))break;
    }

    public static String playGame(){
        String number;
        while(true){
            String tmpNumber = String.valueOf(Randoms.pickNumberInRange(100,999));
            if(checkDuplicateNumber(tmpNumber)){
                number = tmpNumber;
                break;
            }
        }
        System.out.println(number);
        while (true){
            System.out.print(question);
            String suggest = Console.readLine();
            if(!inputValidation(suggest)) throw new IllegalArgumentException();
            if(distinguishBallCount(number,suggest))break;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
    public static boolean distinguishBallCount(String number, String input){
        int strike = 0;
        int ball = 0;
        List<String> numbers = Arrays.asList(number.split(""));
        List<String> inputs = Arrays.asList(input.split(""));
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i).equals(inputs.get(i))) {
                strike++;
                continue;
            }
            if(numbers.contains(inputs.get(i))) ball++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(ball != 0) stringBuilder.append(ball+"볼 ");
        if(strike != 0) stringBuilder.append(strike+"스트라이크");
        if(ball == 0 && strike ==0 ) stringBuilder.append("낫싱");
        System.out.println(stringBuilder);

        return (strike == 3);
    }

    public static boolean checkDuplicateNumber(String input){
        Set set = new HashSet();
        String[] numbers = input.split("");
        for(String number : numbers){ // 같은 숫자 존재 유무 체크
            if(set.contains(number)) return false;
            set.add(number);
        }
        return true;
    }

    public static boolean inputValidation(String input) {
        if (!input.matches("-?\\d{3}+")) return false; //숫자만으로 이뤄진 3자리 수 체크
        return checkDuplicateNumber(input); // 중복 체크
    }
}
