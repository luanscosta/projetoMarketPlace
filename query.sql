CREATE TABLE users (
user_id     number(8) NOT NULL,
user_name   VARCHAR(30) NOT NULL,
user_pass   VARCHAR(255) NOT NULL,
user_email  VARCHAR(255) NOT NULL,
user_creation_date   TIMESTAMP NOT NULL,
user_type  number(8) NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE categories (
cat_id          number(8) NOT NULL,
cat_name        VARCHAR(255) NOT NULL,
cat_description     VARCHAR(255) NOT NULL,
PRIMARY KEY (cat_id)
);

CREATE TABLE topics (
topic_id        number(8) NOT NULL,
topic_subject       VARCHAR(255) NOT NULL,
topic_date      TIMESTAMP NOT NULL,
topic_cat       number(8) NOT NULL,
topic_by        number(8) NOT NULL,
PRIMARY KEY (topic_id),
FOREIGN KEY(topic_cat) REFERENCES categories(cat_id),
FOREIGN KEY(topic_by) REFERENCES users(user_id)
);

CREATE TABLE posts (
post_id         number(8) NOT NULL,
post_content        CLOB NOT NULL,
post_date       TIMESTAMP NOT NULL,
post_topic      number(8) NOT NULL,
post_by     NUMBER(8) NOT NULL,
PRIMARY KEY (post_id),
FOREIGN KEY(post_topic) REFERENCES topics(topic_id),
FOREIGN KEY(post_by) REFERENCES users(user_id)
);
