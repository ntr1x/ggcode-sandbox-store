create table payment (
  id uuid not null,
  customer_id uuid,
  order_id uuid,
  payment_status_id uuid,
  payment_type_id uuid,
  value numeric(38,2),
  created_at timestamp(6),
  updated_at timestamp(6),
  primary key (id)
);
