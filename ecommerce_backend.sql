
create database ecommerce_backend;
use ecommerce_backend;
CREATE TABLE public.category (
	id uuid NOT NULL,
	description varchar(255) NULL,
	CONSTRAINT category_description_key UNIQUE (description),
	CONSTRAINT category_pkey PRIMARY KEY (id)
);


-- public.company definition

-- Drop table

-- DROP TABLE public.company;

CREATE TABLE public.company (
	nit int8 NULL,
	id uuid NOT NULL,
	address varchar(255) NULL,
	"name" varchar(255) NULL,
	phone varchar(255) NULL,
	CONSTRAINT company_nit_key UNIQUE (nit),
	CONSTRAINT company_pkey PRIMARY KEY (id)
);


-- public.currency definition

-- Drop table

-- DROP TABLE public.currency;

CREATE TABLE public.currency (
	id uuid DEFAULT gen_random_uuid() NOT NULL,
	description varchar(255) NULL,
	CONSTRAINT currency_description_key UNIQUE (description),
	CONSTRAINT currency_pkey PRIMARY KEY (id)
);


-- public.customer definition

-- Drop table

-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	number_document int8 NULL,
	id uuid NOT NULL,
	"name" varchar(255) NULL,
	type_document varchar(255) NULL,
	CONSTRAINT customer_number_document_key UNIQUE (number_document),
	CONSTRAINT customer_pkey PRIMARY KEY (id)
);


-- public.local_user definition

-- Drop table

-- DROP TABLE public.local_user;

CREATE TABLE public.local_user (
	id uuid NOT NULL,
	email varchar(255) NULL,
	"password" varchar(255) NULL,
	CONSTRAINT local_user_email_key UNIQUE (email),
	CONSTRAINT local_user_pkey PRIMARY KEY (id)
);


-- public.local_order definition

-- Drop table

-- DROP TABLE public.local_order;

CREATE TABLE public.local_order (
	"date" date NULL,
	customer_id uuid NULL,
	id uuid NOT NULL,
	CONSTRAINT local_order_pkey PRIMARY KEY (id),
	CONSTRAINT fks6ni26gwfasv9ugawc6xy6s40 FOREIGN KEY (customer_id) REFERENCES public.customer(id)
);


-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id uuid NOT NULL,
	company_id uuid NULL,
	characteristic varchar(255) NULL,
	code varchar(255) NULL,
	"name" varchar(255) NULL,
	quantity int4 DEFAULT 0 NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id),
	CONSTRAINT fkobq63io8qm71jnb79crofvhoo FOREIGN KEY (company_id) REFERENCES public.company(id)
);


-- public.product_categories definition

-- Drop table

-- DROP TABLE public.product_categories;

CREATE TABLE public.product_categories (
	categories_id uuid NOT NULL,
	product_entity_id uuid NOT NULL,
	CONSTRAINT fk86pfomapgvxb87x9nnxuc0pdj FOREIGN KEY (categories_id) REFERENCES public.category(id),
	CONSTRAINT fklsgs0k0s6pa6mja7xba8bl3np FOREIGN KEY (product_entity_id) REFERENCES public.product(id)
);


-- public.local_order_products definition

-- Drop table

-- DROP TABLE public.local_order_products;

CREATE TABLE public.local_order_products (
	order_entity_id uuid NOT NULL,
	products_id uuid NOT NULL,
	CONSTRAINT fk9jl3tv710wm2qeelk9ujcfy3v FOREIGN KEY (products_id) REFERENCES public.product(id),
	CONSTRAINT fkkepxec7vtc2r2bhthergb87wt FOREIGN KEY (order_entity_id) REFERENCES public.local_order(id)
);


-- public.price definition

-- Drop table

-- DROP TABLE public.price;

CREATE TABLE public.price (
	value int8 NULL,
	currency_id uuid NULL,
	id uuid NOT NULL,
	product_id uuid NULL,
	CONSTRAINT price_pkey PRIMARY KEY (id),
	CONSTRAINT fkjufxmhfbykaua4p43u87udfqq FOREIGN KEY (currency_id) REFERENCES public.currency(id),
	CONSTRAINT fks2t3gvhs4d79t1y8lnccbwmfr FOREIGN KEY (product_id) REFERENCES public.product(id)
);