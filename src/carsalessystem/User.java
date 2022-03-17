/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsalessystem;

import JFrame.loginPanel;
import JFrame.regPanel;
import JFrame.accountPanel;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public abstract class  User {
    protected String name;
    protected String address;
    protected String PhoneNumber;
    protected String email;
    protected String password;
    protected static accountPanel view = new accountPanel();
    protected static loginPanel log = new loginPanel();
    protected static regPanel reg = new regPanel();
    protected static User currentUser;
    protected static Connection db =null;

    
    protected User() {
        this.name = null;
        this.address = null;
        this.PhoneNumber = null;
        this.email = null;
        this.password = null;
    }

    protected User(String name, String address, String PhoneNumber, String email, String password) {
        this.name = name;
        this.address = address;
        this.PhoneNumber = PhoneNumber;
        this.email = email;
        this.password = password;
    }
    
    ///////////////// View All Cars - Search For Cars //////////////////
    protected abstract void viewCars(ArrayList <Car> cars);
    
    protected abstract void Search(ArrayList <Car> cars);
    
    ////////////////  Show Pages ///////////////////
    protected void showAccount(){   
        
        view.userName.setText(name);
        log.setVisible(false);
        view.setVisible(true);
        
    }
    protected static void showLoginPage(){
        view.setVisible(false);
        reg.setVisible(false);
        log.setVisible(true);
        reg.clearForm();
    }

    protected static void showRegPage(){
        log.setVisible(false);
        view.setVisible(false);
        reg.setVisible(true);
        log.clearForm();
    }
   ////////////////////////////////////////////////////  LogIn Form //////////////////////////////////////////
    public static boolean loginFormIsCorrect(){
        JTextField emailfield = log.getEmailField();
        JPasswordField passfield = log.getPassField();
        String email = emailfield.getText();
        String pass = passfield.getText();
        String regex = "^[a-zA-Z0-9]([_\\-\\.]?|[a-zA-Z0-9])+[a-zA-Z0-9]@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
        //^[a-zA-Z][\\w\\.]+[a-zA-z0-9]\\@[a-zA-Z]+(\\.[a-zA-Z]+)+$  modified
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(log,"Email Is Empty","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(pass.isEmpty()){
            JOptionPane.showMessageDialog(log,"Password Is Empty","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!email.matches(regex)){
            JOptionPane.showMessageDialog(log,"Invalid email, try again","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(pass.length()<5)
        {
            JOptionPane.showMessageDialog(log,"password must be at least 5 characters, try again","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    ////////////// GETTERS && SETTERS /////////////////
    
    public static accountPanel getView() {
        return view;
    }

    public static loginPanel getLog() {
        return log;
    }

    public static regPanel getReg() {
        return reg;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public static void setConnection(Connection db) {
        User.db = db;
    }
}
