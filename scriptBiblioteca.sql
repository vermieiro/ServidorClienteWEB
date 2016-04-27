--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2016-04-25 22:11:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 180 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 16460)
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE autor (
    id integer NOT NULL,
    nome character varying(150),
    email character varying(150)
);


ALTER TABLE autor OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16463)
-- Name: autor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE autor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE autor_id_seq OWNER TO postgres;

--
-- TOC entry 2036 (class 0 OID 0)
-- Dependencies: 173
-- Name: autor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE autor_id_seq OWNED BY autor.id;


--
-- TOC entry 174 (class 1259 OID 16465)
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE genero (
    id integer NOT NULL,
    descricao character varying(150)
);


ALTER TABLE genero OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16468)
-- Name: genero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE genero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE genero_id_seq OWNER TO postgres;

--
-- TOC entry 2037 (class 0 OID 0)
-- Dependencies: 175
-- Name: genero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE genero_id_seq OWNED BY genero.id;


--
-- TOC entry 176 (class 1259 OID 16470)
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE livro (
    isbn integer NOT NULL,
    titulo character varying(150),
    descricao character varying(1000),
    anolancamento integer,
    idautor integer NOT NULL,
    idgenero integer NOT NULL
);


ALTER TABLE livro OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16476)
-- Name: livro_idautor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE livro_idautor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE livro_idautor_seq OWNER TO postgres;

--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 177
-- Name: livro_idautor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE livro_idautor_seq OWNED BY livro.idautor;


--
-- TOC entry 178 (class 1259 OID 16478)
-- Name: livro_idgenero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE livro_idgenero_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE livro_idgenero_seq OWNER TO postgres;

--
-- TOC entry 2039 (class 0 OID 0)
-- Dependencies: 178
-- Name: livro_idgenero_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE livro_idgenero_seq OWNED BY livro.idgenero;


--
-- TOC entry 179 (class 1259 OID 16480)
-- Name: livro_isbn_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE livro_isbn_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE livro_isbn_seq OWNER TO postgres;

--
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 179
-- Name: livro_isbn_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE livro_isbn_seq OWNED BY livro.isbn;


--
-- TOC entry 1898 (class 2604 OID 16503)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY autor ALTER COLUMN id SET DEFAULT nextval('autor_id_seq'::regclass);


--
-- TOC entry 1899 (class 2604 OID 16504)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genero ALTER COLUMN id SET DEFAULT nextval('genero_id_seq'::regclass);


--
-- TOC entry 1900 (class 2604 OID 16505)
-- Name: isbn; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livro ALTER COLUMN isbn SET DEFAULT nextval('livro_isbn_seq'::regclass);


--
-- TOC entry 1901 (class 2604 OID 16506)
-- Name: idautor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livro ALTER COLUMN idautor SET DEFAULT nextval('livro_idautor_seq'::regclass);


--
-- TOC entry 1902 (class 2604 OID 16507)
-- Name: idgenero; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livro ALTER COLUMN idgenero SET DEFAULT nextval('livro_idgenero_seq'::regclass);


--
-- TOC entry 2020 (class 0 OID 16460)
-- Dependencies: 172
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY autor (id, nome, email) FROM stdin;
1	Thiago	picadas@pega.na.minha
5	Luiz	Luiz@gmail.com
4	joabe	joabe@gmail.com
6	teste	teste@teste.com
\.


--
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 173
-- Name: autor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('autor_id_seq', 5, true);


--
-- TOC entry 2022 (class 0 OID 16465)
-- Dependencies: 174
-- Data for Name: genero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY genero (id, descricao) FROM stdin;
5	terror
4	suspense
3	acao
\.


--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 175
-- Name: genero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('genero_id_seq', 8, true);


--
-- TOC entry 2024 (class 0 OID 16470)
-- Dependencies: 176
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY livro (isbn, titulo, descricao, anolancamento, idautor, idgenero) FROM stdin;
3	Eu e vc	Vc e eu	2016	4	3
\.


--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 177
-- Name: livro_idautor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('livro_idautor_seq', 1, false);


--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 178
-- Name: livro_idgenero_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('livro_idgenero_seq', 1, false);


--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 179
-- Name: livro_isbn_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('livro_isbn_seq', 3, true);


--
-- TOC entry 1904 (class 2606 OID 16488)
-- Name: autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id);


--
-- TOC entry 1906 (class 2606 OID 16490)
-- Name: genero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (id);


--
-- TOC entry 1908 (class 2606 OID 16492)
-- Name: livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (isbn);


--
-- TOC entry 1909 (class 2606 OID 16493)
-- Name: livro_idautor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livro
    ADD CONSTRAINT livro_idautor_fkey FOREIGN KEY (idautor) REFERENCES autor(id);


--
-- TOC entry 1910 (class 2606 OID 16498)
-- Name: livro_idgenero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livro
    ADD CONSTRAINT livro_idgenero_fkey FOREIGN KEY (idgenero) REFERENCES genero(id);


--
-- TOC entry 2034 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-25 22:11:59

--
-- PostgreSQL database dump complete
--

