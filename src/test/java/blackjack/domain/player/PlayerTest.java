package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.Hand;
import fixture.CardFixture;
import fixture.HandFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("참가자 테스트")
class PlayerTest {

    @DisplayName("플레이어 핸드에 카드를 추가할 수 있다")
    @Test
    void testAppendCardToPlayer() {
        PlayerName playerName = new PlayerName("pobi");
        Hand hand = HandFixture.of(10, 9);
        Player player = new Player(playerName, hand);

        Card card = CardFixture.from(2);
        player.appendCard(card);

        assertThat(hand.sum()).isEqualTo(21);
    }
}
