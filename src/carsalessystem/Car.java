/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsalessystem;
import JFrame.carPanel;

/**
 *
 * @author HP
 */
public class Car {
    static int Count=0;
    static int lastId=0;
    
    private int year_Purchase, year_manufacture;
    private String manufactor_Type,model_Name;
    private int ColorNumber;
    private String[]Colors=new String[ColorNumber];
    private boolean available=true;  //to know car sold or no
    private int id;
    private int price;
    private byte[] img;
    private carPanel carCard = new carPanel();
    private String buyer ;
    
    public Car() {
        Count++;
    }
    
    public Car(int year_manufacture, String manufactor_Type, String model_Name, int price, int year_purchase) {
        Count++;
        this.year_manufacture = year_manufacture;
        this.manufactor_Type = manufactor_Type;
        this.model_Name = model_Name;
        this.price = price;
        this.year_Purchase = year_purchase;
    }
    
    public int getYear_manufacture() {
        return year_manufacture;
    }

    public void setYear_manufacture(int year_manufacture) {
        this.year_manufacture = year_manufacture;
    }
    
    public int getYear_purchase() {
        return year_Purchase;
    }
    
    public void setYear_purchase(int year_purchase) {
        this.year_Purchase = year_purchase  ;
    }
    
    public String getManufactor_Type() {
        return manufactor_Type;
    }

    public void setManufactor_Type(String manufactor_Type) {
        this.manufactor_Type = manufactor_Type;
    }
    public String getModel_Name() {
        return model_Name;
    }

    public void setModel_Name(String model_Name) {
        this.model_Name = model_Name;
    }

    public void setColorNumber(int ColorNumber) {
        this.ColorNumber = ColorNumber;
    }

    public int getColorNumber() {
        return ColorNumber;
    }
    
    public String[] getColors() {
        return Colors;
    }
    public void setColors(String[] Colors) {
            this.Colors = Colors;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public byte[] getImg(){
        return img;
    }

    public void setImg (byte[] bytes){
        this.img = bytes;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setCard(){ // make a card for the car ( must be called only after setting car data)
        String color = String.join(", ", Colors);
        String [] cardData = {manufactor_Type,model_Name,String.valueOf(year_manufacture),String.valueOf(price),color};
        carCard.setCardData(cardData);
        carCard.setImage(img);
    }
    
    public carPanel getCard(){
        return carCard;
    }
    public String[] getCardData(){
        String color = String.join(", ", Colors);
        String carData[] = {manufactor_Type,model_Name,String.valueOf(year_manufacture),String.valueOf(price),color};
        return carData;
    }

    public void setBuyer(String buyer){
        this.buyer = buyer;
        carCard.setBuyer(buyer, year_Purchase);
    }
    

    
    @Override
    public String toString() {
        return "Car{" + "year_manufacture=" + year_manufacture + ", manufactor_Type=" + manufactor_Type + ", model_Name=" + model_Name + ", id=" + id + ", price=" + price + '}';
    }
}
