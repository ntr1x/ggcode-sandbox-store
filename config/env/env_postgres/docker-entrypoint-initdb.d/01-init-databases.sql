-- Bootstrap databases

-- Bootstrap "keycloak" database

CREATE USER "keycloak" WITH password 'keycloak' CREATEDB;

GRANT "keycloak" TO CURRENT_USER;

CREATE DATABASE "keycloak" encoding='UTF-8' OWNER = "keycloak";

\c keycloak
CREATE EXTENSION IF NOT EXISTS pg_trgm;
GRANT CREATE ON DATABASE "keycloak" TO "keycloak";
GRANT USAGE ON SCHEMA public TO "keycloak";
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO "keycloak";
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO "keycloak";

-- Bootstrap "app" database

CREATE USER "app" WITH password 'app' CREATEDB;

GRANT "app" TO CURRENT_USER;

CREATE DATABASE "app" encoding='UTF-8' OWNER = "app";

\c app
CREATE EXTENSION IF NOT EXISTS pg_trgm;
GRANT CREATE ON DATABASE "app" TO "app";
GRANT USAGE ON SCHEMA public TO "app";
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO "app";
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO "app";
