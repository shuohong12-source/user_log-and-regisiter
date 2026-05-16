package com.example.dao;

import com.example.model.User;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    public User login(String phone,String password){
        String sql= "select * from user where phone = ? and password = ?";

        try(
                Connection conn= DBUtil.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);
                ) {

            ps.setString(1,phone);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setPhone(rs.getString("phone"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setRole(rs.getString("role"));
                return user;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isPhoneExist(String phone){
        String sql="select* from user where phone=?";

        try(
                Connection conn=DBUtil.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);


                ) {
                ps.setString(1,phone);
                ResultSet rs=ps.executeQuery();
                return  rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    public  boolean register(User user){
        String sql="insert into user(phone, name, password, gender, role) values(?,?,?,?,?)";
        try(
                Connection conn=DBUtil.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);


                ) {
            ps.setString(1, user.getPhone());
            ps.setString(2,user.getName());
            ps.setString(3,user.getPassword());
            ps.setString(4, user.getGender());
            ps.setString(5,"user");
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    public boolean updateUser(User user) {
        String sql = "update user set name = ?, password = ?, gender = ? where id = ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getGender());
            ps.setInt(4, user.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }



    public List<User> findAllUsers(){
        List<User> list=new ArrayList<>();
        String sql="select * from user where role = 'user'";
        try(
                Connection conn=DBUtil.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);



                ) {

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setPhone(rs.getString("phone"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setRole(rs.getString("role"));
                list.add(user);



            }



        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;


    }
    public  boolean deleteUser(int id){
        String sql="delete from user where id = ? and role = 'user'";
        try(
                Connection conn=DBUtil.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);

                ) {
            ps.setInt(1,id);
            return  ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }










}
