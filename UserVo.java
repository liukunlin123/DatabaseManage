package com.cn.jdbc;
public class UserVo {
    private int id;
    private String name;
    private int age;
    private String tel;
    private String address;
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
}
