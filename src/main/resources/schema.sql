DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    name VARCHAR(250) PRIMARY KEY
);

DROP TABLE IF EXISTS BIRTHEVENT;
CREATE TABLE BIRTHEVENT (
                              id LONG AUTO_INCREMENT PRIMARY KEY,
                              user_name VARCHAR(250) NOT NULL,
                              datetime TIMESTAMP NOT NULL,
                              foreign key (user_name) references users(name)
);

DROP TABLE IF EXISTS MOODEVENT;
CREATE TABLE MOODEVENT (
                             id LONG AUTO_INCREMENT PRIMARY KEY,
                             user_name VARCHAR(250) NOT NULL,
                             mood_type VARCHAR(10) NOT NULL check (mood_type in ('HAPPY', 'SAD', 'ANGRY')),
                             datetime TIMESTAMP NOT NULL,
                             foreign key (user_name) references users(name)
);

DROP TABLE IF EXISTS MOODSTATUS;
CREATE TABLE MOODSTATUS (
                              user_name VARCHAR(250) PRIMARY KEY,
                              level INTEGER NOT NULL,
                              date DATE NOT NULL,
                              foreign key (user_name) references users(name)
);

DROP TABLE IF EXISTS AWARD;
CREATE TABLE AWARD (
                         id INTEGER AUTO_INCREMENT PRIMARY KEY,
                         user_name VARCHAR(250) NOT NULL,
                         event_type VARCHAR(10) check (event_type in ('BIRTH', 'MOOD')),
                         datetime TIMESTAMP NOT NULL,
                         foreign key (user_name) references users(name)
);