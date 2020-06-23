package com.nhatpoly.NhatAssignment5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer productid;
	@Column(name = "name", columnDefinition = "nvarchar(255)")
	private String name;
	private String image;
	@Column(name="quantity")
	private int quantity;
	private int price;
	private String status;

public Product() {

}


    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Product(String name, String image, int quantity, int price, String status) {

        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}








}
