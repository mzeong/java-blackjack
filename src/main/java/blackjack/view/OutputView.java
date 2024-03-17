package blackjack.view;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import blackjack.domain.profit.PlayersProfit;

public class OutputView {

    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printDealToAll(Dealer dealer, Players players) {
        System.out.println(messageResolver.resolveDealDescriptionMessage(players));
        System.out.println(messageResolver.resolveDealToDealerMessage(dealer));
        System.out.println(messageResolver.resolveDealToPlayersMessage(players));
    }

    public void printDrawToPlayer(Player player) {
        System.out.println(messageResolver.resolveDrawToPlayerMessage(player));
    }

    public void printDrawToDealer() {
        System.out.println(messageResolver.resolveDrawToDealerDescriptionMessage());
    }

    public void printLineSeparator() {
        System.out.println();
    }

    public void printAllHandScore(Dealer dealer, Players players) {
        System.out.println(messageResolver.resolveDealerHandScoreMessage(dealer));
        System.out.println(messageResolver.resolvePlayersHandScoreMessage(players));
    }

    public void printAllProfit(PlayersProfit playersProfit) {
        System.out.println(messageResolver.resolveProfitDescriptionMessage());
        System.out.println(messageResolver.resolveDealerProfitMessage(playersProfit));
        System.out.println(messageResolver.resolvePlayersProfitMessage(playersProfit));
    }
}
