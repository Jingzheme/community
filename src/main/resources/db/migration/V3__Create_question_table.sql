create table question
(
  id  int auto_increment primary key,
  title varchar(50),
  description text,
  gmt_create bigint,
  gmt_modified bigint,
  creator int,
  comment_count int default 0 not null,
  view_count int default 0 not null,
  like_count int default 0 not null,
  tag varchar(256),
);