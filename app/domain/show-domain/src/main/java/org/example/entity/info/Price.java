package org.example.entity.info;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.annotations.Type;

@Embeddable
public class Price {

    @Type(JsonType.class)
    @Column(name = "price", columnDefinition = "jsonb", nullable = false)
    private Map<String, Integer> priceInformation = new HashMap<>();

    public void savePriceInformation(String seatType, Integer won) {
        priceInformation.put(seatType, won);
    }
}
