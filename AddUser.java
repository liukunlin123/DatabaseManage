package com.cn.jdbc;
import java.sql.*;
public class AddUser {
    public void add(com.cn.jdbc.UserVo userVo){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            conn = com.cn.jdbc.MySQLDemo.getConnection();
            String sql = "INSERT INTO users(id,name,age,tel,address)values(?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,userVo.getId());
            pstm.setString(2,userVo.getName());
            pstm.setInt(3,userVo.getAge());
            pstm.setString(4,userVo.getTel());
            pstm.setString(5,userVo.getAddress());
            pstm.executeUpdate();
            System.out.println("添加成功！添加的内容如下：");
            System.out.println("id:"+userVo.getId()+"\t name:"+userVo.getName()+"\t age:"+userVo.getAge()+"\t tel:"+userVo.getTel()+"\t address:"+userVo.getAddress());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            com.cn.jdbc.MySQLDemo.free(rs,conn,pstm);
        }
    }
    public static void main(String[] args){
        AddUser addUser = new AddUser();
        com.cn.jdbc.UserVo userVo = new com.cn.jdbc.UserVo();
        int id = 207;
        String name = "赵六";
        int age=22;
        String tel="324242";
        String address = "北京海淀区";
        userVo.setId(id);
        userVo.setName(name);
        userVo.setAge(age);
        userVo.setAddress(address);
        addUser.add(userVo);
    }
}
