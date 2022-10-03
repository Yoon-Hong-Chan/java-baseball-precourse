package baseball.enumeration;

public enum BallType {
 strike("스트라이크 "),
 ball("볼 "),
 nothing("낫싱 ");

 String text;
 BallType(String s) {
  text = s;
 }

 public String getText() {
  return text;
 }

}
