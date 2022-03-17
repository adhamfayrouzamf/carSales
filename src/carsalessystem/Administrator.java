/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsalessystem;
import JFrame.addCarPanel;
import JFrame.carPanel;
import JFrame.editCarPanel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author HP
 */
public class Administrator extends User{
   private static addCarPanel add = new addCarPanel();
   private static editCarPanel edit = new editCarPanel();

    public Administrator(String name, String address, String PhoneNumber, String email, String password) {
        super(name, address, PhoneNumber, email, password);
    }
    public Administrator(Administrator a) {
        super(a.name, a.address, a.PhoneNumber, a.email, a.password);
    }
   
    ///////////////////////////////////// Add Car Section ////////////////////////
   
    public static boolean addCarFormIsCorrect(){
        JTextField [] texts = add.getTextFields();
        int colornum = add.getColorNumber();
        for(int i=0;i<texts.length - (3-colornum);i++){
            if(texts[i].getText().isEmpty()){
                JOptionPane.showMessageDialog(add,texts[i].getName()+" Is Empty","Alert",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        if(colornum == 0){
            JOptionPane.showMessageDialog(add,"color number is empty","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        for(int i=5;i<texts.length - (3-colornum);i++){
            for(int j=i+1;j<texts.length - (3-colornum);j++){
                if(texts[i].getText().equals(texts[j].getText())){
                    JOptionPane.showMessageDialog(add,"Can't have same color more than once","Alert",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
        String yearRegex = "^[1-9]\\d{3}$";
        String priceRegex = "^[1-9]\\d*$";
        String imgRegex = "^([a-zA-Z]:([\\\\\\/]))?(([^\\/\\\\\\*\\|\\?<>:\"])+([\\\\\\/]))*([^\\/\\\\\\*\\|\\?<>:\"])*(\\.(png|jpg|jpeg|bmp|gif|wbmp))$";
        
        if(!texts[2].getText().matches(yearRegex)){
            JOptionPane.showMessageDialog(add,"Invalid year","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!texts[3].getText().matches(priceRegex)){
            JOptionPane.showMessageDialog(add,"Invalid price","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!texts[4].getText().matches(imgRegex)){
            JOptionPane.showMessageDialog(add,"Invalid image file","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!Files.exists(Paths.get(texts[4].getText()))){
            JOptionPane.showMessageDialog(add,"Image file doesn't exist","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
   public void addCar(ArrayList <Car> Cars)
   {    
       JTextField[] texts = add.getTextFields();
       int ColorNumber = add.getColorNumber();
       
       int year_manufacture,price;
       String manufactor_Type,model_Name,imgPath;
       
       year_manufacture=Integer.parseInt(texts[2].getText());
       manufactor_Type=texts[0].getText();
       model_Name=texts[1].getText();
       
       String[]Colors=new String[ColorNumber];
       for(int i=0,j=5;i<ColorNumber;i++){
            Colors[i] = texts[j].getText();
            j++;
       }
       imgPath = texts[4].getText();
       price=Integer.parseInt(texts[3].getText());
       
       Car.lastId++;
       Cars.add(new Car());
       Cars.get(Car.Count - 1).setYear_manufacture(year_manufacture);
       Cars.get(Car.Count - 1).setManufactor_Type(manufactor_Type);
       Cars.get(Car.Count - 1).setModel_Name(model_Name);
       Cars.get(Car.Count - 1).setColorNumber(ColorNumber);
       Cars.get(Car.Count - 1).setColors(Colors);
       Cars.get(Car.Count - 1).setPrice(price);
       Cars.get(Car.Count - 1).setId(Car.lastId);
       
       byte[] imgBytes = null;
       try{
           imgBytes = Files.readAllBytes(Paths.get(imgPath));
           Cars.get(Car.Count - 1).setImg(imgBytes);
       }catch(IOException ex){
           System.out.println(ex.getMessage());
       }
       Cars.get(Car.Count - 1).setCard();
       view.carList.add(Cars.get(Car.Count - 1).getCard());
       
       
       addCarListeners(Cars.get(Car.Count - 1),Cars);
       
       PreparedStatement st = null;
       try {
           
           String sql = "insert into cars (car_id,car_model,manufacture_type,year_manufacture,color_number,price,img) VALUES (?,?,?,?,?,?,?)";
            //+Car.lastId+",'"+model_Name+"','"+manufactor_Type+"',"+year_manufacture+","+ColorNumber+","+price+","+imgBytes+")";
           st = db.prepareStatement(sql);
           st.setInt(1, Car.lastId);
           st.setString(2, model_Name);
           st.setString(3, manufactor_Type);
           st.setInt(4, year_manufacture);
           st.setInt(5, ColorNumber);
           st.setInt(6, price);
           st.setBytes(7, imgBytes);
           st.execute();
           for(int i=0;i<ColorNumber;i++){
               sql = "insert into car_colors VALUES("+Car.lastId+",'"+Colors[i]+"')";
                st = db.prepareStatement(sql);
                st.execute();
           }
       }catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       finally{
           try {
               st.close();
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
        }
       add.clearForm();
    }
   private void addCarListeners(Car car, ArrayList <Car> cars){  // Each Car has Car Listeners //

            car.getCard().deleteButton.addActionListener(new java.awt.event.ActionListener() {    
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int carIndex = Integer.parseInt(((JButton)evt.getSource()).getParent().getParent().getName());
                int choice = JOptionPane.showConfirmDialog(view,"Are you sure you want to delete this car ?");
                if(choice == JOptionPane.YES_OPTION){
                    ((Administrator)currentUser).deleteCar(cars,carIndex);
                    view.refresh();
                    JOptionPane.showMessageDialog(view,"Car has been deleted");
                }
            }
        });
            car.getCard().editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int carIndex = Integer.parseInt(((JButton)evt.getSource()).getParent().getParent().getName());
                edit.editButton.setName(String.valueOf(carIndex));
                Car car = cars.get(carIndex);
                showEditCarPage(car);
            }
        });
            
            
            car.getCard().buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int carIndex = Integer.parseInt(((JButton)evt.getSource()).getParent().getParent().getName());
                int choice = JOptionPane.showConfirmDialog(view,"Are you sure you want to buy this car ?");
                if(choice == JOptionPane.YES_OPTION){
                    ((Customer)currentUser).buyCar(carIndex, cars);
                    view.refresh();
                }
            }
        });
    }
   public void setCarlisteners(ArrayList <Car> Cars){
        for(int i=0;i<Car.Count;i++){
            addCarListeners(Cars.get(i),Cars);
        }
    }
   
   ///////////////////////////////////// Edit Car Section ///////////////////////////////////
   
   
   public static boolean editCarFormIsCorrect(){
        JTextField [] texts = edit.getTextFields();
        for(int i=0;i<texts.length -1;i++){
            if(texts[i].getText().isEmpty()){
                JOptionPane.showMessageDialog(edit,texts[i].getName()+" Is Empty","Alert",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        String yearRegex = "^[1-9]\\d{3}";
        String priceRegex = "^[1-9]\\d*";
        String imgRegex = "^([a-zA-Z]:([\\\\\\/]))?(([^\\/\\\\\\*\\|\\?<>:\"])+([\\\\\\/]))*([^\\/\\\\\\*\\|\\?<>:\"])*(\\.(png|jpg|jpeg|bmp|gif|wbmp))$";
        if(!texts[2].getText().matches(yearRegex)){
            JOptionPane.showMessageDialog(edit,"Invalid year","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!texts[3].getText().matches(priceRegex)){
            JOptionPane.showMessageDialog(edit,"Invalid price","Alert",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(!texts[4].getText().isEmpty()){
            if(!texts[4].getText().matches(imgRegex)){
                JOptionPane.showMessageDialog(edit,"Invalid image file","Alert",JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if(!Files.exists(Paths.get(texts[4].getText()))){
                JOptionPane.showMessageDialog(edit,"Image file doesn't exist","Alert",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        
        return true;
    }
    public void editCar(ArrayList <Car> Cars, int index)
    {
      JTextField texts[] = edit.getTextFields();
        
      int year_manufacture,price, carId = Cars.get(index).getId();
      String manufactor_Type,model_Name, imgPath;
      year_manufacture = Integer.parseInt(texts[2].getText());
      price = Integer.parseInt(texts[3].getText());
      manufactor_Type = texts[0].getText();
      model_Name = texts[1].getText();
      imgPath = texts[4].getText();
      
            Cars.get(index).setYear_manufacture(year_manufacture);//edit in java
            Cars.get(index).setManufactor_Type(manufactor_Type);
            Cars.get(index).setModel_Name(model_Name);
            Cars.get(index).setPrice(price);
            
            byte[] imgBytes = null;
            
            if(!imgPath.equals("")){
                try{
                   imgBytes = Files.readAllBytes(Paths.get(imgPath));
                   Cars.get(index).setImg(imgBytes);
               }catch(IOException ex){
                   System.out.println(ex.getMessage());
               }
            }
            else{
                imgBytes = Cars.get(index).getImg();
            }
               
            Cars.get(index).setCard();
            
            String sql = "UPDATE cars set year_manufacture = ? ,manufacture_type = ? , car_model = ? ,price = ? , img = ? WHERE car_id = ?"; //edit above in db
            
            PreparedStatement st = null;
            try{
                st = db.prepareStatement(sql);
                st.setInt(1, year_manufacture);
                st.setString(2, manufactor_Type);
                st.setString(3, model_Name);
                st.setInt(4, price);
                st.setBytes(5, imgBytes);
                st.setInt(6, carId);
                st.execute();
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
            edit.clearForm();
    }
    
    
    ////////////////////////////////////////// DELETE Car Section /////////////////////////////////////////
    
    private void deleteCar (ArrayList <Car> Cars, int index)
    {
        
        int carId = Cars.get(index).getId();
        
                view.carList.remove(Cars.get(index).getCard());
                Cars.remove(index);

                Car.Count--;
                carPanel.cardCount--;
                for(int i = index;i<Car.Count;i++){
                    Cars.get(i).getCard().setName(""+i);
                }
                
                String sql = "DELETE FROM cars Where car_id = "+carId;
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
    
   
    
    ///////////////////////////////////////////////// Show Pages //////////////////////////////////////
    
    public static void showAddCarPage(){
        view.setVisible(false);
        add.setVisible(true);
        
    }
    
    public static void showEditCarPage(Car car){
        view.setVisible(false);
        edit.setVisible(true);
        edit.setTextFields(car);
        
    }
    @Override
    protected void showAccount(){
        super.showAccount();
        
        view.addCarButton.setVisible(true);
        
        edit.setVisible(false);
        add.setVisible(false);
        
        view.refresh();
    }
    
    ///////////////////////////////////////////////// View All Cars - Search For Cars//////////////////////////////////////
    
    @Override
    protected void Search(ArrayList <Car> cars){
        String filter = view.getFilter();
        String searchText  = view.getSearchText().toLowerCase();
        String[] carData;
        String data;
        String priceRegex = "^[1-9]\\d*$";        
        if(!filter.equals("Filter") ){
            view.carList.removeAll();
            for(int i=0;i<Car.Count;i++){
                carData = cars.get(i).getCardData();
                
                if(filter.equals("manufacturer")){
                    data = carData[0].toLowerCase();
                    if(data.contains(searchText)){
                        view.carList.add(cars.get(i).getCard());
                    }
                }
                else if(filter.equals("model name")){
                    data = carData[1].toLowerCase();
                    if(data.contains(searchText)){
                        view.carList.add(cars.get(i).getCard());
                    }
                }
                else if(filter.equals("year")){
                    data = carData[2].toLowerCase();
                    if(data.equals(searchText)){
                        view.carList.add(cars.get(i).getCard());
                    }
                }
                else if(filter.equals("price") && searchText.matches(priceRegex)){
                    int price = Integer.parseInt(carData[3]);
                    int searchPrice = Integer.parseInt(searchText);
                    if(price <= searchPrice){
                        view.carList.add(cars.get(i).getCard());
                    }
                }
            }
        }
        view.refresh();
    }
//    private void filter(String data){
//        
//    }
//    private void filter(int data){
//        
//    }
    @Override
    protected void viewCars(ArrayList <Car> cars){
        view.carList.removeAll();
        for(int i=0;i<Car.Count;i++){
            cars.get(i).getCard().buyButton.setVisible(false);
            cars.get(i).getCard().editButton.setVisible(true);
            cars.get(i).getCard().deleteButton.setVisible(true);
            if(!cars.get(i).isAvailable()){
                cars.get(i).getCard().buyerPanel.setVisible(true);
            }
            view.carList.add(cars.get(i).getCard());
        }
        view.refresh();
    }
    
   
    
    
    /////////////// GETTERS  &&  SETTERS ////////////////////////////
    public static editCarPanel getEdit() {
        return edit;
    }
    public static addCarPanel getAdd() {
        return add;
    }

}
