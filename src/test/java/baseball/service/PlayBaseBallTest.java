package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayBaseBallTest {
 private PlayBaseBall playBaseBall;

 @BeforeEach
 void setUp() {
  playBaseBall = new PlayBaseBall();
 }

 @Test
 void 입력값유효검사() {
  //given
  String input = "123";
  String abnormalCase = "12345";
  String abnormalCase2 = "12s";
  String abnormalCase3 = "111";

  //when
  //then
  assertThat(playBaseBall.inputValidation(input)).isTrue();
  assertThat(playBaseBall.inputValidation(abnormalCase)).isFalse();
  assertThat(playBaseBall.inputValidation(abnormalCase2)).isFalse();
  assertThat(playBaseBall.inputValidation(abnormalCase3)).isFalse();

 }
}