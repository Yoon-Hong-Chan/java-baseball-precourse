package baseball;

import  camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static String question= "숫자를 입력해주세요 : ";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int number = Randoms.pickNumberInRange(100,999);
        System.out.print(question);
        String suggest = Console.readLine();
        if(validation(suggest)) throw new IllegalArgumentException();
    }

    public static boolean validation(String input) {
        if (!input.matches("-?\\d{3}+")) return false; //숫자만으로 이뤄진 3자리 수 체크

        Set set = new HashSet();
        String[] numbers = input.split("");
        for(String number : numbers){ // 같은 숫자 존재 유무 체크
            if(set.contains(number)) return false;
            set.add(number);
        }
        return true;
    }
}
