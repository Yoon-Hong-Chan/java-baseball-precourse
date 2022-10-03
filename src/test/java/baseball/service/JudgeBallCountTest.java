package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgeBallCountTest {
 private JudgeBallCount judgeBallCount;

 @BeforeEach
 void setUp() {
  judgeBallCount = new JudgeBallCount();
 }

 @Test
 void 볼판별테스트(){
  List<String> computerInput = Arrays.asList("1", "2", "3") ;
  String strike3 = "123";
  String ball3 = "312";
  String ball2strike1 = "321";
  String nothing = "456";

  //when
  //then
  assertThat(judgeBallCount.JudgeBallCount(computerInput,strike3)).isEqualTo(3);
  assertThat(judgeBallCount.JudgeBallCount(computerInput,ball3)).isEqualTo(0);
  assertThat(judgeBallCount.JudgeBallCount(computerInput,ball2strike1)).isEqualTo(1);
  assertThat(judgeBallCount.JudgeBallCount(computerInput,nothing)).isEqualTo(0);

 }

}