/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.library.databaseconnection;

/**
 *
 * @author iOSDev
 */
public class User {
    private String userID;
    private String name;
    private String password;
    private String email;
    private String phone; 
    private String address;
    private String appGroup;
    private boolean active;
    private String memo;

    public User(String userID, String name, String password, String email, String phone, String address, String appGroup, boolean active, String memo) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.appGroup = appGroup;
        this.active = active;
        this.memo = memo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppGroup() {
        return appGroup;
    }

    public void setAppGroup(String appGroup) {
        this.appGroup = appGroup;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    
}
