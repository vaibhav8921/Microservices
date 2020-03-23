package com.molena.model;


public class Product {

 private Long id;
 private String name;
 private String brand;
 private String madein;
 private float price;

 public Product() {
 }


 public Long getId() {
     return id;
 }

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the brand
 */
public String getBrand() {
	return brand;
}

/**
 * @param brand the brand to set
 */
public void setBrand(String brand) {
	this.brand = brand;
}

/**
 * @return the madein
 */
public String getMadein() {
	return madein;
}

/**
 * @param madein the madein to set
 */
public void setMadein(String madein) {
	this.madein = madein;
}

/**
 * @return the price
 */
public float getPrice() {
	return price;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((brand == null) ? 0 : brand.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((madein == null) ? 0 : madein.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + Float.floatToIntBits(price);
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	if (brand == null) {
		if (other.brand != null)
			return false;
	} else if (!brand.equals(other.brand))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (madein == null) {
		if (other.madein != null)
			return false;
	} else if (!madein.equals(other.madein))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
		return false;
	return true;
}


/**
 * @param price the price to set
 */
public void setPrice(float price) {
	this.price = price;
}
 
@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", madein=" + madein + ", price=" + price
				+ "]";
	}
}