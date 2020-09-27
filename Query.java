package com.cn.jdbc;
import java.sql.*;
import java.util.*;
public class Query{
    public List<com.cn.jdbc.UserVo> showUser(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<com.cn.jdbc.UserVo>list = new ArrayList<com.cn.jdbc.UserVo>();
        try{
            conn = com.cn.jdbc.MySQLDemo.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from users");
            while(rs.next()){
                com.cn.jdbc.UserVo userVo = new com.cn.jdbc.UserVo();
                userVo.setId(rs.getInt("id"));
                userVo.setName(rs.getString("name"));
                userVo.setAge(rs.getInt("age"));
                userVo.setTel(rs.getString("tel"));
                userVo.setAddress(rs.getString("address"));
                list.add(userVo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            com.cn.jdbc.MySQLDemo.free(rs,conn,stmt);
        }
        return list;
    }
    public static void main(String[] args){
        Query query = new Query();
        List<com.cn.jdbc.UserVo>list = query.showUser();
        if(list!=null){
            System.out.print("id  ");
            System.out.print("name    ");
            System.out.print("age  ");
            System.out.print("tel        ");
            System.out.print("address            ");
            System.out.println();
        }
        for(int i = 0;i<list.size();i++)
        {
            System.out.print(list.get(i).getId()+"\t");
            System.out.print(list.get(i).getName()+"\t");
            System.out.print(list.get(i).getAge()+"\t");
            System.out.print(list.get(i).getTel()+"\t");
            System.out.print(list.get(i).getAddress()+"\t");
            System.out.println();
        }
    }
}
