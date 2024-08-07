package com.example.show.controller.vo;

import org.example.vo.ShowSortType;

public enum ShowSortApiType {
    RECENT, POPULAR;

    public ShowSortType toDomainType() {
        return switch (this) {
            case RECENT -> ShowSortType.RECENT;
            case POPULAR -> ShowSortType.POPULAR;
        };
    }
}
