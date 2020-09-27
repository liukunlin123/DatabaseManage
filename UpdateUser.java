package com.cn.jdbc;
import java.sql.*;
public class UpdateUser{
    public void update(com.cn.jdbc.UserVo userVo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "Update users set id = ?,name=?,age=?,tel=?,address=?WHERE id = ?";
        try{
            conn = com.cn.jdbc.MySQLDemo.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userVo.getId());
            pstmt.setString(2,userVo.getName());
            pstmt.setInt(3,userVo.getAge());
            pstmt.setString(4,userVo.getTel());
            pstmt.setString(5,userVo.getAddress());
            pstmt.setInt(6,userVo.getId());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            com.cn.jdbc.MySQLDemo.free(null,conn,pstmt);
        }
    }
    public static void main(String[] args){
        UpdateUser updateUser = new UpdateUser();
        int id = 107;
        String name = "Jack";
        int age = 19;
        String tel = "123-465465";
        String address = "银河系";
        com.cn.jdbc.QueryById queryById = new com.cn.jdbc.QueryById();
        com.cn.jdbc.UserVo vo = new com.cn.jdbc.UserVo();
        vo=queryById.queryUserById(id);
        if(vo!=null){
            com.cn.jdbc.UserVo userVo = new com.cn.jdbc.UserVo();
            userVo.setId(id);
            userVo.setName(name);
            userVo.setAge(age);
            userVo.setTel(tel);
            userVo.setAddress(address);
            updateUser.update(userVo);
            System.out.println("修改成功！修改了id值为"+id+"的数据");
        }
        else {
            System.out.println("修改失败！原因：id为"+id+"的数据不存在");
        }
    }

}
