package MySQL;

/**
 *
 * @author Marvin Chin Yi Kai
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Alert;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbutils.DbUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*  OPERATION FOR MYSQL
SHOW DATABASES;
USE 5peJ8pFLLQ;
SHOW TABLES;
SELECT * FROM projects;
SELECT * FROM issues;
SELECT * FROM comments;
SELECT * FROM react;
SELECT * FROM users;
SELECT * FROM projects_history;
SELECT * FROM issues_history;
SELECT * FROM comments_history;
DROP TABLE comments_reactions;
DROP TABLE projects_history;
DROP TABLE issues_history;
DROP TABLE comments_history;
DROP TABLE projects;
DROP TABLE issues;
DROP TABLE comments;
DROP TABLE react;
DROP TABLE users;

CREATE TABLE projects (
project_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
project_timestamp TIMESTAMP NOT NULL);

CREATE TABLE issues (
project_id INT NOT NULL,
issue_id INT NOT NULL,
PRIMARY KEY (project_id, issue_id),
title VARCHAR(50),
priority INT,
status VARCHAR(20),
tag VARCHAR(100),
descriptionText VARCHAR(19000),
createdBy VARCHAR(20),
assignee VARCHAR(20),
issue_timestamp TIMESTAMP,
url VARCHAR(2083));

CREATE TABLE comments (
project_id INT NOT NULL,
issue_id INT NOT NULL,
comment_id INT NOT NULL,
PRIMARY KEY (project_id, issue_id, comment_id),
text VARCHAR(250),
comment_timestamp TIMESTAMP,
user VARCHAR(25));

CREATE TABLE react (
project_id INT NOT NULL,
issue_id INT NOT NULL,
comment_id INT NOT NULL,
reaction VARCHAR(10),
PRIMARY KEY (project_id, issue_id, comment_id, reaction),
count INT);

CREATE TABLE users (
userid INT,
username VARCHAR(25),
password VARCHAR(64),
admin boolean,
url VARCHAR(2083),
email VARCHAR(40)
);

CREATE TABLE comments_reactions (hash INT, reactions VARCHAR(20));

ALTER TABLE users ADD UNIQUE(userid);
ALTER TABLE users ADD UNIQUE(username);

CREATE TABLE projects_history (
project_id INT NOT NULL,
version_id INT NOT NULL,
name VARCHAR(20) NOT NULL,
originalTime TIMESTAMP NOT NULL,
PRIMARY KEY (project_id, originalTime),
CONSTRAINT project_id_fk
    FOREIGN KEY profile_id_fkx (project_id)
    REFERENCES projects(project_id)
);

CREATE TABLE issues_history (
project_id INT NOT NULL,
issue_id INT NOT NULL,
version_id INT,
title VARCHAR(50),
priority INT,
status VARCHAR(20),
tag VARCHAR(100),
descriptionText VARCHAR(19000),
createdBy VARCHAR(20),
assignee VARCHAR(20),
issue_timestamp TIMESTAMP,
url VARCHAR(2083),
PRIMARY KEY (project_id, issue_id, issue_timestamp),
CONSTRAINT pi_fk
    FOREIGN KEY pi_fk (project_id, issue_id)
    REFERENCES issues (project_id, issue_id)
);

CREATE TABLE comments_history (
project_id INT NOT NULL,
issue_id INT NOT NULL,
comment_id INT NOT NULL,
version_id INT NOT NULL,
text VARCHAR(250),
comment_timestamp TIMESTAMP,
user VARCHAR(25),
PRIMARY KEY (project_id, issue_id, comment_id, comment_timestamp),
CONSTRAINT pic_fk
    FOREIGN KEY pic_fkx (project_id, issue_id, comment_id)
    REFERENCES comments (project_id, issue_id, comment_id)
);
 */
public class MySQLOperation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
