package com.cn.jdbc;
import java.sql.*;
public class MySQLDemo{
    static String drivename = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static String usename = "root";
    static String password = "lkl15220319";
    static{
        try{
            Class.forName(drivename);
            System.out.println("创建驱动成功");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,usename,password);
            System.out.println("连接数据库成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void free(ResultSet rs, Connection conn, Statement stmt){
        try{
            if(rs != null)
                rs.close();
        }catch(SQLException e)
        {
            System.out.println("关闭ResultSet失败!");
            e.printStackTrace();
        }finally {
            try{
                if(conn != null)
                    conn.close();
            }catch (SQLException e){
                System.out.println("关闭Connectioin失败！");
                e.printStackTrace();
            }finally {
                try{
                    if(stmt != null)
                        stmt.close();
                }catch(SQLException e){
                    System.out.println("关闭Statement失败！");
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args)
    {
        MySQLDemo.getConnection();
    }
}