package com.csc340.nutrilogdemo.food;

public class Food {
    String name;
    String ingredients;
    String fatContent;
    String carbContent;
    String proteinContent;

    public Food(FoodService foodService) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getFatContent() {
        return fatContent;
    }

    public void setFatContent(String fatContent) {
        this.fatContent = fatContent;
    }

    public String getCarbContent() {
        return carbContent;
    }

    public void setCarbContent(String carbContent) {
        this.carbContent = carbContent;
    }

    public String getProteinContent() {
        return proteinContent;
    }

    public void setProteinContent(String proteinContent) {
        this.proteinContent = proteinContent;
    }
}
