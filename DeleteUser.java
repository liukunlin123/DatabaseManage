package com.cn.jdbc;

import java.sql.*;

public class DeleteUser {
    public void deleteUser(int id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = com.cn.jdbc.MySQLDemo.getConnection();
            String sql = "DELETE FROM users where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("删除成功！删除了id值为"+id+"的数据");
        }catch (SQLException  e){
            e.printStackTrace();
        }finally {
            com.cn.jdbc.MySQLDemo.free(null,conn,pstmt);
        }
    }
    public static void main(String[] args){
        DeleteUser deleteUser = new DeleteUser();
        int id = 1;
        com.cn.jdbc.UserVo userVo = new com.cn.jdbc.UserVo();
        com.cn.jdbc.QueryById queryById = new com.cn.jdbc.QueryById();
        userVo = queryById.queryUserById(id);
        if(userVo != null){
            deleteUser.deleteUser(id);
        }
        else{
            System.out.println("删除失败！原因：id为"+id+"的数据不存在！");
        }
    }

}
