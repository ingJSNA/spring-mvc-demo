package com.ingjsna.view;

import com.ingjsna.Product;
import com.ingjsna.dao.ProductDAO;
import com.ingjsna.dao.ProductDAOImpl;
import com.ingjsna.service.ProductService;
import com.ingjsna.service.ProductServiceImpl;
import org.primefaces.event.RowEditEvent;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class ProductBean {

    private static final Logger logger = LoggerFactory.getLogger(ProductBean.class);

    @Inject()
    @Qualifier(value="productService")
    private ProductService service;

    private List<Product> products = new ArrayList<>();

    private Product newProduct = new Product();

    @PostConstruct
    public void init()  {
        products = service.listProducts();

        logger.error("Products: " + products.size());
    }

    public void createProduct(){
        service.addProduct(newProduct);
        newProduct = new Product();
    }
    public void onRowEdit(RowEditEvent<Product> event) {
        Product product = event.getObject();
        service.updateProduct(product);

        FacesMessage msg = new FacesMessage("Producto editado", String.valueOf(product.getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void remove(Product product){
        service.removeProduct(product.getId());
    }

    public List<Product> getProducts() {
        return products;
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
