package fixture;

import blackjack.domain.card.Hand;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HandFixture {

    public static Hand of(int... numbers) {
        return new Hand(Arrays.stream(numbers)
                .mapToObj(CardFixture::from)
                .collect(Collectors.toList()));
    }
}
