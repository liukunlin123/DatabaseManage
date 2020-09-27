package com.cn.jdbc;
import java.sql.*;
import java.util.*;
public class QueryById{
    public com.cn.jdbc.UserVo queryUserById(int id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        com.cn.jdbc.UserVo userVo = null;
        try{
            conn = com.cn.jdbc.MySQLDemo.getConnection();
            pstmt=conn.prepareStatement("SELECT * from users where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                userVo = new com.cn.jdbc.UserVo();
                userVo.setId(rs.getInt("id"));
                userVo.setName(rs.getString("name"));
                userVo.setAge(rs.getInt("age"));
                userVo.setTel(rs.getString("tel"));
                userVo.setAddress(rs.getString("address"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            com.cn.jdbc.MySQLDemo.free(rs,conn,pstmt);
        }
        return userVo;
    }
    public static void main(String[] args){
        QueryById ById = new QueryById();
        int id = 207;
        com.cn.jdbc.UserVo vo = ById.queryUserById(id);
        if(vo != null){
            System.out.print("id\t");
            System.out.print("name\t");
            System.out.print("age\t");
            System.out.print("tel\t");
            System.out.print("  address");
            System.out.println();
            System.out.print(vo.getId()+"\t");
            System.out.print(vo.getName()+"\t");
            System.out.print(vo.getAge()+"\t");
            System.out.print(vo.getTel()+"\t");
            System.out.print(vo.getAddress()+"\t");
            System.out.println();
        }
    }
}
