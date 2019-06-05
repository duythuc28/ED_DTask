/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author iOSDev
 */
public class LibUserDTO {
    
    private String userId;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String appgroup;
    private Boolean active;
    private String memo;
    private LibBookDTO book;
    
    public LibUserDTO(String userId, String name, String password, String email, String phone, String address, String appgroup, Boolean active, String memo, LibBookDTO book) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.appgroup = appgroup;
        this.active = active;
        this.memo = memo;
        this.book = book;
    }
    
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAppgroup() {
        return appgroup;
    }

    public Boolean getActive() {
        return active;
    }

    public String getMemo() {
        return memo;
    }

    public LibBookDTO getBook() {
        return book;
    }
}
