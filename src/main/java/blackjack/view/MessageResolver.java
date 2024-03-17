package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.participant.Hand;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import blackjack.domain.profit.PlayersProfit;
import blackjack.domain.profit.Profit;
import blackjack.view.mapper.CardRankMapper;
import blackjack.view.mapper.CardSuitMapper;
import java.util.stream.Collectors;

public class MessageResolver {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SEPARATOR = ", ";
    private static final String DEALER_NAME = "딜러";
    private static final String CARD_FORMAT = "%s%s";
    private static final String HAND_FORMAT = "%s 카드: %s";
    private static final String HAND_SCORE_FORMAT = "%s - 결과: %d";
    private static final String PROFIT_FORMAT = "%s: %.0f";

    public MessageResolver() {
    }

    public String resolveDealDescriptionMessage(Players players) {
        String message = String.format("%s와 %s에게 2장을 나누었습니다.", DEALER_NAME, resolveNamesMessage(players));
        return String.join("", LINE_SEPARATOR, message);
    }

    private String resolveNamesMessage(Players players) {
        return players.getPlayers().stream()
                .map(player -> player.getName().value())
                .collect(Collectors.joining(SEPARATOR));
    }

    public String resolveDealerHandAfterDealMessage(Dealer dealer) {
        return String.format(HAND_FORMAT, DEALER_NAME, resolveCardMessage(dealer.revealFirstCard()));
    }

    public String resolvePlayersHandMessage(Players players) {
        return players.getPlayers().stream()
                .map(this::resolvePlayerHandMessage)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    public String resolvePlayerHandMessage(Player player) {
        return String.format(HAND_FORMAT, player.getName().value(), resolveHandMessage(player.getHand()));
    }

    private String resolveHandMessage(Hand hand) {
        return hand.getCards().stream()
                .map(this::resolveCardMessage)
                .collect(Collectors.joining(SEPARATOR));
    }

    private String resolveCardMessage(Card card) {
        String rankSymbol = CardRankMapper.toSymbol(card.cardRank());
        String suitSymbol = CardSuitMapper.toSymbol(card.cardSuit());
        return String.format(CARD_FORMAT, rankSymbol, suitSymbol);
    }

    public String resolveDrawToDealerDescriptionMessage() {
        return String.format("%s는 16이하라 한장의 카드를 더 받았습니다.", DEALER_NAME);
    }

    public String resolveDealerHandScoreMessage(Dealer dealer) {
        String message = String.format(HAND_SCORE_FORMAT, resolveDealerHandMessage(dealer), dealer.handScore().getValue());
        return String.join("", LINE_SEPARATOR, message);
    }

    private String resolveDealerHandMessage(Dealer dealer) {
        return String.format(HAND_FORMAT, DEALER_NAME, resolveHandMessage(dealer.getHand()));
    }

    public String resolvePlayersHandScoreMessage(Players players) {
        return players.getPlayers().stream()
                .map(this::resolvePlayerHandScoreMessage)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String resolvePlayerHandScoreMessage(Player player) {
        return String.format(HAND_SCORE_FORMAT, resolvePlayerHandMessage(player), player.handScore().getValue());
    }

    public String resolveProfitDescriptionMessage() {
        return String.join("", LINE_SEPARATOR, "## 최종 수익");
    }

    public String resolveDealerProfitMessage(PlayersProfit playersProfit) {
        return String.format(PROFIT_FORMAT, DEALER_NAME, playersProfit.dealerProfit().getValue());
    }

    public String resolvePlayersProfitMessage(PlayersProfit playersProfit) {
        return playersProfit.getProfits().entrySet().stream()
                .map(entry -> resolvePlayerProfitMessage(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String resolvePlayerProfitMessage(Player player, Profit profit) {
        return String.format(PROFIT_FORMAT, player.getName().value(), profit.getValue());
    }
}
