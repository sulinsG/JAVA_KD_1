package models;

import java.util.Date;

public class FeedProduct {
    private int id;
    private String title;
    private int quantity;
    private Date expiryDate;
    private static int feedProductCounter = 100000;

    public void setId() {
        this.id = feedProductCounter++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public static int getFeedProductCounter() {
        return feedProductCounter;
    }

    public void setTitle(String title) {
        if(!title.isEmpty() && title.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))
        {
            this.title = title;
        }
        else
            this.title = "Unknown";
    }

    public void setQuantity(int quantity) {
        if(quantity > 0 && quantity < 10000)
        {
            this.quantity = quantity;
        }
        else
            this.quantity = 0;
    }


    //TODO
    //Check if this function makes any sense
    Date checkingDate= new Date(2022,4,8);
    public void setExpiryDate(Date expiryDate) {
        if(expiryDate.after(checkingDate))
        {
            this.expiryDate = expiryDate;
        }
        else
            this.expiryDate = new Date();
    }


    public FeedProduct()
    {
        setId();
        setTitle("Unknown");
        setExpiryDate(new Date());
        setQuantity(0);
    }
    public FeedProduct(String title, Date expiryDate, int quantity)
    {
        setId();
        setTitle(title);
        setExpiryDate(expiryDate);
        setQuantity(quantity);

    }


    @Override
    public String toString() {
        return "FeedProduct{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                ", checkingDate=" + checkingDate +
                '}';
    }
}
