/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeAccount;

public class Account{
    private String ID = "-1";
    private String Name = null;
    private String Address = null;
    private String Phone = null;
    
    public String getID(){
    return ID;
    }
    public void setID(String newID){
        ID = newID;
    }
    public String getName(){
    return Name;
    }
    public void setName(String newName){
        Name = newName;
    }
    public String getAddress(){
    return Address;
    }
    public void setAddress(String newAddress){
        Address = newAddress;
    }
    public String getPhone(){
    return Phone;
    }
    public void setPhone(String newPhone){
        Phone = newPhone;
    }
}