/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controllers;

import hotel.enums.DepartmentOrInstitutionType;
import hotel.enums.ItemOrCategoryType;
import hotel.enums.Privilege;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author buddhika
 */
@ManagedBean
@SessionScoped
public class EnumController {

    /**
     * Creates a new instance of EnumController
     */
    public EnumController() {
    }
    
    public DepartmentOrInstitutionType[] getDepartmentOrInstitutionTypes(){
        return DepartmentOrInstitutionType.values();
    }
    
    public ItemOrCategoryType[] getItemOrCategoryTypes(){
       return ItemOrCategoryType.values();
    }
    public Privilege[] getpPrivileges(){
     return Privilege.values();
}
    
}
