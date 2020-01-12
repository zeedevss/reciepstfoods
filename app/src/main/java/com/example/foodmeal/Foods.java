package com.example.foodmeal;

import org.json.JSONObject;

public class Foods {
    private String foodName;
    private String foodCategory;
    private String foodImage;

    public Foods(String name, String category, String image)  {
        this.foodName = name;
        this.foodCategory = category;
        this.foodImage = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getFoodImage() { return foodImage; }

    public void setFoodImage(String foodImage) { this.foodImage = foodImage; }
}
