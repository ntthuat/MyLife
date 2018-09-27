-- Create Schema STOCK
CREATE SCHEMA IF NOT EXISTS STOCK;
commit; -- TODO: NEED TO USE?

-------------------
-- STOCK.NASDAQ;
--DROP TABLE STOCK.NASDAQ;
CREATE TABLE STOCK.NASDAQ
(stock_id IDENTITY NOT NULL,
stock_quote VARCHAR NOT NULL,
previous_close_price DECIMAL,
open_price DECIMAL,
price DECIMAL NOT NULL,
creation_date TIMESTAMP NOT NULL,
PRIMARY KEY (stock_id));

INSERT INTO STOCK.NASDAQ (stock_quote, previous_close_price, open_price, price, creation_date)
VALUES                   ('AAPL'     , null                , null      , 220.42,      SYSDATE);