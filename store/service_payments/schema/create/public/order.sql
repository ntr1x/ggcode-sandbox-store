create table order (
  id uuid not null,
  customer_id uuid,
  order_type_id int4,
  order_status_id int4,
  created_at timestamp(6),
  updated_at timestamp(6),
  primary key (id)
);
