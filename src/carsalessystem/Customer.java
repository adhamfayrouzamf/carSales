/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsalessystem;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.Year;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Customer extends User{
    
    static int count = 0;
    
    public Customer() {
      count++;
      this.name =null;
      this.email = null;
      this.password = null;
      this.PhoneNumber = null;
    }
    
    
    
    public Customer(String name, String email, String password, String PhoneNumber, String Address) {
        count++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.PhoneNumber = PhoneNumber;
        this.address    = Address;
    }
    
    public Customer(Customer c) {
        count++;
        this.name = c.name;
        this.email = c.email;
        this.password = c.password;
        this.PhoneNumber = c.PhoneNumber;
        this.address    = c.address;
    }
    
    //////////////////////////// Registration Section ////////////////////////////////////
    
    public static void Registeration(ArrayList <Customer> Customers)
    {
       JTextField texts[] = reg.getTextFields();
       String name,email,password,phoneNumber,address;
       name=texts[0].getText();
       address = texts[3].getText(); 
       phoneNumber=texts[4].getText();
       email=texts[1].getText();
       password = texts[2].getText();
       
       Customers.add(new Customer (name,email,password,phoneNumber,address));
       Statement st = null;
       try{
           st = db.createStatement();
           String sql =  "INSERT INTO customers (phone,email,password,name,address) VALUES ('"+
                   phoneNumber+"','"+email+"','"+password+"','"+name+"','"+address+"')";
           st.execute(sql);
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       finally{
           try {
               st.close();
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
       
    }
    public static boolean regFormIsCorrect(ArrayList <Customer> customers){
        
        JTextField[] texts = reg.getTextFields();
        
        String emailRegex = "^[a-zA-Z0-9]([_\\-\\.]?|[a-zA-Z0-9])+[a-zA-Z0-9]@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
        String phoneRegex = "^(01)[0125]\\d{8}";
        
        for(int i=0;i<texts.length;i++){
            if(texts[i].getText().isEmpty()){
                JOptionPane.showMessageDialog(reg,texts[i].getName()+" Is Empty","Alert",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        if(!texts[1].getText().matches(emailRegex)){
            JOptionPane.showMessageDialog(reg,"Invalid email, try again","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        for (int i=0;i<Customer.count;i++)
        {
             if(texts[1].equals(customers.get(i).getEmail()))
             {
                 JOptionPane.showMessageDialog(reg,"email exist ,try another email","Alert",JOptionPane.WARNING_MESSAGE);
                 return false;
             }     
        }
        if(texts[2].getText().length()<5)
        {
            JOptionPane.showMessageDialog(reg,"password must be at least 5 characters, try again","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!texts[4].getText().matches(phoneRegex)){
           
            JOptionPane.showMessageDialog(reg,"phoneNumber must be 11 digits starting with 010, 011, 012 or 015","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    //////////////////////////// Show Account  ////////////////////////////////////
    @Override
    protected void showAccount(){
        super.showAccount();
        
        view.addCarButton.setVisible(false);
        
        view.refresh();
    }
    
    //////////////////////////// Show All Cars - Search For Cars - Buy Cars ////////////////////////////////////
    @Override
    protected void viewCars(ArrayList <Car> cars){ // cars will appear in account panel ( variable : view )
        view.carList.removeAll();
        for(int i=0;i<Car.Count;i++){
            cars.get(i).getCard().buyButton.setVisible(true);
            cars.get(i).getCard().editButton.setVisible(false);
            cars.get(i).getCard().deleteButton.setVisible(false);
            cars.get(i).getCard().buyerPanel.setVisible(false);
            if(cars.get(i).isAvailable()){   
                view.carList.add(cars.get(i).getCard());
            }
        }
        view.refresh();
    }
    
    protected void buyCar (int index,ArrayList <Car> Cars){

        int year = Year.now().getValue();
        Cars.get(index).setAvailable(false);
        Cars.get(index).setYear_purchase(year);
        Cars.get(index).setBuyer(email);
        int id = Cars.get(index).getId();
        view.carList.remove(Cars.get(index).getCard());
        String sql = "Update cars set customer_email = '"+this.email + "' , year_purchase = strftime('%Y','now') Where car_id = "+id;
        Statement st = null;
        try{
            st = db.createStatement();
            st.execute(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
           try {
               st.close();
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
    }
    @Override
    protected void Search(ArrayList <Car> cars){ // searched cars will appear in account panel (variable : view)
        String filter = view.getFilter(); // to get current filter (manf_type , model name, price , year )
        String text  = view.getSearchText().toLowerCase();
        String[] carData;
        String car;        
        if(!filter.equals("Filter") ){
            view.carList.removeAll();
            for(int i=0;i<Car.Count;i++){
                carData = cars.get(i).getCardData();
                if(cars.get(i).isAvailable()){
                    if(filter.equals("manufacturer")){
                    car = carData[0].toLowerCase();
                        if(car.contains(text)){
                            view.carList.add(cars.get(i).getCard());
                        }  
                    }
                    else if(filter.equals("model name")){
                        car = carData[1].toLowerCase();
                        if(car.contains(text)){
                            view.carList.add(cars.get(i).getCard());
                        }
                    }
                    else if(filter.equals("year")){
                        car = carData[2].toLowerCase();
                        if(car.equals(text)){
                            view.carList.add(cars.get(i).getCard());
                        }
                    }
                    else if(filter.equals("price")){
                        int price = Integer.parseInt(carData[3]);
                        int searchPrice = Integer.parseInt(text);
                        if(price <= searchPrice){
                            view.carList.add(cars.get(i).getCard());
                        }
                    }
                }
            }
        }
        view.refresh();
    }
    
    

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", password=" + password + ", PhoneNumber=" + PhoneNumber + '}';
    }


}
