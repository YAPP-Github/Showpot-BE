package org.example.entity.usershow;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "interest_show")
public class InterestShow extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "show_id", nullable = false)
    private UUID showId;

    @Builder
    private InterestShow(UUID userId, UUID showId) {
        this.userId = userId;
        this.showId = showId;
    }

    public void interest() {
        this.revive();
    }

    public void uninterested() {
        this.softDelete();
    }

    public boolean hasInterest() {
        return !this.getIsDeleted();
    }
}
