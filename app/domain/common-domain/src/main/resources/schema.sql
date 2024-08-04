alter table if exists artist_search
drop constraint if exists fk_artist_artist_search;
alter table if exists show_search
drop constraint if exists fk_show_show_search;

drop table if exists admin cascade;
drop table if exists artist cascade;
drop table if exists artist_genre cascade;
drop table if exists artist_search cascade;
drop table if exists genre cascade;
drop table if exists interest_show cascade;
drop table if exists show cascade;
drop table if exists show_artist cascade;
drop table if exists show_genre cascade;
drop table if exists show_search cascade;
drop table if exists social_login cascade;
drop table if exists subscribe_artist cascade;
drop table if exists subscribe_genre cascade;
drop table if exists ticketing_alert cascade;
drop table if exists users cascade;

create table admin
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    id         uuid         not null,
    email      varchar(255) not null unique,
    password   varchar(255) not null,
    primary key (id)
);
create table artist
(
    is_deleted   boolean      not null,
    create_at    timestamp(6) not null,
    updated_at   timestamp(6) not null,
    id           uuid         not null,
    country      varchar(255) not null,
    english_name varchar(255) not null,
    gender       varchar(255) not null check (gender in ('MAN', 'WOMAN', 'MIXED')),
    image        varchar(255) not null,
    korean_name  varchar(255) not null,
    type         varchar(255) not null check (type in ('SOLO', 'GROUP')),
    primary key (id)
);
create table artist_genre
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    artist_id  uuid         not null,
    genre_id   uuid         not null,
    id         uuid         not null,
    primary key (id)
);
create table artist_search
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    artist_id  uuid         not null,
    id         uuid         not null,
    name       varchar(255) not null,
    primary key (id)
);
create table genre
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    id         uuid         not null,
    name       varchar(255) not null unique,
    primary key (id)
);
create table interest_show
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    id         uuid         not null,
    show_id    uuid         not null,
    user_id    uuid         not null,
    primary key (id)
);
create table show
(
    date             date         not null,
    is_deleted       boolean      not null,
    create_at        timestamp(6) not null,
    ticket_open_time timestamp(6) not null,
    updated_at       timestamp(6) not null,
    id               uuid         not null,
    content          varchar(255) not null,
    image            varchar(255) not null,
    location         varchar(255) not null,
    title            varchar(255) not null,
    seat_price       jsonb        not null,
    ticketing        jsonb        not null,
    primary key (id)
);
create table show_artist
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    artist_id  uuid         not null,
    id         uuid         not null,
    show_id    uuid         not null,
    primary key (id)
);
create table show_genre
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    genre_id   uuid         not null,
    id         uuid         not null,
    show_id    uuid         not null,
    primary key (id)
);
create table show_search
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    id         uuid         not null,
    show_id    uuid         not null,
    name       varchar(255) not null,
    primary key (id)
);
create table social_login
(
    is_deleted        boolean      not null,
    create_at         timestamp(6) not null,
    updated_at        timestamp(6) not null,
    id                uuid         not null,
    user_id           uuid         not null,
    identifier        varchar(255) not null,
    social_login_type varchar(255) not null check (social_login_type in ('GOOGLE', 'KAKAO', 'APPLE')),
    primary key (id),
    constraint unq_social_login_type_identifier unique (social_login_type, identifier)
);
create table subscribe_artist
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    artist_id  uuid         not null,
    id         uuid         not null,
    user_id    uuid         not null,
    primary key (id)
);
create table subscribe_genre
(
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    genre_id   uuid         not null,
    id         uuid         not null,
    user_id    uuid         not null,
    primary key (id)
);
create table ticketing_alert
(
    is_deleted          boolean      not null,
    create_at           timestamp(6) not null,
    schedule_alert_time timestamp(6) not null,
    updated_at          timestamp(6) not null,
    id                  uuid         not null,
    show_id             uuid         not null,
    user_id             uuid         not null,
    name                varchar(255) not null,
    primary key (id)
);
create table users
(
    birth      date         not null,
    is_deleted boolean      not null,
    create_at  timestamp(6) not null,
    updated_at timestamp(6) not null,
    id         uuid         not null,
    fcm_token  varchar(255) not null,
    gender     varchar(255) not null check (gender in ('MAN', 'WOMAN', 'NOT_CHOSEN')),
    nickname   varchar(255) not null,
    role       varchar(255) not null check (role in ('GUEST', 'USER', 'ADMIN')),
    primary key (id)
);
alter table if exists artist_search
    add constraint fk_artist_artist_search foreign key (artist_id) references artist;
alter table if exists show_search
    add constraint fk_show_show_search foreign key (show_id) references show;