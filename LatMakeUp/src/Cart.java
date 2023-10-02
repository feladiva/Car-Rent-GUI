
public class Cart {
	private String cust_id;
	private Integer product_id;
	private Integer quantity;
	public Cart(String cust_id, Integer product_id, Integer quantity) {
		super();
		this.cust_id = cust_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
