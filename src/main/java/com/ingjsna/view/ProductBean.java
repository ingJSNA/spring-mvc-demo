package com.ingjsna.view;

import com.ingjsna.Product;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductBean {

    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }
}
