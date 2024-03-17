package blackjack.domain.card;

import blackjack.domain.participant.Score;
import java.util.Arrays;
import java.util.List;

public enum CardRank {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ;

    private static final int ACE_WEIGHT = 10;

    private final int score;

    CardRank(int score) {
        this.score = score;
    }

    public static List<CardRank> allCardRanks() {
        return Arrays.asList(values());
    }

    public static Score adjustAceScore(Score score) {
        Score newScore = score.add(ACE_WEIGHT);
        if (newScore.isBust()) {
            return score;
        }
        return newScore;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getScore() {
        return score;
    }
}
