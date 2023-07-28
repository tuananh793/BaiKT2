/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Message;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAO  {
  Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public User findUserByUsernameandPassWord(User user){
        String query = "select * from UserTBL where userid = ? and password = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, user.username);
            ps.setString(2, user.password);
            rs = ps.executeQuery();
            while(rs.next())
            {
               User user1 = new User(rs.getString(1),rs.getString(2));
               return  user1;
            }
            
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Message> getListMessageByUser(User user) {
        List<Message> listM = new ArrayList<>();
        String query = "SELECT *from MessageTBL where MessageTBL.[to] = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, user.username);
            rs = ps.executeQuery();
            while(rs.next())
            {               
               listM.add(new Message(rs));
            }
            return listM;
            
        } catch (SQLException e) {
        }
        return null;
    }
    public static void main(String[] args) {
        List<User> listM = new DAO().findListUser(new User("admin","123456"));
        for(User i : listM) System.out.print(i);
        
    }

    public Message findMessageById(String messId) {
        String query = "select * from MessageTBL where messageid = ? ";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, messId);
 
            rs = ps.executeQuery();
            while(rs.next())
            {
               Message message = new Message(rs);
               return  message;
            }
            
        } catch (SQLException e) {
        }
        return null;
        
    }

    public List<User> findListUser(User user) {
        List<User> list = new ArrayList<>();
         String query = "SELECT *from UserTBL where userid <> ? ";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, user.username);
            rs = ps.executeQuery();
            while(rs.next())
            {               
               list.add(new User(rs.getString(1),rs.getString(2)));
            }
            return list;
            
        } catch (SQLException e) {
        }
        return null;
        
    }

    public void saveMessage(Message message, User user) {
        String query ="INSERT INTO [MESSAGETBL]([messagetitle],[messagetime],[from],[to],[messagecontent],[isread]) "
                + "VALUES(?,GETDATE(), ?,?,?,0)";
         try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, message.getMessagetitle());
            ps.setString(2,user.getUsername() );
            ps.setString(3, message.getTo());
            ps.setString(4, message.getMessagecontent());             
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        
        }
}
