create table order_entry (
  id uuid not null,
  product_id uuid,
  order_id uuid,
  quantity int4,
  primary key (id)
);
