package com.ingjsna.view;

import com.ingjsna.Product;
import com.ingjsna.dao.ProductDAO;
import com.ingjsna.dao.ProductDAOImpl;
import com.ingjsna.service.ProductService;
import com.ingjsna.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.jsf.FacesContextUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named("productBean")
@ViewScoped
public class ProductBean implements Serializable{

    private static final Logger logger = LoggerFactory.getLogger(ProductBean.class);

    @Inject()
    @Qualifier(value="productService")
    //@ManagedProperty("#{productService}")
    private ProductService service;

    private List<Product> products = Collections.emptyList();

    private Product newProduct = new Product();

    @PostConstruct
    public void init()  {
        products = service.listProducts();
        logger.error("Products: " + products.size());
    }

    public void createProduct(String name, String description){
        service.addProduct(newProduct);
    }

    public List<Product> getProducts() {
        logger.error("Get Products");
        return service.listProducts();
    }

    public ProductService getService() {
        return service;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public Product getNewProduct() {
        return newProduct;
    }
}
