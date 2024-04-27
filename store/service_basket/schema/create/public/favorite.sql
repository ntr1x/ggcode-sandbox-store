create table favorite (
  id uuid not null,
  customer_id uuid,
  product_id uuid,
  primary key (id)
);
