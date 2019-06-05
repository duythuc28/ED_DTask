/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iOSDev
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    public String logoutResult() {
        // terminate the session by invalidating the session context
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (Exception ex) {
            // do nothing
            System.out.println("log out ...");
        }
        // terminate the session by invalidating the session context
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        // terminate the user's login credentials
        return "/faces/logout.xhtml";
    }
    
    public boolean isAdmin() {
        // terminate the session by invalidating the session context
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.isUserInRole("ADMIN")) {
            System.out.println("Yes, user is in ADMIN role");
            return true;
        } 
        return false;
    }
    
//    public boolean isUser() { 
//        
//    }
//    
//    public boolean isLibrarian() { 
//        
//    }
    
    public String getUserRole() { 
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.isUserInRole("ADMIN")) {
            System.out.println("Yes, user is in ADMIN role");
            return "ADMIN";
        } else if (request.isUserInRole("LIBRARIAN")) {
            return "LIBRARIAN";
        } else { 
            return "USER";
        }
    }
    
}
