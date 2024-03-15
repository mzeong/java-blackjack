package blackjack.domain.card;

import java.util.Arrays;
import java.util.List;

public enum CardSuit {

    HEART,
    DIAMOND,
    CLUB,
    SPADE,
    ;

    public static List<CardSuit> allCardSuits() {
        return Arrays.asList(values());
    }
}
