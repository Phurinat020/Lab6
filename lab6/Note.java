package com.example.lab3;

import java.util.Date;

public abstract class Note {
    //Attribute
    protected String title;
    Date createdDate;
    protected User owner;

    //getter method
    public String getTitle(){
        return title;
    }

    public User getOwner() {
        return owner;
    }

    //setter method
    public void setTitle(String inputTitle){
        this.title = inputTitle;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    //method
    abstract String display();
        /*System.out.println(title);
        System.out.println(content);
        System.out.println(createdDate);*/
}
