package com.learn.sumit.pitanjali;

import java.util.ArrayList;

public class DataHolder {
    public static ArrayList<Products> products=new ArrayList<Products>();

        public static ArrayList<Products> getData() {return products;}

        public static void setData(ArrayList<Products> productss) {products = productss;}

        //private static final DataHolder holder = new DataHolder();

        public  DataHolder(){}

        public  DataHolder(ArrayList<Products> p){
            this.products=p;
        }
}

       /* public static DataHolder getInstance() {return holder;}
        */
