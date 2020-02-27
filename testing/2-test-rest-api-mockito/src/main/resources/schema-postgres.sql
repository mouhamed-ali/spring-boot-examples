
-- schema creation

-- Table: public.github_user

DROP TABLE IF EXISTS github_user CASCADE;

CREATE TABLE github_user
(
    id bigint NOT NULL,
    creation_date timestamp,
    email character varying(255),
    location character varying(255),
    login character varying(255),
    name character varying(255),
    type character varying(255),
    url character varying(255),
    CONSTRAINT github_user_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS github_repository CASCADE;

CREATE TABLE github_repository
(
    id bigint NOT NULL,
    default_branch character varying(255),
    description character varying(255),
    fork boolean,
    full_name character varying(255),
    language character varying(255),
    name character varying(255),
    url character varying(255),
    user_id bigint,
    CONSTRAINT github_repository_pkey PRIMARY KEY (id),
    CONSTRAINT github_repository_fkey FOREIGN KEY (user_id) REFERENCES github_user (id)
);