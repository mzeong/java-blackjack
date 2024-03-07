package blackjack.domain;

import fixture.HandFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    @DisplayName("핸드가 건네지면 가장 최선의 합계를 구할 수 있다")
    @Test
    void testCalculateBestScore() {
        Judge judge = new Judge();

        Hand hand = HandFixture.of(1, 1);
        assertThat(judge.calculateBestScore(hand)).isEqualTo(12);
    }

    @DisplayName("버스트 된 핸드를 판별할 수 있다")
    @Test
    void testDecideBusted() {
        Judge judge = new Judge();
        Hand hand = HandFixture.of(10, 9, 3);
        assertThat(judge.isBustedHand(hand)).isTrue();
    }

    @DisplayName("버스트 되지 않은 핸드를 판별할 수 있다")
    @Test
    void testDecideNotBusted() {
        Judge judge = new Judge();
        Hand hand = HandFixture.of(10, 9, 2);
        assertThat(judge.isBustedHand(hand)).isFalse();
    }
}