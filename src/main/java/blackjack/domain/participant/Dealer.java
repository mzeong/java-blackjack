package blackjack.domain.participant;

import blackjack.domain.card.CardDeck;

public class Dealer {

    private static final int REVEAL_COUNT = 1;

    private final Hand hand;

    public Dealer() {
        this(new Hand());
    }

    public Dealer(Hand hand) {
        this.hand = hand;
    }

    public void deal(CardDeck cardDeck) {
        hand.appendInitial(cardDeck);
    }

    public Hand revealHand() {
        return hand.revealHand(REVEAL_COUNT);
    }

    public void draw(CardDeck cardDeck) {
        if (canHit()) {
            hand.append(cardDeck.popCard());
        }
    }

    public boolean canHit() {
        return hand.calculateHandScore().isDealerHit();
    }

    public Score handScore() {
        return hand.calculateHandScore();
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isNotBlackjack() {
        return !hand.isBlackjack();
    }

    public boolean isBust() {
        return hand.isBust();
    }
}
