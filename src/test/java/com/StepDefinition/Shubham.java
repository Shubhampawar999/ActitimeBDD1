package com.StepDefinition;

public class Shubham {

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesc() {
        return desc;
    }

    private String name;
    private String city;
    private String department;
    private String desc;

    public Shubham(){
        super();
    }
    public Shubham(String name,String city,String department,String desc){
        this.name=name;
        this.city=city;
        this.department=department;
        this.desc=desc;

    }

}
