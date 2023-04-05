package controller;

import model.CommentStatus;
import model.product.Product;
import model.product.TypeOfProduct;
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
import model.user.RequestType;
import model.user.user_types.Admin;

public class AdminController {

    public static void addProduct(String[] parts, int i) {
        switch (parts[i + 1]) {
            case "PersonalComputer":
                long price1 = Long.parseLong(parts[i + 3]);
                int weight = Integer.parseInt(parts[i + 4]);
                int dimensions = Integer.parseInt(parts[i + 5]);
                int ram = Integer.parseInt(parts[i + 7]);
                int number = Integer.parseInt(parts[i + 8]);
                PersonalComputer personalComputer = new PersonalComputer(parts[i + 2], price1, weight, dimensions, parts[i + 6], ram, number);
                Admin.getProducts().add(personalComputer);
                break;
            case "Car":
                long price = Long.parseLong(parts[i + 3]);
                int capacity = Integer.parseInt(parts[i + 6]);
                Boolean auto = Boolean.valueOf(parts[i + 5]);
                int number1 = Integer.parseInt(parts[i + 7]);
                Car car = new Car(parts[i + 2], price, parts[i + 4], auto, capacity, number1);
                Admin.getProducts().add(car);
                break;
            case "Pen":
                long price2 = Long.parseLong(parts[i + 3]);
                int number2 = Integer.parseInt(parts[i + 6]);
                Pen pen = new Pen(parts[i + 2], price2, parts[i + 4], parts[i + 5], number2);
                Admin.getProducts().add(pen);
                break;
            case "NoteBook":
                long price3 = Long.parseLong(parts[i + 3]);
                int paperNumber = Integer.parseInt(parts[i + 5]);
                int number3 = Integer.parseInt(parts[i + 7]);
                NoteBook noteBook = new NoteBook(parts[i + 2], price3, parts[i + 4], paperNumber, parts[i + 6], number3);
                Admin.getProducts().add(noteBook);
                break;
            case "SSD":
                long price4 = Long.parseLong(parts[i + 3]);
                int weight1 = Integer.parseInt(parts[i + 4]);
                int dimensions1 = Integer.parseInt(parts[i + 5]);
                int capacity1 = Integer.parseInt(parts[i + 6]);
                int readingSpeed = Integer.parseInt(parts[i + 7]);
                int writingSpeed = Integer.parseInt(parts[i + 8]);
                int number4 = Integer.parseInt(parts[i + 9]);
                SSD ssd = new SSD(parts[i + 2], price4, weight1, dimensions1, capacity1, readingSpeed, writingSpeed, number4);
                Admin.getProducts().add(ssd);
                break;
            case "Flash":
                long price5 = Long.parseLong(parts[i + 3]);
                int weight2 = Integer.parseInt(parts[i + 4]);
                int dimensions2 = Integer.parseInt(parts[i + 5]);
                int capacity2 = Integer.parseInt(parts[i + 6]);
                int usbVersion = Integer.parseInt(parts[i + 7]);
                int number5 = Integer.parseInt(parts[i + 8]);
                Flash flash = new Flash(parts[i + 2], price5, weight2, dimensions2, capacity2, usbVersion, number5);
                Admin.getProducts().add(flash);
                break;
            case "Pencil":
                long price6 = Long.parseLong(parts[i + 3]);
                int number6 = Integer.parseInt(parts[i + 6]);
                String type = parts[i + 5];
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
                Pencil pencil = new Pencil(parts[i + 2], price6, parts[i + 4], pencilType, number6);
                Admin.getProducts().add(pencil);
                break;
            case "Bike":
                long price7 = Long.parseLong(parts[i + 3]);
                int number7 = Integer.parseInt(parts[i + 6]);
                String type1 = parts[i + 5];
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
                Bike bike = new Bike(parts[i + 2], price7, parts[i + 4], bikeType, number7);
                Admin.getProducts().add(bike);
                break;
        }
    }

    /////
    public static void removeProduct(String[] parts, int i) {
        long price = Long.parseLong(parts[i + 2]);
        for (Product a : Admin.getProducts()) {
            if (a.getName().equals(parts[i + 1]) && a.getPrice() == price) {
                Admin.getProducts().remove(a);
                break;
            }
        }
    }

