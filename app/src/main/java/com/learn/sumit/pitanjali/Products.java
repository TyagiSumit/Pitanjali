package com.learn.sumit.pitanjali;

import android.media.Image;

public class Products {
    Integer product_id;
    String product_name;
    Integer product_stock;
    Double product_rate;

    public Products(Integer product_id, String product_name, Integer product_stock, Double product_rate) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_stock = product_stock;
        this.product_rate = product_rate;
    }
}
