package com.example.login.Pro;

/**
 * Created by Aws on 28/01/2018.
 */

public class Product {

    private String Title;
    private String Price;
    private String Category ;
    private String Description ;
    private int Thumbnail ;

    public Product() {
    }

    public Product(String title, String price, String category, String description, int thumbnail) {
        Title = title;
        Price=price;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }
    public String getPrice() {
        return Price;
    }


    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }
    public void setPrice(String price) {
        Price = price;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
