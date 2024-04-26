drop database `bph9nevvdt8zkzen3nel`;
create database `bph9nevvdt8zkzen3nel`;
use `bph9nevvdt8zkzen3nel`;

CREATE TABLE jobs (
    job_id INT NOT NULL AUTO_INCREMENT,
    job_title VARCHAR(255),
    min_salary FLOAT,
    max_salary FLOAT,
    PRIMARY KEY (job_id)
);

CREATE TABLE departments (
    department_id INT NOT NULL AUTO_INCREMENT,
    department_name VARCHAR(255),
    manager_id INT,
    location_id INT,
    PRIMARY KEY (department_id)
);

CREATE TABLE employees (
    employee_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255),
    hire_date VARCHAR(255),
    job_id INT,
    salary FLOAT,
    commission_pct FLOAT,
    manager_id INT,
    department_id INT,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (job_id)
        REFERENCES jobs (job_id)
        ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (manager_id)
        REFERENCES employees (employee_id)
        ON DELETE SET NULL ON UPDATE CASCADE
);



INSERT INTO jobs (job_title, min_salary, max_salary) VALUES ('Software Engineer', 60000, 120000);
INSERT INTO jobs (job_title, min_salary, max_salary) VALUES ('Data Analyst', 50000, 100000);
INSERT INTO jobs (job_title, min_salary, max_salary) VALUES ('Product Manager', 70000, 140000);
INSERT INTO jobs (job_title, min_salary, max_salary) VALUES ('UX Designer', 55000, 110000);
INSERT INTO jobs (job_title, min_salary, max_salary) VALUES ('DevOps Engineer', 65000, 130000);

INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary,
commission_pct, manager_id, department_id) VALUES ('John', 'Doe', 'john.doe@example.com', '1234567890', '2022-01-01', 1, 80000, 0.05, 1, 1);
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary,
commission_pct, manager_id, department_id) VALUES ('Jane', 'Smith', 'jane.smith@example.com', '0987654321', '2022-02-01', 2, 70000, 0.05, 2, 2);
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary,
commission_pct, manager_id, department_id) VALUES ('Bob', 'Johnson', 'bob.johnson@example.com', '1122334455', '2022-03-01', 3, 90000, 0.05, 3, 3);
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary,
commission_pct, manager_id, department_id) VALUES ('Alice', 'Williams', 'alice.williams@example.com', '2233445566', '2022-04-01', 4, 85000, 0.05, 4, 4);
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary,
commission_pct, manager_id, department_id) VALUES ('Charlie', 'Brown', 'charlie.brown@example.com', '3344556677', '2022-05-01', 5, 75000, 0.05, 5, 5);

INSERT INTO departments (department_name, manager_id, location_id) VALUES ('Engineering', 1, 1);
INSERT INTO departments (department_name, manager_id, location_id) VALUES ('Data Science', 2, 2);
INSERT INTO departments (department_name, manager_id, location_id) VALUES ('Product', 3, 3);
INSERT INTO departments (department_name, manager_id, location_id) VALUES ('Design', 4, 4);
INSERT INTO departments (department_name, manager_id, location_id) VALUES ('DevOps', 5, 5);


ALTER TABLE departments
ADD FOREIGN KEY (manager_id)
REFERENCES employees (employee_id)
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE employees
ADD FOREIGN KEY (department_id)
REFERENCES departments (department_id)
ON DELETE SET NULL ON UPDATE CASCADE