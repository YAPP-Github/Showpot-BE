package org.example.util;

import java.util.UUID;
import org.example.security.dto.AuthenticatedInfo;

public final class ValidatorUser {

    public static UUID getUserId(AuthenticatedInfo info) {
        if (info == null) {
            return null;
        }

        return info.userId();
    }

}
