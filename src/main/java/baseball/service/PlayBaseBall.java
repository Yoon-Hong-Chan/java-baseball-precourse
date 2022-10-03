package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayBaseBall {
 final int endStrikeCount = 3;
 final String inputMsg = "숫자를 입력해주세요 : ";
 final String completeMsg =  endStrikeCount+"개의 숫자를 모두 맞히셨습니다! 게임 종료";
 final String questionMsg =  "게임을 새로 시작하려면 "+GameSelectKey.continueGame.key+", 종료하려면 "+GameSelectKey.stopGame.key+"를 입력하세요.";
 final int RandomMinRange = 1;
 final int RandomMaxRange = 9;

 public void startGame(){
    while(true)
     if(playGame().equals(GameSelectKey.stopGame.key))break;


  }

 public String playGame(){
  List<String> number = generateNumber();
  throwBall(number);

  System.out.println(completeMsg);
  System.out.println(questionMsg);
  return Console.readLine();
 }

 public void throwBall(List<String> number){
  JudgeBallCount judgeBallCount = new JudgeBallCount();
  while (true){
   System.out.print(inputMsg);
   String suggest = Console.readLine();
   if(!inputValidation(suggest)) throw new IllegalArgumentException();
   if(judgeBallCount.JudgeBallCount(number,suggest) == endStrikeCount)break;
  }
 }

 public boolean inputValidation(String input) {
  if (!input.matches("-?\\d{"+endStrikeCount+"}+")
          || !checkDuplicateNumber(input)) return false; //숫자만으로 이뤄진 3자리 수 체크
  return true; // 중복 체크
 }

 public List<String> generateNumber(){
  List<String> numbers = new ArrayList<>();
  while (true) {
   String number = String.valueOf(Randoms.pickNumberInRange(RandomMinRange, RandomMaxRange));

   if(numbers.contains(number)) continue;
   numbers.add(number);

   if (inputValidation(String.join("",numbers))) return numbers;
  }
 }

 public boolean checkDuplicateNumber(String input){
  Set set = new HashSet();
  String[] numbers = input.split("");
  for(String number : numbers){ // 같은 숫자 존재 유무 체크
   if(set.contains(number)) return false;
   set.add(number);
  }
  return true;
 }

 enum GameSelectKey{
  continueGame("1"),
  stopGame("2");
  String key;
  GameSelectKey(String s) {
   this.key = s;
  }
 }
}