package baseball.model;

import baseball.domain.Ball;
import baseball.enumeration.BallType;
import baseball.domain.BallGroup;
import java.util.Arrays;
import java.util.List;

public class JudgeBall {

 public BallGroup JudgeBallCount(List<String> numbers, String input){
  List<String> inputs = Arrays.asList(input.split(""));
  BallGroup ballGroup = new BallGroup(new Ball(BallType.strike),new Ball(BallType.ball));
  distinguishBallCount(numbers,inputs, ballGroup);
  return ballGroup;
 }

 public void distinguishBallCount(List<String> numbers, List<String> inputs, BallGroup ballGroup){
  Ball strike = ballGroup.getStrike();
  Ball ball = ballGroup.getBall();
  for(int i = 0; i < numbers.size(); i++){
   if(numbers.get(i).equals(inputs.get(i))) {
    strike.plusCount();
    continue;
   }
   if(numbers.contains(inputs.get(i))) ball.plusCount();
  }
 }
}
