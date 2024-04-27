create table event (
  id uuid not null,
  topic text,
  content_type text,
  ce_type text,
  ce_source text,
  ce_specification text,
  ce_id text,
  payload jsonb,
  primary key (id)
);