    /////
    public static void editProduct(String[] parts, int i) {
        long price = Long.parseLong(parts[i + 2]);
        for (Product a : Admin.getProducts()) {
            if (a.getName().equals(parts[i + 1]) && a.getPrice() == price) {
                a.setName(parts[i + 3]);
                long price1 = Long.parseLong(parts[i + 4]);
                a.setPrice(price1);
                int availableProducts = Integer.parseInt(parts[i + 5]);
                a.setAvailableProducts(availableProducts);
                Boolean available = true;
                if (availableProducts == 0) {
                    available = false;
                }
                a.setAvailable(available);
                break;
            }
        }
    }

    public static void acceptRequest(String[] parts) {
        for (String a : parts) {
            int code = Integer.parseInt(a);
            for (Request request : Admin.getRequests()) {
                if (request.getRequestCode() == code) {
                    if (request.getRequestType() == RequestType.Signup) {
                        CostumerController.getCostumers().add(request.getCostumer());
                    }
                    if (request.getRequestType() == RequestType.Comment) {
                        request.getProduct().getComments().add(request.getComment());
                        request.getComment().setStatus(CommentStatus.accepted);
                    }
                    if (request.getRequestType() == RequestType.RaiseCredit) {
                        long credit = request.getCostumer().getCredit();
                        credit = credit + request.getCredit();
                        request.getCostumer().setCredit(credit);
                    }
                    Admin.getRequests().remove(request);
                    break;
                }
            }
        }
    }

    public static void rejectRequest(String[] parts) {
        int code;
        for (String a : parts) {
            code = Integer.parseInt(a);
            for (Request request : Admin.getRequests()) {
                if (request.getRequestCode() == code) {
                    if (request.getRequestType() == RequestType.Comment) {
                        request.getComment().setStatus(CommentStatus.rejected);
                    }
                    Admin.getRequests().remove(request);
                    break;
                }
            }
        }
    }

    public static Product search(String name) {
        for (Product a : Admin.getProducts()) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public static Product searchID(String Id) {
        for (Product a : Admin.getProducts()) {
            if (a.getId().equals(Id)) {
                return a;
            }
        }
        return null;
    }

    public static String filterPrice(long min, long max) {
        StringBuilder result = new StringBuilder();
        for (Product a : Admin.getProducts()) {
            if (a.getPrice() >= min && a.getPrice() <= max) {
                result.append(a.toStringList());
                result.append("\n");
            }

        }
        return result.toString();
    }

    public static String filterAvailable() {
        StringBuilder result = new StringBuilder();
        for (Product a : Admin.getProducts()) {
            if (!(a.getAvailableProducts() == 0)) {
                result.append(a.toStringList());
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String filterScore(long min, long max) {
        StringBuilder result = new StringBuilder();
        for (Product a : Admin.getProducts()) {
            if (a.getAverageScore() >= min && a.getAverageScore() <= max) {
                result.append(a.toStringList());
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String filterType(String typeOfProduct) {
        TypeOfProduct b = TypeOfProduct.DIGITAL;
        switch (typeOfProduct) {
            case "DIGITAL":
                b = TypeOfProduct.DIGITAL;
                break;
            case "FOOD":
                b = TypeOfProduct.FOOD;
                break;
            case "VEHICLES":
                b = TypeOfProduct.VEHICLES;
                break;
            case "STATIONARY":
                b = TypeOfProduct.STATIONARY;
                break;
        }
        StringBuilder result = new StringBuilder();
        for (Product a : Admin.getProducts()) {
            if (a.getTypeOfProduct() == b) {
                result.append(a.toStringList());
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String filterCpu(String cpu) {
        StringBuilder result = new StringBuilder();
        for (Product a : Admin.getProducts()) {
            if (a instanceof PersonalComputer) {
                if (((PersonalComputer) a).getCpuModel().equals(cpu)) {
                    result.append(a.toStringList());
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static String filterColor(String color) {
        StringBuilder result = new StringBuilder();
        for (Product a : Admin.getProducts()) {
            if (a instanceof Pen) {
                if (((Pen) a).getColor().equals(color)) {
                    result.append(a.toStringList());
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void score(int score, String Id) {
        int a = (searchID(Id).getScoreCounter() * searchID(Id).getAverageScore()) + score;
        int average = (a / (searchID(Id).getScoreCounter() + 1));
        searchID(Id).setAverageScore(average);
        int newCount = searchID(Id).getScoreCounter() + 1;
        searchID(Id).setScoreCounter(newCount);
    }
}