CREATE SEQUENCE users_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY users.id;

ALTER TABLE public.users
    ALTER COLUMN id SET DEFAULT nextval('users_seq'::regclass);


CREATE SEQUENCE customer_seq
    AS bigint
    INCREMENT 1
    MINVALUE 1
    NO MAXVALUE
    NO CYCLE
    START WITH 1
    OWNED BY customer.id;

ALTER TABLE public.customer
    ALTER COLUMN id SET DEFAULT nextval('customer_seq'::regclass);