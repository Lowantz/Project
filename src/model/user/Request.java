package model.user;

import model.Comment;
import model.product.Product;
import model.user.user_types.Costumer;

public class Request {
    private static int counter = 1;
    private Product product;
    private int requestCode;
    private Comment comment;
    private long credit;
    private RequestType requestType;
    private Costumer costumer;

    public Request( RequestType requestType, Costumer costumer) {
        this.requestType = requestType;
        this.costumer = costumer;
        this.requestCode = counter;
        counter ++;
    }

    public RequestType getRequestType(){
        return requestType;
    }
    public void setCredit(long credit){
        this.credit = credit;
    }
    public int getRequestCode(){
        return requestCode;
    }
    public long getCredit(){
        return credit;
    }
    public Comment getComment(){
        return comment;
    }
    public Costumer getCostumer(){
        return costumer;
    }
    public Product getProduct(){
        return product;
    }
}