package model.product;

import model.Comment;

import java.util.ArrayList;

public abstract class Product implements Comparable{
    private int scoreCounter;
    private static int counter = 1;
    private String Id;
    private String name;
    private long price;
    private Boolean available;
    private int averageScore;
    private ArrayList<Comment> comments = new ArrayList<>();
    private TypeOfProduct typeOfProduct;
    private int availableProducts;

    public Product(String name, long price, TypeOfProduct typeOfProduct, int availableProducts) {
        this.name = name;
        this.scoreCounter = 0;
        this.availableProducts = availableProducts;
        this.price = price;
        this.available = buildAvailableStatus();
        this.averageScore = 0;
        this.typeOfProduct = typeOfProduct;
        this.Id = buildId();
        counter++;
    }

    private Boolean buildAvailableStatus() {
        Boolean available = true;
        if (availableProducts == 0) {
            available = false;
        }
        return available;
    }

    private String buildId() {
        StringBuilder id = new StringBuilder("Product");
        id.append(counter);
        id.append("-");
        id.append(typeOfProduct.toString());
        id.append("-");
        id.append(name);
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public int getScoreCounter() {
        return scoreCounter;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public void setScoreCounter(int scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    public String getId() {
        return Id;
    }

    public TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
    }

    public long getPrice() {
        return price;
    }

    public int getAvailableProducts() {
        return availableProducts;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setAvailableProducts(int availableProducts) {
        this.availableProducts = availableProducts;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        String string = "ID:" + Id + " | name:" + name + " | price:" + price + " | available:" + available.toString() + " | averageScore:" + averageScore + " | Type :" + typeOfProduct + " | ";
        return string;
    }

    public String toStringList() {
        String string = "ID:" + Id + " | name:" + name + " | price:" + price + " | available:" + available.toString();
        return string;
    }
    @Override
    public int compareTo(Object o) {
        Product product = (Product) o;
        if (this.name.compareTo(product.name) > 0) {
            return 1;
        }
        else if (this.name.compareTo(product.name) == 0) {

            if (this.averageScore > product.averageScore) {
                return 1;
            }
            else if (this.averageScore == product.averageScore) {


                if (this.price > product.price) {
                    return 1;
                }
                else if (this.price == product.price) {

                    if (this.availableProducts > product.availableProducts) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
                else if (this.price < product.price) {
                    return -1;
                }
            }

            else if (this.averageScore < product.averageScore) {
                return -1;
            }
        }
        else if (this.name.compareTo(product.name) < 0) {
            return -1;
        }
        return 0;
    }
}