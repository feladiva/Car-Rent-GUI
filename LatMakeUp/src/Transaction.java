import java.sql.Date;

public class Transaction {
	private String id;
	private Date date;
	public Transaction(String id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
