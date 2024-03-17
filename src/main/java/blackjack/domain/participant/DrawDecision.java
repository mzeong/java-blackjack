package blackjack.domain.participant;

public enum DrawDecision {

    HIT,
    STAY,
    ;

    DrawDecision() {
    }

    public boolean isHit() {
        return this == HIT;
    }
}