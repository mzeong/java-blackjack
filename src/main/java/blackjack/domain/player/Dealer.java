package blackjack.domain.player;

import blackjack.domain.Result;
import blackjack.domain.card.Hand;

public class Dealer extends Participant {

    private static final int HIT_THRESHOLD = 17;

    public Dealer(Hand hand) {
        super(hand);
    }

    @Override
    public boolean canHit() {
        return calculateHandTotal() < HIT_THRESHOLD;
    }

    public Result judge(Players players) {
        Result result = new Result();
        players.getPlayers().forEach(player -> result.updateOpponent(player.judge(this)));
        return result;
    }
}