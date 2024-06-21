package org.example.entity.show.info;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.annotations.Type;

@Embeddable
public class SeatPrice {

    @Type(JsonType.class)
    @Column(name = "seat_price", columnDefinition = "jsonb", nullable = false)
    private Map<String, Integer> priceInformation = new HashMap<>();

    public void savePriceInformation(String seatType, Integer price) {
        priceInformation.put(seatType, price);
    }
}
