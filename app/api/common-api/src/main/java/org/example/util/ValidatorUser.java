package org.example.util;

import java.util.UUID;
import org.example.security.dto.AuthenticatedUser;

public final class ValidatorUser {

    public static UUID getUserId(AuthenticatedUser user) {
        if (user == null) {
            return null;
        }

        return user.userId();
    }

}
