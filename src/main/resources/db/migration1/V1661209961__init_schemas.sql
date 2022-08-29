CREATE TABLE IF NOT EXISTS trip
(
    id        BIGINT NOT NULL,
    device_id VARCHAR(255),
    timestamp TIMESTAMP WITHOUT TIME ZONE,
    plate     VARCHAR(255),
    user_id   BIGINT NOT NULL,
    CONSTRAINT pk_trip PRIMARY KEY (id)
);

ALTER TABLE trip
    ADD CONSTRAINT FK_TRIP_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);


CREATE TABLE IF NOT EXISTS routecoord
(
    id        BIGINT NOT NULL,
    city      VARCHAR(255),
    speed     DOUBLE PRECISION,
    location  TEXT,
    timestamp TIMESTAMP with time zone,
    trip_id   BIGINT NOT NULL,
    CONSTRAINT pk_routecoord PRIMARY KEY (id)
);

ALTER TABLE routecoord
    ADD CONSTRAINT FK_ROUTECOORD_ON_TRIP FOREIGN KEY (trip_id) REFERENCES trip (id);


CREATE TABLE IF NOT EXISTS passenger
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255),
    matricula VARCHAR(255),
    company   VARCHAR(255),
    trip_id   BIGINT NOT NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_TRIP FOREIGN KEY (trip_id) REFERENCES trip (id);


CREATE TABLE IF NOT EXISTS emergency_record
(
    id          BIGINT NOT NULL,
    name        VARCHAR(255),
    description TEXT,
    customer_id BIGINT NOT NULL,
    CONSTRAINT pk_emergency_record PRIMARY KEY (id)
);

ALTER TABLE emergency_record
    ADD CONSTRAINT FK_EMERGENCY_RECORD_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);


CREATE TABLE IF NOT EXISTS emergency
(
    id                    BIGINT NOT NULL,
    emergency_description VARCHAR(255),
    vehicle_plate         VARCHAR(255),
    location              TEXT,
    timestamp             TIMESTAMP with time zone,
    emergency_record_id   BIGINT NOT NULL,
    user_id               BIGINT NOT NULL,
    CONSTRAINT pk_emergency PRIMARY KEY (id)
);

ALTER TABLE emergency
    ADD CONSTRAINT FK_EMERGENCY_ON_EMERGENCY_RECORD FOREIGN KEY (emergency_record_id) REFERENCES emergency_record (id);

ALTER TABLE emergency
    ADD CONSTRAINT FK_EMERGENCY_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE SEQUENCE emergency_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY emergency.id;

ALTER TABLE emergency
    ALTER COLUMN id SET DEFAULT nextval('emergency_seq'::regclass);


CREATE SEQUENCE emergency_record_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY emergency_record.id;

ALTER TABLE emergency_record
    ALTER COLUMN id SET DEFAULT nextval('emergency_record_seq'::regclass);


CREATE SEQUENCE routecoord_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY routecoord.id;

ALTER TABLE routecoord
    ALTER COLUMN id SET DEFAULT nextval('routecoord_seq'::regclass);


CREATE SEQUENCE trip_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY trip.id;

ALTER TABLE trip
    ALTER COLUMN id SET DEFAULT nextval('trip_seq'::regclass);



CREATE SEQUENCE passenger_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY passenger.id;

ALTER TABLE passenger
    ALTER COLUMN id SET DEFAULT nextval('passenger_seq'::regclass);


