alter table if exists artist_search
drop
constraint if exists fk_artist_artist_search;

alter table if exists show_search
drop
constraint if exists fk_show_show_search;

alter table if exists show_ticketing_time
drop
constraint if exists fk_show_show_ticketing_time;

drop table if exists admin cascade;
drop table if exists artist cascade;
drop table if exists artist_genre cascade;
drop table if exists artist_search cascade;
drop table if exists artist_subscription cascade;
drop table if exists genre cascade;
drop table if exists genre_subscription cascade;
drop table if exists interest_show cascade;
drop table if exists show cascade;
drop table if exists show_artist cascade;
drop table if exists show_genre cascade;
drop table if exists show_search cascade;
drop table if exists show_ticketing_time cascade;
drop table if exists social_login cascade;
drop table if exists ticketing_alert cascade;
drop table if exists users cascade;

create table admin
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    email      varchar(255) not null unique,
    password   varchar(255) not null,
    primary key (id)
);

create table artist
(
    id           uuid         not null,
    created_at   timestamp(6) not null,
    updated_at   timestamp(6) not null,
    is_deleted   boolean      not null,
    korean_name  varchar(255) not null,
    english_name varchar(255) not null,
    gender       varchar(255) not null check (gender in ('MAN', 'WOMAN', 'MIXED')),
    type         varchar(255) not null check (type in ('SOLO', 'GROUP')),
    country      varchar(255) not null,
    image        varchar(255) not null,
    primary key (id)
);

create table artist_genre
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    artist_id  uuid         not null,
    genre_id   uuid         not null,
    primary key (id)
);

create table artist_search
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    name       varchar(255) not null,
    artist_id  uuid         not null,
    primary key (id)
);

create table artist_subscription
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    user_id    uuid         not null,
    artist_id  uuid         not null,
    primary key (id)
);

create table genre
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    name       varchar(255) not null unique,
    primary key (id)
);

create table genre_subscription
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    genre_id   uuid         not null,
    user_id    uuid         not null,
    primary key (id)
);

create table interest_show
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    show_id    uuid         not null,
    user_id    uuid         not null,
    primary key (id)
);

create table show
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    start_date date         not null,
    end_date   date         not null,
    title      varchar(255) not null,
    content    varchar(255) not null,
    location   varchar(255) not null,
    image      varchar(255) not null,
    seat_price jsonb        not null,
    ticketing  jsonb        not null,
    primary key (id)
);

create table show_artist
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    artist_id  uuid         not null,
    show_id    uuid         not null,
    primary key (id)
);

create table show_genre
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    genre_id   uuid         not null,
    show_id    uuid         not null,
    primary key (id)
);

create table show_search
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    show_id    uuid         not null,
    name       varchar(255) not null,
    primary key (id)
);

create table show_ticketing_time
(
    id           uuid         not null,
    created_at   timestamp(6) not null,
    is_deleted   boolean      not null,
    updated_at   timestamp(6) not null,
    ticketing_at timestamp(6) not null,
    show_id      uuid         not null,
    type         varchar(255) not null check (type in ('PRE', 'NORMAL', 'ADDITIONAL')),
    primary key (id)
);

create table social_login
(
    id                uuid         not null,
    created_at        timestamp(6) not null,
    updated_at        timestamp(6) not null,
    is_deleted        boolean      not null,
    user_id           uuid         not null,
    identifier        varchar(255) not null,
    social_login_type varchar(255) not null check (social_login_type in ('GOOGLE', 'KAKAO', 'APPLE')),
    primary key (id),
    constraint unq_social_login_type_identifier unique (social_login_type, identifier)
);

create table ticketing_alert
(
    id                  uuid         not null,
    created_at          timestamp(6) not null,
    updated_at          timestamp(6) not null,
    is_deleted          boolean      not null,
    name                varchar(255) not null,
    schedule_alert_time timestamp(6) not null,
    show_id             uuid         not null,
    user_id             uuid         not null,
    primary key (id)
);

create table users
(
    id         uuid         not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    is_deleted boolean      not null,
    birth      date         not null,
    fcm_token  varchar(255) not null,
    gender     varchar(255) not null check (gender in ('MAN', 'WOMAN', 'NOT_CHOSEN')),
    nickname   varchar(255) not null,
    role       varchar(255) not null check (role in ('GUEST', 'USER', 'ADMIN')),
    primary key (id)
);

alter table if exists artist_search
    add constraint fk_artist_artist_search
    foreign key (artist_id)
    references artist;

alter table if exists show_search
    add constraint fk_show_show_search
    foreign key (show_id)
    references show;

alter table if exists show_ticketing_time
    add constraint fk_show_show_ticketing_time
    foreign key (show_id)
    references show;