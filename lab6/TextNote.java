package com.example.lab3;

public class TextNote extends Note{
    //Attribute
    private String textContent;

    //setter method
    public void setTextContent(String inputText){
        this.textContent = inputText;
    }

    //getter method
    public String getTextContent(){
        return textContent;
    }

    //method
    String display() {
        /*System.out.println(title);
        System.out.println(textContent);
        System.out.println(createdDate);*/
        return "Title : " + title +
                "\nItemList : " + textContent +
                "\nDate : " + createdDate +
                "\nOwner : " + (owner != null ? owner.getNameUser() : "Unknow");
    }
}
