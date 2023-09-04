package com.example.arquiBack.dto;

import com.example.arquiBack.entity.Receta;

import java.util.List;

public class RecetaDto {
    private int id;
    private String title;
    private String image;
    private String imageType;
    private int usedIngredientCount;
    private int missedIngredientCount;
    private List<IngredienteDto> missedIngredients;
    private List<IngredienteDto> usedIngredients;
    private List<IngredienteDto> unusedIngredients;
    private int likes;

    public RecetaDto() {
    }

    public RecetaDto(int id, String title, String image, String imageType, int usedIngredientCount, int missedIngredientCount, List<IngredienteDto> missedIngredients, List<IngredienteDto> usedIngredients, List<IngredienteDto> unusedIngredients, int likes) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
        this.usedIngredientCount = usedIngredientCount;
        this.missedIngredientCount = missedIngredientCount;
        this.missedIngredients = missedIngredients;
        this.usedIngredients = usedIngredients;
        this.unusedIngredients = unusedIngredients;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public void setUsedIngredientCount(int usedIngredientCount) {
        this.usedIngredientCount = usedIngredientCount;
    }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public void setMissedIngredientCount(int missedIngredientCount) {
        this.missedIngredientCount = missedIngredientCount;
    }

    public List<IngredienteDto> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<IngredienteDto> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public List<IngredienteDto> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<IngredienteDto> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public List<IngredienteDto> getUnusedIngredients() {
        return unusedIngredients;
    }

    public void setUnusedIngredients(List<IngredienteDto> unusedIngredients) {
        this.unusedIngredients = unusedIngredients;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "RecetaDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", imageType='" + imageType + '\'' +
                ", usedIngredientCount=" + usedIngredientCount +
                ", missedIngredientCount=" + missedIngredientCount +
                ", missedIngredients=" + missedIngredients +
                ", usedIngredients=" + usedIngredients +
                ", unusedIngredients=" + unusedIngredients +
                ", likes=" + likes +
                '}';
    }
}