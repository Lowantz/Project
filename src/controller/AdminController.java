package controller;

import model.product.Product;
import model.product.productlist.Car;
import model.product.productlist.NoteBook;
import model.product.productlist.Pen;
import model.product.productlist.PersonalComputer;
import model.product.productlist.bike.Bike;
import model.product.productlist.bike.BikeType;
import model.product.productlist.pencil.Pencil;
import model.product.productlist.pencil.PencilType;
import model.product.productlist.save_data_products.Flash;
import model.product.productlist.save_data_products.SSD;
import model.user.Request;
import model.user.user_types.Admin;
import model.user.user_types.Costumer;

import java.util.ArrayList;

public class AdminController {
    public static void acceptRequest(Request request) {
        request.setAcceptStatus(true);
    }

    public static void addProduct(String[] parts,int i) {
        switch (parts[i+1]) {
            case "PersonalComputer":
                long price1 = Long.parseLong(parts[i+3]);
                int weight = Integer.parseInt(parts[i+4]);
                int dimensions = Integer.parseInt(parts[i+5]);
                int ram = Integer.parseInt(parts[i+7]);
                int number = Integer.parseInt(parts[i+8]);
                PersonalComputer personalComputer = new PersonalComputer(parts[i+2], price1, weight, dimensions, parts[i+6], ram,number);
                Admin.getProducts().add(personalComputer);
                break;
            case "Car":
                long price = Long.parseLong(parts[i+3]);
                int capacity = Integer.parseInt(parts[i+6]);
                Boolean auto = Boolean.valueOf(parts[i+5]);
                int number1 = Integer.parseInt(parts[i+7]);
                Car car = new Car(parts[i+2], price, parts[i+4], auto, capacity,number1);
                Admin.getProducts().add(car);
                break;
            case "Pen":
                long price2 = Long.parseLong(parts[i+3]);
                int number2 = Integer.parseInt(parts[i+6]);
                Pen pen = new Pen(parts[i+2], price2, parts[i+4], parts[i+5],number2);
                Admin.getProducts().add(pen);
                break;
            case "NoteBook":
                long price3 = Long.parseLong(parts[i+3]);
                int paperNumber = Integer.parseInt(parts[i+5]);
                int number3 = Integer.parseInt(parts[i+7]);
                NoteBook noteBook = new NoteBook(parts[i+2], price3, parts[i+4], paperNumber,parts[i+6],number3);
                Admin.getProducts().add(noteBook);
                break;
            case "SSD":
                long price4 = Long.parseLong(parts[i+3]);
                int weight1 = Integer.parseInt(parts[i+4]);
                int dimensions1 = Integer.parseInt(parts[i+5]);
                int capacity1 = Integer.parseInt(parts[i+6]);
                int readingSpeed = Integer.parseInt(parts[i+7]);
                int writingSpeed = Integer.parseInt(parts[i+8]);
                int number4 = Integer.parseInt(parts[i+9]);
                SSD ssd = new SSD(parts[i+2], price4, weight1, dimensions1, capacity1, readingSpeed, writingSpeed,number4);
                Admin.getProducts().add(ssd);
                break;
            case "Flash":
                long price5 = Long.parseLong(parts[i+3]);
                int weight2 = Integer.parseInt(parts[i+4]);
                int dimensions2 = Integer.parseInt(parts[i+5]);
                int capacity2 = Integer.parseInt(parts[i+6]);
                int usbVersion = Integer.parseInt(parts[i+7]);
                int number5 = Integer.parseInt(parts[i+8]);
                Flash flash = new Flash(parts[i+2], price5, weight2, dimensions2, capacity2, usbVersion,number5);
                Admin.getProducts().add(flash);
                break;
            case "Pencil":
                long price6 = Long.parseLong(parts[i+3]);
                int number6 = Integer.parseInt(parts[i+6]);
                String type = parts[i+5];
                PencilType pencilType = PencilType.TYPE_H;
                switch (type) {
                    case "H":
                        pencilType = PencilType.TYPE_H;
                        break;
                    case "F":
                        pencilType = PencilType.TYPE_F;
                        break;
                    case "B":
                        pencilType = PencilType.TYPE_B;
                        break;
                    case "HB":
                        pencilType = PencilType.TYPE_HB;
                        break;
                    case "2H":
                        pencilType = PencilType.TYPE_2H;
                        break;
                }
                Pencil pencil = new Pencil(parts[i+2], price6, parts[i+4], pencilType,number6);
                Admin.getProducts().add(pencil);
            case "Bike":
                long price7 = Long.parseLong(parts[i+3]);
                int number7= Integer.parseInt(parts[i+6]);
                String type1 = parts[i+5];
                BikeType bikeType = BikeType.Mountainous;
                switch (type1) {
                    case "Mountainous":
                        bikeType = BikeType.Mountainous;
                        break;
                    case "Road":
                        bikeType = BikeType.Road;
                        break;
                    case "Hybrid":
                        bikeType = BikeType.Hybrid;
                        break;
                    case "City":
                        bikeType = BikeType.City;
                        break;
                }
                Bike bike = new Bike(parts[i+2], price7, parts[i+4], bikeType,number7);
                Admin.getProducts().add(bike);
                break;
        }
    }
    /////
    public static void removeProduct(String[] parts,int i) {
        long price = Long.parseLong(parts[i+2]);
        for (Product a : Admin.getProducts()) {
            if (a.getName().equals(parts[i+1]) && a.getPrice() == price){
                Admin.getProducts().remove(a);
            }
        }
    }
    /////
    public static void editProduct(String[] parts,int i) {
        long price = Long.parseLong(parts[i+2]);
        for (Product a : Admin.getProducts()) {
            if (a.getName().equals(parts[i + 1]) && a.getPrice() == price) {
                a.setName(parts[i+3]);
                long price1 = Long.parseLong(parts[i+4]);
                a.setPrice(price1);
                int availableProducts= Integer.parseInt(parts[i+5]);
                a.setAvailableProducts(availableProducts);
                Boolean available = true;
                if (availableProducts == 0 ){
                    available = false;
                }
                a.setAvailable(available);
            }
        }
    }
    public static void viewCostumers(ArrayList<Costumer> costumers) {
        for (Costumer a : costumers ){
            System.out.println("username : "+a.getUserName()+"\n");
        }
    }
    public static void viewRequests(ArrayList <Request> requests ) {
        for (Request a : requests ){
            System.out.println("request text : "+a.getText()+"\n");
        }

    }
}