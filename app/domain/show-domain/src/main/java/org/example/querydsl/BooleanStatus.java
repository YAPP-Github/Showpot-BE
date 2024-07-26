package org.example.querydsl;

import static org.example.entity.artist.QArtist.artist;
import static org.example.entity.artist.QArtistSearch.artistSearch;
import static org.example.entity.genre.QGenre.genre;
import static org.example.entity.show.QShowArtist.showArtist;
import static org.example.entity.show.QShowGenre.showGenre;
import static org.example.entity.show.QShowSearch.showSearch;

import com.querydsl.core.types.dsl.BooleanExpression;

public class BooleanStatus {

    public static BooleanExpression getArtistIsDeletedFalse() {
        return artist.isDeleted.isFalse();
    }

    public static BooleanExpression getArtistSearchIsDeletedFalse() {
        return artistSearch.isDeleted.isFalse();
    }

    public static BooleanExpression getGenreIsDeletedFalse() {
        return genre.isDeleted.isFalse();
    }

    public static BooleanExpression getShowArtistIsDeletedFalse() {
        return showArtist.isDeleted.isFalse();
    }

    public static BooleanExpression getShowGenreIsDeletedFalse() {
        return showGenre.isDeleted.isFalse();
    }

    public static BooleanExpression getShowSearchIsDeletedFalse() {
        return showSearch.isDeleted.isFalse();
    }
}
