-- Portable schema for H2 / MySQL
create table if not exists accounts (
  username varchar(50) primary key,
  password varchar(255) not null,
  fullname varchar(100) not null,
  admin boolean not null
);


