package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardRank;
import blackjack.domain.card.CardSuit;
import blackjack.domain.card.Hand;
import fixture.HandFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Card card;

    @BeforeEach
    void setUp() {
        card = new Card(CardRank.ACE, CardSuit.DIAMOND);
    }

    @DisplayName("플레이어는 21을 넘지 않을 경우 핸드에 카드를 추가한다.")
    @Test
    void testHit() {
        // given
        Hand hand = HandFixture.createHandWithScoreTotal21();

        Player player = new Player(hand, new PlayerName("pobi"));

        // when
        player.hit(card);

        // then
        assertThat(hand.getCards()).contains(card);
    }

    @DisplayName("플레이어는 21을 넘을 경우 핸드에 카드를 추가하지 않는다.")
    @Test
    void testNotHit() {
        // given
        Hand hand = HandFixture.createHandWithScoreTotal21();
        hand.append(new Card(CardRank.ACE, CardSuit.HEART));

        Player player = new Player(hand, new PlayerName("pobi"));

        // when
        player.hit(card);

        // then
        assertThat(hand.getCards()).doesNotContain(card);
    }
}
