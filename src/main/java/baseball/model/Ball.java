package baseball.model;

import baseball.enumeration.BallType;

public class Ball {
 int count = 0;
 BallType ballType;

 public Ball(BallType ballType) {
  this.ballType = ballType;
 }

 public void plusCount(){
  count++;
 }

 public int getCount() {
  return count;
 }

 public String printMsg(){
  StringBuilder stringBuilder = new StringBuilder();
  if(count != 0)stringBuilder.append(count);
  stringBuilder.append(ballType.getText());
  return stringBuilder.toString();
 }

}
