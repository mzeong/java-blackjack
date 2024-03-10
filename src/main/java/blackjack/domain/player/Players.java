package blackjack.domain.player;

import blackjack.domain.card.Hand;
import java.util.ArrayList;
import java.util.List;

public class Players {

    private static final int MAX_COUNT = 3;

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players from(List<PlayerName> playerNames) {
        return new Players(playerNames.stream()
                .map(playerName -> new Player(playerName, new Hand(new ArrayList<>())))
                .toList());
    }

    public int countPlayer() {
        return players.size();
    }

    private void validate(List<Player> players) {
        validateEachPlayerNameUnique(players);
        validateEntryNotEmpty(players);
        validatePlayerCountRange(players);
    }

    private void validateEachPlayerNameUnique(List<Player> players) {
        if (countUniquePlayer(players) != players.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 플레이어의 이름이 존재합니다");
        }
    }

    private int countUniquePlayer(List<Player> players) {
        return (int) players.stream()
                .distinct()
                .count();
    }

    private void validateEntryNotEmpty(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 플레이어가 없습니다");
        }
    }

    private void validatePlayerCountRange(List<Player> players) {
        if (players.size() > MAX_COUNT) {
            throw new IllegalArgumentException("[ERROR] 플레이어의 수는 " + MAX_COUNT + "이하여야 합니다");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
