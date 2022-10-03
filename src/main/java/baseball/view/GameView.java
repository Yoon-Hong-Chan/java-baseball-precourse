package baseball.view;

import baseball.enumeration.BallType;
import baseball.domain.Ball;
import baseball.domain.BallGroup;
import baseball.enumeration.GameSelectOption;

public class GameView {
    public void printInputGuide() {
      System.out.print("숫자를 입력해주세요 : ");
    }

    public void printCompleteGame(int endStrikeCount) {
     System.out.println(endStrikeCount+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printSelectOption(){
     System.out.println("게임을 새로 시작하려면 "+ GameSelectOption.continueGame.getKey()+", 종료하려면 "+ GameSelectOption.stopGame.getKey()+"를 입력하세요.");

    }

    public void printResult(BallGroup ballGroup){
     Ball strike = ballGroup.getStrike();
     Ball ball = ballGroup.getBall();
     StringBuilder stringBuilder = new StringBuilder();
     if(ball.getCount() != 0) stringBuilder.append(ball.printMsg());
     if(strike.getCount() != 0) stringBuilder.append(strike.printMsg());
     if(ball.getCount() == 0 && strike.getCount() ==0 ) stringBuilder.append(BallType.nothing.getText());
     System.out.println(stringBuilder);
    }
}
