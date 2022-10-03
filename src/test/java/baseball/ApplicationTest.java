package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 입력값유효검사(){
        //given
        String input = "123";
        String abnormalCase = "12345";
        String abnormalCase2 = "12s";
        String abnormalCase3 = "111";

        //when
        //then
        assertThat(Application.inputValidation(input)).isTrue();
        assertThat(Application.inputValidation(abnormalCase)).isFalse();
        assertThat(Application.inputValidation(abnormalCase2)).isFalse();
        assertThat(Application.inputValidation(abnormalCase3)).isFalse();
    }

    @Test
    void 볼판별테스트(){
        String computerInput = "123";
        String strike3 = "123";
        String ball3 = "312";
        String ball2strike1 = "321";
        String nothing = "456";

        //when
        //then
        assertThat(Application.distinguishBallCount(computerInput,strike3)).isTrue();
        assertThat(Application.distinguishBallCount(computerInput,ball3)).isFalse();
        assertThat(Application.distinguishBallCount(computerInput,ball2strike1)).isFalse();
        assertThat(Application.distinguishBallCount(computerInput,nothing)).isFalse();

    }
}
