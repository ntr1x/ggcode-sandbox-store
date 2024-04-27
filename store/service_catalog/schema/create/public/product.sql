create table product (
  id uuid not null,
  name text,
  description text,
  price numeric(38,2),
  category_id uuid,
  primary key (id)
);
