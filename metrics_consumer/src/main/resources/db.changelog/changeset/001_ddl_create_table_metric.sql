create table metric
(
    id                serial    primary key,
    topic_name        varchar   not null,
    measuring         timestamp not null,
    cpu_usage         float not null,
    status            varchar   not null,
    disc_total        int8,
    disc_free         int8,
    ping_status       varchar
);