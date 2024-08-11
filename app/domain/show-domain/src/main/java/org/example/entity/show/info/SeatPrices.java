package org.example.entity.show.info;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Embeddable
@NoArgsConstructor
public class SeatPrices {

    @Type(JsonType.class)
    @Column(name = "seat_prices", columnDefinition = "jsonb", nullable = false)
    private Map<String, Integer> priceBySeat = new HashMap<>();

    public void savePriceInformation(String seatType, Integer price) {
        priceBySeat.put(seatType, price);
    }

    public Map<String, Integer> getPriceBySeat() {
        return new HashMap<>(priceBySeat);
    }

    public SeatPrices(Map<String, Integer> priceBySeat) {
        this.priceBySeat = priceBySeat;
    }
}
