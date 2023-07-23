package com.java8feature;

import java.util.ArrayList;
import java.util.List;

public class FilterProductObject {

    public static void main(String[] args){

        List<Product> productData=new ArrayList<Product>();
        productData.add(new Product(1,"Hp",25000));
        productData.add(new Product(2,"Hp",29000));
        productData.add(new Product(3,"Lenovo",42000));
        //I want to display the prouctprice is greter than 29000 those recored will be retrived
        productData.stream().filter(f->f.prise>29000).forEach(r->System.out.println(r.id+" "+r.name+" "+r.prise));
    }
}
