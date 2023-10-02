
public class Product{
	private int prodID;
	private String prodName;
	private String prodDescription;
	private int price;
	private int qty;
	public Product(int prodID, String prodName, String prodDescription, int price, int qty) {
		super();
		this.prodID = prodID;
		this.prodName = prodName;
		this.prodDescription = prodDescription;
		this.price = price;
		this.qty = qty;
	}
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
