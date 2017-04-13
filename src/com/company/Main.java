package com.company;

import library.models.DataBaseManager;
import library.utils.DataManager;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DataBaseManager manager = new DataBaseManager();
        //manager.update();
        manager.delete();
        manager.select();
    }



}
