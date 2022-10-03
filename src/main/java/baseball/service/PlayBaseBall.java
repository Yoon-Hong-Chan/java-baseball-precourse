package baseball.service;

import baseball.domain.BallGroup;
import baseball.enumeration.GameSelectOption;
import baseball.model.JudgeBall;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayBaseBall {
 final int endStrikeCount = 3;
 final GameView gameView = new GameView();
 final int RandomMinRange = 1;
 final int RandomMaxRange = 9;

 public void startGame(){
    while(true)
     if(playGame().equals(GameSelectOption.stopGame.getKey()))break;
  }

 public String playGame(){
  List<String> number = generateNumber();
  throwBall(number);

  gameView.printCompleteGame(endStrikeCount);
  gameView.printSelectOption();
  return Console.readLine();
 }

 public void throwBall(List<String> number){
  JudgeBall judgeBallCount = new JudgeBall();
  while (true){
   gameView.printInputGuide();
   String suggest = Console.readLine();
   if(!inputValidation(suggest)) throw new IllegalArgumentException();
   BallGroup ballGroup = judgeBallCount.JudgeBallCount(number,suggest);
   gameView.printResult(ballGroup);
   if(ballGroup.getStrike().getCount() == endStrikeCount)break;
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
}