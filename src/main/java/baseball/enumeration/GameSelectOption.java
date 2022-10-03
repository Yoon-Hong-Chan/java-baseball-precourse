package baseball.enumeration;

public enum GameSelectOption {
 continueGame("1"),
 stopGame("2");

 String key;

 GameSelectOption(String s) {
  this.key = s;
 }

 public String getKey() {
  return key;
 }
}
