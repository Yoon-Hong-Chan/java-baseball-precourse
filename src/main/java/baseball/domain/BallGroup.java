package baseball.domain;

import java.util.Objects;

public class BallGroup {
    Ball Strike;
    Ball Ball;

   public BallGroup(baseball.domain.Ball strike, baseball.domain.Ball ball) {
    Strike = strike;
    Ball = ball;
   }

 public baseball.domain.Ball getStrike() {
  return Strike;
 }

 public void setStrike(baseball.domain.Ball strike) {
  Strike = strike;
 }

 public baseball.domain.Ball getBall() {
  return Ball;
 }

 public void setBall(baseball.domain.Ball ball) {
  Ball = ball;
 }

}
