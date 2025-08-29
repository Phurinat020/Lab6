package com.example.lab3;

import java.util.ArrayList;
import java.util.List;

public class CheckListNote extends Note{
    //Attribute
    private List<String> itemList = new ArrayList<>();

    //getter
    public List<String> getItemList() {
        return itemList;
    }

    //setter
    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    //method
    @Override
    String display() {
        /*System.out.println(title + ":");
        System.out.println(itemList);
        System.out.println("Date : " + createdDate);*/
        return "Title : " + title +
                "\nItemList : " + itemList +
                "\nDate : " + createdDate +
                "\nOwner : " + (owner != null ? owner.getNameUser() : "Unknow");
    }
}