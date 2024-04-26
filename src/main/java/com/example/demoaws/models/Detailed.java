package com.example.demoaws.models;

public class Detailed {
    // Este es un modelo especial
    // No tiene repositorio ni servicio
    // Se usa para devolver datos provenientes de varios modelos

    private Long employee_id;

    private String first_name;

    private String last_name;

    private String email;

    private String phone_number;

    private String hire_date;

    private Long job_id;

    private Float salary;

    private Float commission_pct;

    private Long manager_id;

    private Long department_id;

    private String department_name;

    private Long department_manager_id;

    private Long location_id;

    private String job_title;
    private Long min_salary;
    private Long max_salary;

    public Detailed() {
    }

    public Detailed(Employee emp, Department dep, Job job) {
        this.employee_id = emp.getEmployee_id();
        this.first_name = emp.getFirst_name();
        this.last_name = emp.getLast_name();
        this.email = emp.getEmail();
        this.phone_number = emp.getPhone_number();
        this.hire_date = emp.getHire_date();
        this.job_id = emp.getJob_id();
        this.salary = emp.getSalary();
        this.commission_pct = emp.getCommission_pct();
        this.manager_id = emp.getManager_id();
        this.department_id = emp.getDepartment_id();
        if (dep != null) {
            this.department_name = dep.getDepartment_name();
            this.department_manager_id = dep.getManager_id();
            this.location_id = dep.getLocation_id();
        }

        if (job != null) {
            this.job_title = job.getJob_title();
            this.min_salary = job.getMin_salary();
            this.max_salary = job.getMax_salary();
        }
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Long min_salary) {
        this.min_salary = min_salary;
    }

    public Long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Long max_salary) {
        this.max_salary = max_salary;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(Float commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Long getDepartment_manager_id() {
        return department_manager_id;
    }

    public void setDepartment_manager_id(Long department_manager_id) {
        this.department_manager_id = department_manager_id;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }
}
