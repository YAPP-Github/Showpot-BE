package com.example.component;

import java.util.UUID;

public interface ViewCountComponent {

    boolean validateViewCount(UUID showId, String deviceToken);
}
