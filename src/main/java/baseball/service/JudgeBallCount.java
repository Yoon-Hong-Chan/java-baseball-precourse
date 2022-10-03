package baseball.service;

import baseball.model.Ball;
import baseball.enumeration.BallType;
import java.util.Arrays;
import java.util.List;

public class JudgeBallCount {

 public Integer JudgeBallCount(List<String> numbers, String input){
  List<String> inputs = Arrays.asList(input.split(""));
  Ball strike = new Ball(BallType.strike);
  Ball ball = new Ball(BallType.ball);
  distinguishBallCount(numbers,inputs, strike, ball);
  printResult(strike, ball);
  return strike.getCount();
 }

 public void distinguishBallCount(List<String> numbers, List<String> inputs, Ball strike, Ball ball){
  for(int i = 0; i < numbers.size(); i++){
   if(numbers.get(i).equals(inputs.get(i))) {
    strike.plusCount();
    continue;
   }
   if(numbers.contains(inputs.get(i))) ball.plusCount();
  }
 }
 public void printResult(Ball strike, Ball ball){
  StringBuilder stringBuilder = new StringBuilder();
  if(ball.getCount() != 0) stringBuilder.append(ball.printMsg());
  if(strike.getCount() != 0) stringBuilder.append(strike.printMsg());
  if(ball.getCount() == 0 && strike.getCount() ==0 ) stringBuilder.append(BallType.nothing.getText());
  System.out.println(stringBuilder);
 }

}
