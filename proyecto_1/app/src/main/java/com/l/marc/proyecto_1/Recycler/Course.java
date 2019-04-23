package com.l.marc.proyecto_1.Recycler;

public class Course {
    private String name;
    private String description;
    private String author;
    private float rating;
    private int students;
    private float price;
    private int idImage;

    public Course(String name,
                  String description,
                  String author,
                  float rating,
                  int students,
                  float price,
                  int idImage) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.rating = rating;
        this.students = students;
        this.price = price;
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public float getRating() {
        return rating;
    }

    public int getStudents() {
        return students;
    }

    public float getPrice() {
        return price;
    }

    public int getIdImage() {
        return idImage;
    }
}
