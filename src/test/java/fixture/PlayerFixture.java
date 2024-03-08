package fixture;

import blackjack.domain.player.Player;
import blackjack.domain.player.PlayerName;

public class PlayerFixture {

    public static Player of(String name, int... hand) {
        return new Player(new PlayerName(name), HandFixture.of(hand));
    }
}
