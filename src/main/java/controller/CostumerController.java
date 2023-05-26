package controller;

import model.DiscountCode;
import model.exception.*;
import model.product.Product;
import model.user.PurchaseList;
import model.user.user_types.Costumer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CostumerController {
    private static ArrayList<Costumer> costumers = new ArrayList<>();

    public static ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public static Costumer addCostumers(String userName, String email, String phone, String pass) {
        Costumer costumer = new Costumer(userName, email, phone, pass);
        return costumer;
    }

    public static void giveDiscount(DiscountCode discountCode) {
        for (Costumer costumer : costumers) {
            if (costumer.getPurchasedProducts().size() >= 3) {
                costumer.getDiscountCodes().add(discountCode);
            }
        }
    }

    public static String addProduct(Costumer costumer, Product product) throws NoAvailableProduct {
        if (costumer == null)
            return "please signup first!";
        else {
            if (product.getAvailableProducts() == 0) {
                throw new NoAvailableProduct();
            } else {
                costumer.getToBuyList().add(product);
                int b = product.getAvailableProducts();
                product.setAvailableProducts((b - 1));
                return "add done!";
            }
        }
    }

    public static void removeProduct(Costumer costumer, String Id) {
        for (Product product : costumer.getToBuyList()) {
            if (product.getId().equals(Id)) {
                costumer.getToBuyList().remove(product);
                int b = product.getAvailableProducts();
                product.setAvailableProducts((b + 1));
                break;
            }
        }
    }

    public static long calculatePay(Costumer costumer) {
        long price = 0;
        for (Product a : costumer.getToBuyList()) {
            price = price + a.getPrice();
        }
        return price;
    }

    public static long addDiscount(String discountCode,long price,Costumer costumer) throws WrongDiscountCode {
        Boolean bool = false;
        long price1 = 0;
        DiscountCode discountCode1 = null;
        for (DiscountCode a : costumer.getDiscountCodes()){
            if (a.getDiscountCode().equals(discountCode)) {
                discountCode1 = a;
                bool = true;
                break;
            }
        }
        if (bool){
            if (discountCode1.getDiscountCapacityCount()<discountCode1.getDiscountCapacity()){
                if (true/*discountCode1.getDiscountCredit() == LocalDate.EPOCH*/){
                    price1 = (long) (price * discountCode1.getDiscountPercent() / 100);
                   int c = discountCode1.getDiscountCapacityCount();
                   discountCode1.setDiscountCapacityCount(c+1);
                   costumer.getDiscountCodes().remove(discountCode1);
                    return price1;
                }
                else
                    throw new WrongDiscountCode();
            }
            else
                throw new WrongDiscountCode();
        }
        else
            throw new WrongDiscountCode();
    }

    public static String buy(Costumer costumer, long price) throws NoEnoughCredit {
        if (costumer.getToBuyList().size() == 0) {
            return "Purchase List is empty!";
        } else {
            if (price <= costumer.getCredit()) {
                PurchaseList purchaseList = new PurchaseList("1402/02/23", price);
                long remaining = costumer.getCredit() - price;
                costumer.setCredit(remaining);
                for (Product a : costumer.getToBuyList()) {
                        costumer.getPurchasedProducts().add(a);
                        purchaseList.getPurchasedProducts().add(a);
                }
                costumer.getToBuyList().clear();
                costumer.getHistoryBuyList().add(purchaseList);
                return "buy successfully done!";
            } else
                throw new NoEnoughCredit();
        }
    }

    public static Costumer searchCostumers(String userName, String pass) {
        for (Costumer a : costumers) {
            if (a.getUserName().equals(userName) && a.getPass().equals(pass)) {
                return a;
            }
        }
        return null;
    }

    public static String edit(String phone, String email, String pass, Costumer costumer1) throws WrongEmail, WrongPhone {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@(gmail|yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        Pattern pattern1 = Pattern.compile("09\\d{9}");
        Matcher matcher1 = pattern1.matcher(phone);
        Pattern pattern2 = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher matcher2 = pattern2.matcher(pass);
        if (matcher.find()) {
            if (matcher1.find()) {
                if (matcher2.find()) {
                    for (Costumer costumer : CostumerController.getCostumers()) {
                        if (costumer.getEmail().equals(email)) {
                            return "email is Repetitious\n";
                        }
                        if (costumer.getPhone().equals(phone)) {
                            return "phone is Repetitious\n";

                        }
                    }
                    costumer1.setEmail(email);
                    costumer1.setPass(pass);
                    costumer1.setPhone(phone);
                    return "edit done!";
                } else
                    return "invalid pass !";
            } else
                throw new WrongPhone();
        } else
            throw new WrongEmail();
    }

    public static String credit(String creditNumber, String cvv2, String pass) {
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(creditNumber);
        Pattern pattern1 = Pattern.compile("^\\d{4}$");
        Matcher matcher1 = pattern1.matcher(cvv2);
        Pattern pattern2 = Pattern.compile("^\\d{8}$");
        Matcher matcher2 = pattern2.matcher(pass);
        if (matcher.find()) {
            if (matcher1.find()) {
                if (matcher2.find()) {
                    return "valid data!";
                } else
                    return "invalid pass !";
            } else
                return "invalid cvv2 !";
        } else
            return "invalid creditNumber !";
    }

    public static String dataCheck(String username, String email, String phone, String pass) throws WrongEmail, WrongPhone {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@(gmail|yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        Pattern pattern1 = Pattern.compile("09\\d{9}");
        Matcher matcher1 = pattern1.matcher(phone);
        Pattern pattern2 = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher matcher2 = pattern2.matcher(pass);
        Boolean a = matcher.find();
        Boolean b = matcher1.find();
        Boolean c = matcher2.find();
        if (a) {
            if (b) {
                if (c) {
                    for (Costumer costumer : CostumerController.getCostumers()) {
                        if (costumer.getUserName().equals(username)) {
                            return "user name is Repetitious\n";
                        }
                        if (costumer.getEmail().equals(email)) {
                            return "email is Repetitious\n";
                        }
                        if (costumer.getPhone().equals(phone)) {
                            return "phone is Repetitious\n";
                        }
                    }
                    return "signup done !";
                } else
                    return "invalid pass !";
            } else
               throw new WrongPhone();
        } else
          throw new WrongEmail();
    }
}