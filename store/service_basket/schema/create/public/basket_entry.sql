create table basket_entry (
  id uuid not null,
  customer_id uuid,
  product_id uuid,
  quantity int4,
  primary key (id)
);
