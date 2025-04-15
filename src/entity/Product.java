package entity;

public class Product {
	    int productId;
	    String productName;
	    String description;
	    double price;
	    int quantityInStock;
	    String type;
		
	public Product() {}
	public Product(int productId, String productName, String description, double price,
			int quantityInStock, String type ) {
		this.productId=productId;
		this.productName=productName;
		this.description = description;
		this.price=price;
		this.quantityInStock=quantityInStock;
		this.type=type;
	}
	public void setproductId(int productId) {
		this.productId=productId;
	}
	public int getproductId() {
		return productId;
	}
	public void setproductName(String productName) {
		this.productName=productName;
	}
	public String getproductName(){
		return productName;
	}
	public void setdescription(String description) {
		this.description=description;
	}
	public String getdescription() {
		return description;}


	public void setprice(double price) {
		this.price=price;
	}
	public double getprice() {
		return price;
	}
	public int getQuantityInStock() {
	    return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
	    this.quantityInStock = quantityInStock;
	}

	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}
	}



