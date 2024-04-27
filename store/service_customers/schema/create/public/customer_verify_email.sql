create table customer_verify_email (
  id uuid not null,
  customer_id uuid,
  email text,
  secret text,
  is_confirmed boolean,
  primary key (id)
);
