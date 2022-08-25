CREATE TABLE IF NOT EXISTS trip
(
    id        BIGINT NOT NULL,
    device_id VARCHAR(255),
    timestamp TIMESTAMP WITHOUT TIME ZONE,
    plate     VARCHAR(255),
    user_id   BIGINT NOT NULL,
    CONSTRAINT pk_trip PRIMARY KEY (id)
);

ALTER TABLE trip ADD CONSTRAINT FK_TRIP_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);


CREATE TABLE IF NOT EXISTS routecoord
(
    id        BIGINT NOT NULL,
    city      VARCHAR(255),
    device_id VARCHAR(255),
    trip_id   BIGINT NOT NULL,
    location  TEXT,
    timestamp TIMESTAMP with time zone,
    CONSTRAINT pk_routecoord PRIMARY KEY (id)
);

ALTER TABLE routecoord
    ADD CONSTRAINT FK_ROUTECOORD_ON_TRIP FOREIGN KEY (trip_id) REFERENCES trip (id);


CREATE SEQUENCE routecoord_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY routecoord.id;

ALTER TABLE routecoord ALTER COLUMN id SET DEFAULT nextval('routecoord_seq'::regclass);


CREATE SEQUENCE trip_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY trip.id;

ALTER TABLE trip ALTER COLUMN id SET DEFAULT nextval('trip_seq'::regclass);