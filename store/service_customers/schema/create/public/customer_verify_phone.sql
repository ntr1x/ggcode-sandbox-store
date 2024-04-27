create table customer_verify_phone (
  id uuid not null,
  customer_id uuid,
  phone text,
  secret int4,
  is_confirmed boolean,
  primary key (id)
);
