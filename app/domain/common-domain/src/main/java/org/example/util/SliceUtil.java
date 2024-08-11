package org.example.util;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

public final class SliceUtil {

    private SliceUtil() {

    }

    public static <T> Slice<T> makeSlice(final int size, final List<T> dtos) {
        final boolean hasNext = dtos.size() > size;

        if (hasNext) {
            return new SliceImpl<>(dtos.subList(0, size), Pageable.ofSize(size), true);
        }

        return new SliceImpl<>(dtos, Pageable.ofSize(size), false);
    }
}
