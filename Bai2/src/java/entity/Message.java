/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Message {
    private int messageid;
    private String messagetitle;
    private String messagetime;
    private String from;
    private String to;
    private String messagecontent;
    private int isread;
    

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle;
    }

    public String getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(String messagetime) {
        this.messagetime = messagetime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public int getIsread() {
        return isread;
    }

    public void setIsread(int isread) {
        this.isread = isread;
    }
    

    public Message(int messageid, String messagetitle, String messagetime, String from, String to, String messagecontent, int isread) {
        this.messageid = messageid;
        this.messagetitle = messagetitle;
        this.messagetime = messagetime;
        this.from = from;
        this.to = to;
        this.messagecontent = messagecontent;
        this.isread = isread;
    }
    public Message(ResultSet rs) throws SQLException{
         this.messageid = rs.getInt(1);
        this.messagetitle = rs.getString(2);
        this.messagetime = rs.getString(3);
        this.from = rs.getString(4);
        this.to = rs.getString(5);
        this.messagecontent = rs.getString(6);
        this.isread = rs.getInt(7);
    
    }
    public Message(){
         
    
    }

    @Override
    public String toString() {
        return "Message{" + "messageid=" + messageid + ", messagetitle=" + messagetitle + ", messagetime=" + messagetime + ", from=" + from + ", to=" + to + ", messagecontent=" + messagecontent + ", isread=" + isread + '}';
    }
    
    
}
