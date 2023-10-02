import java.sql.Date;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static Database database = Database.getInstance();
	int ID = 0;
	Stage window;
	//loginScene
	VBox loginVB;
	GridPane loginGP;
	HBox loginHB, rbHB;
	Scene loginScene;
	Label loginLbl, emailLbl, passLbl;
	TextField emailTF;
	PasswordField pf;
	Button loginBtn, signupBtn;
	RadioButton kasirRB, adminRB;
	ToggleGroup roleTG;
	
	
	//stockMScene -- Admin
	Scene stockMScene;
	VBox stockMVB;
	GridPane stockMGP;
	HBox stockMHB;
	TableView<Product> prodTV;
	Vector<Product> prodV;
	Label prodIDLbl, prodNameLbl, prodDescLbl, priceLbl, qtyLbl;
	TextField prodIDTF, prodNameTF, prodDescTF, priceTF, qtyTF;
	Button insert, update, delete;
	

	Scene prScene;
	VBox prVB;
	GridPane prGP;
	Label idLbl;
	TextField idTF;
	Button prBtn;
	
	
	//orderScene
	Scene orderScene;
	VBox orderVB;
	HBox orderHB;
	GridPane inputGP;
	TableView<Product> prodOrderTV;
	TableView<Cart> cartTV;
	Vector<Cart> cartV;
	Label quantityLbl;
	Spinner<Integer> qtySP;
	Button orderBtn, addBtn, cancelBtn;
	
	
	
	//kasirScene
	Scene paymentScene;
	VBox paymentVB;
	HBox paymentHB;
	GridPane payGP;
	TableView<Product> paymentTV;
	TableView<Cart> paymentCartTV;
	Label totalPriceLbl, paymentLbl;
	ComboBox<String> paymentCB;
	Button payBtn;
	TextField totalPriceTF;
	
	MenuBar mainMenuBar;
	Menu menu;
	MenuItem payment, report, order;
	
	Scene reportScene;
	HBox reportHB;
	TableView<Transaction> trTV;
	TableView<Product> trProdTV;
	Vector<Transaction> trV;
	
	
	
	public void initialize () {
		//login
		loginVB = new VBox();
		loginGP = new GridPane();
		loginHB = new HBox();
		loginScene = new Scene(loginVB, 320, 280);
		loginLbl = new Label("Login");
		emailLbl = new Label("Email");
		passLbl = new Label("Password");
		emailTF = new TextField();
		pf = new PasswordField();
		loginBtn = new Button("Login");
		signupBtn = new Button("Sign Up");
		adminRB = new RadioButton("Admin");
		kasirRB = new RadioButton("Kasir");
		rbHB = new HBox();
		roleTG = new ToggleGroup();
		
		//stockManagementScene
		stockMVB = new VBox();
		stockMGP = new GridPane();
		stockMHB = new HBox();
		stockMScene = new Scene(stockMVB, 520, 420);
		
		prodTV = new TableView<>();
		prodV = new Vector<>();
		prodTV.setMaxHeight(200);
		prodNameLbl = new Label("Name");
		prodDescLbl = new Label("Description");
		priceLbl = new Label("Price");
		qtyLbl = new Label("Stock");
		prodNameTF = new TextField();
		prodDescTF = new TextField();
		priceTF = new TextField();
		qtyTF = new TextField();
		insert = new Button("Insert");
		update = new Button("Update");
		delete = new Button("Delete");
		
		
		prVB = new VBox();
		prGP = new GridPane();
		prScene = new Scene(prVB, 320, 220);
		idLbl = new Label("Nomor Identitas");
		idTF = new TextField();
		prBtn = new Button("Order");
	
		//orderScene
		orderVB = new VBox();
		orderHB = new HBox();
		orderScene = new Scene(orderHB, 620, 520);
		prodOrderTV = new TableView<>();
		cartTV = new TableView<>();
		inputGP = new GridPane();
		qtySP = new Spinner<>(1,999,1);
		addBtn = new Button("Add");
		cancelBtn = new Button("Cancel");
		orderBtn = new Button("Order");
		quantityLbl = new Label("Quantity");
		cartV = new Vector<>();
		
		
		
		
		
		//kasirScene
		paymentVB = new VBox();
		paymentHB = new HBox();
		payGP = new GridPane();
		paymentScene = new Scene(paymentHB, 620, 520);
		mainMenuBar = new MenuBar();
		menu = new Menu("Menu");
		payment = new MenuItem("Payment");
		report = new MenuItem("Total Sales Report");
		order = new MenuItem("Order");
		paymentTV = new TableView<>();
		paymentCartTV = new TableView<>();
		totalPriceLbl = new Label("Total Price");
		paymentLbl = new Label("Payment Method");
		totalPriceTF = new TextField();
		paymentCB = new ComboBox<>();
		paymentCB.getItems().add("Debit");
		paymentCB.getItems().add("Cash");
		paymentCB.getItems().add("QRIS");
		paymentCB.getSelectionModel().selectFirst();
		payBtn = new Button("Pay");
		
		reportHB = new HBox();
		reportScene = new Scene(reportHB, 620, 520);
		
		trTV = new TableView<>();
		trProdTV = new TableView<>();
		trV = new Vector<>();
	
		
	}
	
	public void position() {
		loginGP.add(emailLbl, 0, 2);
		loginGP.add(loginLbl, 1, 0);
		loginGP.add(passLbl, 0, 3);
		loginGP.add(emailTF, 1, 2);
		loginGP.add(pf, 1, 3);
		loginLbl.setFont(Font.font("", FontWeight.BOLD, 24));
		loginHB.getChildren().addAll(loginBtn, signupBtn);
		rbHB.getChildren().addAll(adminRB, kasirRB);
		adminRB.setToggleGroup(roleTG);
		kasirRB.setToggleGroup(roleTG);
		loginVB.getChildren().addAll(loginGP, rbHB, loginHB);
		loginGP.setAlignment(Pos.CENTER);
		loginHB.setAlignment(Pos.CENTER);
		rbHB.setAlignment(Pos.CENTER);
		loginVB.setSpacing(35);
		loginGP.setVgap(15);
		loginGP.setHgap(10);
		loginHB.setSpacing(10);
		rbHB.setSpacing(10);
		loginVB.setStyle("-fx-background-color: #c8efd7");
		
		//prScene
		prGP.add(idLbl, 0, 1);
		prGP.add(idTF, 1, 1);
		prVB.getChildren().addAll(prGP, prBtn);
		prGP.setAlignment(Pos.CENTER);
		prGP.setVgap(15);
		prGP.setHgap(15);
		prVB.setSpacing(40);
		prVB.setAlignment(Pos.CENTER);
		prVB.setStyle("-fx-background-color: #c8efd7");
		
		//orderScene
		inputGP.add(quantityLbl, 0, 1);
		inputGP.add(qtySP, 1, 1);
		inputGP.add(orderBtn, 1, 3);
		inputGP.add(addBtn, 1, 2);
		inputGP.add(cancelBtn, 2, 2);
		menu.getItems().addAll(payment, report);
		orderVB.getChildren().addAll(mainMenuBar, cartTV, inputGP);
		orderHB.getChildren().addAll(orderVB, prodOrderTV);
		inputGP.setAlignment(Pos.CENTER);
		inputGP.setHgap(10);
		inputGP.setVgap(10);
		
		//stockMScene
		stockMGP.add(prodNameLbl, 0, 0);
		stockMGP.add(prodDescLbl, 0, 1);
		stockMGP.add(priceLbl, 0, 2);
		stockMGP.add(qtyLbl, 0, 3);
		stockMGP.add(prodNameTF, 1, 0);
		stockMGP.add(prodDescTF, 1, 1);
		stockMGP.add(priceTF, 1, 2);
		stockMGP.add(qtyTF, 1, 3);
		stockMHB.getChildren().addAll(insert, update, delete);
		stockMVB.getChildren().addAll(prodTV, stockMGP, stockMHB);
		stockMGP.setAlignment(Pos.CENTER);
		stockMHB.setAlignment(Pos.CENTER);
		stockMVB.setSpacing(35);
		stockMGP.setVgap(10);
		stockMGP.setHgap(10);
		stockMHB.setSpacing(15);
		
		//paymentScene
		payGP.add(totalPriceLbl, 0, 1);
		payGP.add(totalPriceTF, 1, 1);
		payGP.add(paymentCB, 1, 2);
		payGP.add(payBtn, 1, 3);
		payGP.add(paymentLbl, 0, 2);
		mainMenuBar.getMenus().addAll(menu);
		paymentVB.getChildren().addAll(paymentCartTV, payGP);
		paymentHB.getChildren().addAll(paymentVB, paymentTV);
		payGP.setAlignment(Pos.CENTER);
		payGP.setHgap(15);
		payGP.setVgap(10);
		
		payment.setOnAction(e -> {
			window.setScene(paymentScene);
		});
		
		report.setOnAction(e -> {
			window.setScene(reportScene);
		});
		
		order.setOnAction(e -> {
			window.setScene(orderScene);
		});
		
		reportHB.getChildren().addAll(trTV, trProdTV);
		
		
	}
	
	public void setTrTable () {

		TableColumn<Transaction, String> idCol = new TableColumn<Transaction, String>("Transaction ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Transaction, Date> dateCol = new TableColumn<Transaction, Date>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("tr_date"));
		
		trTV.getColumns().addAll(idCol, dateCol);
		trTV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
	
	public void setTrProdTable () {
		TableColumn<Product, Integer> idCol = new TableColumn<Product, Integer>("Product ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		
		TableColumn<Product, String> nameCol = new TableColumn<Product, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("prodName"));
		
		TableColumn<Product, String> descCol = new TableColumn<Product, String>("Description");
		descCol.setCellValueFactory(new PropertyValueFactory<>("prodDescription"));
		
		TableColumn<Product, Integer> priceCol = new TableColumn<Product, Integer>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Product, Integer> qtyCol = new TableColumn<Product, Integer>("Quantity");
		qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
		
		trProdTV.getColumns().addAll(idCol, nameCol, descCol, priceCol, qtyCol);
		trProdTV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
	}
	
	public void setProdOrderTable () {
		TableColumn<Product, Integer> idCol = new TableColumn<Product, Integer>("Product ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		
		TableColumn<Product, String> nameCol = new TableColumn<Product, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("prodName"));
		
		TableColumn<Product, String> descCol = new TableColumn<Product, String>("Description");
		descCol.setCellValueFactory(new PropertyValueFactory<>("prodDescription"));
		
		TableColumn<Product, Integer> priceCol = new TableColumn<Product, Integer>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Product, Integer> qtyCol = new TableColumn<Product, Integer>("Stock");
		qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
		
		prodOrderTV.getColumns().addAll(idCol, nameCol, descCol, priceCol, qtyCol);
		prodOrderTV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
	}
	
	public void setPaymentTable () {
		TableColumn<Product, Integer> idCol = new TableColumn<Product, Integer>("Product ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		
		TableColumn<Product, String> nameCol = new TableColumn<Product, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("prodName"));
		
		TableColumn<Product, String> descCol = new TableColumn<Product, String>("Description");
		descCol.setCellValueFactory(new PropertyValueFactory<>("prodDescription"));
		
		TableColumn<Product, Integer> priceCol = new TableColumn<Product, Integer>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Product, Integer> qtyCol = new TableColumn<Product, Integer>("Stock");
		qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
		
		paymentTV.getColumns().addAll(idCol, nameCol, descCol, priceCol, qtyCol);
		paymentTV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
	}
	
	
	public void setCartTable () {

		TableColumn<Cart, Integer> idCol = new TableColumn<Cart, Integer>("Product ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("product_id"));
		
		TableColumn<Cart, Integer> qtyCol = new TableColumn<Cart, Integer>("Quantity");
		qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		cartTV.getColumns().addAll(idCol, qtyCol);
		cartTV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
	
	public void setPaymentCartTable () {

		TableColumn<Cart, Integer> idCol = new TableColumn<Cart, Integer>("Product ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("product_id"));
		
		TableColumn<Cart, Integer> qtyCol = new TableColumn<Cart, Integer>("Quantity");
		qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		paymentCartTV.getColumns().addAll(idCol, qtyCol);
		paymentCartTV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
	
	
	public void setProdTable () {
		
		TableColumn<Product, Integer> idCol = new TableColumn<Product, Integer>("Produt ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		
		TableColumn<Product, String> nameCol = new TableColumn<Product, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("prodName"));
		
		TableColumn<Product, String> descCol = new TableColumn<Product, String>("Description");
		descCol.setCellValueFactory(new PropertyValueFactory<>("prodDescription"));
		
		TableColumn<Product, Integer> priceCol = new TableColumn<Product, Integer>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Product, Integer> qtyCol = new TableColumn<Product, Integer>("Stock");
		qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
		
		prodTV.getColumns().addAll(idCol, nameCol, descCol, priceCol, qtyCol);
		prodTV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		prodTV.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				TableSelectionModel<Product> tableSelectionModel = prodTV.getSelectionModel();
				tableSelectionModel.setSelectionMode(SelectionMode.SINGLE);
				Product product = tableSelectionModel.getSelectedItem();
				int prodID = product.getProdID();
				String prodName = product.getProdName();
				String prodDescription = product.getProdDescription();
				int price = product.getPrice();
				int qty = product.getQty();
				
				ID = prodID;
				prodNameTF.setText(prodName);
				prodDescTF.setText(prodDescription);
				priceTF.setText(Integer.toString(price));
				qtyTF.setText(Integer.toString(qty));
				
			}
		});
		
		
	}
	
	public void inputProdTable () {
		String query = "SELECT * FROM ms_product";
		database.rs = database.execQuery(query);
		try {
			 while (database.rs.next()) {
				 int prodID = database.rs.getInt("prodID");
				String prodName = database.rs.getString("prodName");
				String prodDescription = database.rs.getString("prodDescription");
				 int price = database.rs.getInt("price");
				 int qty = database.rs.getInt("qty");
				 
				 prodTV.getItems().add(new Product(prodID, prodName, prodDescription, price, qty));
				 prodV.add(new Product(prodID, prodName, prodDescription, price, qty));
				 prodOrderTV.getItems().add(new Product(prodID, prodName, prodDescription, price, qty));
				 paymentTV.getItems().add(new Product(prodID, prodName, prodDescription, price, qty));
				 trProdTV.getItems().add(new Product(prodID, prodName, prodDescription, price, qty));
			
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inputTrTable () {
		String query = "SELECT * FROM transaction_header";
		database.rs = database.execQuery(query);
		try {
			 while (database.rs.next()) {
				String id = database.rs.getString("id");
				Date date = database.rs.getDate("tr_date");
				trTV.getItems().add(new Transaction(id, date));
				trV.add(new Transaction(id, date));
			
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void inputCartTable () {
		String query = "SELECT * FROM ms_cart";
		database.rs = database.execQuery(query);
		try {
			 while (database.rs.next()) {
				 Product p = prodOrderTV.getSelectionModel().getSelectedItem();
				 
				cartTV.getItems().add(new Cart(null, p.getProdID(), qtySP.getValue()));
				cartV.add(new Cart(null, p.getProdID(), qtySP.getValue()));
				paymentCartTV.getItems().add(new Cart(null, p.getProdID(), qtySP.getValue()));

			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void insertProd (String prodName, String prodDescription, int price, int qty) {
		String query = String.format("INSERT INTO ms_product(prodName, prodDescription, price, qty)"
				+ "VALUES ('%s', '%s', %s, %s)", prodName, prodDescription, price, qty);
		database.execUpdate(query);
	}
	
	public void updateProd (String prodName, String prodDescription, int price, int qty) {
		String query = String.format("UPDATE ms_product\n" 
				+ "SET prodName = '%s', prodDescription = '%s', price = %s, qty = %s\n"
				+ "WHERE prodID = %s", prodName, prodDescription, price, qty, ID);
		database.execUpdate(query);
		
	}
	
	public void deleteProd (int prodID) {
		String query = String.format("DELETE FROM ms_product\n"
				+ "WHERE prodID = %s", prodID);
		database.execUpdate(query);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		window = arg0;
		initialize();
		position();
		setProdTable();
		setProdOrderTable();
		setCartTable();
		setPaymentCartTable();
		setPaymentTable();
		inputProdTable();
		setTrProdTable();
		setTrTable();
		inputTrTable();
		loginBtn.setOnAction(e -> {
			
			String emailInput = emailTF.getText();
			String pwInput = pf.getText();
			
			String queryEmail = "SELECT * FROM ms_customer WHERE email LIKE '" + emailInput + "'";
			database.rs = database.execQuery(queryEmail);
			
			if(emailInput.isEmpty() || pwInput.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR, "Please fill the empty field");
				alert.showAndWait();
			}else {
				try {
					if(!database.rs.next()) {
						Alert alert = new Alert(AlertType.ERROR, "Email doesn't exist!");
						alert.showAndWait();
					}else {
						String pw = database.rs.getString("password");
						
						if(!pwInput.equals(pw)) {
							Alert alert = new Alert(AlertType.ERROR, "Password doesn't match!");
							alert.showAndWait();
						}else {
							Alert alert = new Alert(AlertType.INFORMATION, "Sign In Success!");
							alert.showAndWait();
							if (roleTG.getSelectedToggle().equals(kasirRB)) {
								window.setScene(prScene);
							} else if (roleTG.getSelectedToggle().equals(adminRB)) {
								window.setScene(stockMScene);
							}
							
						}
					}
				}catch (Exception e1){
					
				}
			}
		});
		
		insert.setOnAction(new EventHandler<ActionEvent>() {
			Alert a = new Alert(AlertType.NONE);
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (prodNameTF.getText().toString().equals("")) {
					a.setAlertType(AlertType.ERROR);
					a.setContentText("Name must be filled!");
					a.showAndWait();
				} else {
					String prodName = prodNameTF.getText().toString();
					String prodDescription = prodDescTF.getText().toString();
					int price = Integer.parseInt(priceTF.getText().toString());
					int qty = Integer.parseInt(qtyTF.getText().toString());
					
					insertProd(prodName, prodDescription, price, qty);
					prodTV.getItems().clear();
					inputProdTable();
					
					prodNameTF.setText("");
					prodDescTF.setText("");
					priceTF.setText("");
					qtyTF.setText("");
					
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Insert Success!");
					a.showAndWait();
				}
			}
		});
			

		update.setOnAction(new EventHandler<ActionEvent>() {
			Alert a = new Alert(AlertType.NONE);
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (prodNameTF.getText().toString().equals("")) {
					a.setAlertType(AlertType.ERROR);
					a.setContentText("Name must be filled!");
					a.showAndWait();
				} else {
					String prodName = prodNameTF.getText().toString();
					String prodDescription = prodDescTF.getText().toString();
					int price = Integer.parseInt(priceTF.getText().toString());
					int qty = Integer.parseInt(qtyTF.getText().toString());
					
					updateProd(prodName, prodDescription, price, qty);
					prodTV.getItems().clear();
					inputProdTable();
					
					prodNameTF.setText("");
					prodDescTF.setText("");
					priceTF.setText("");
					qtyTF.setText("");
					
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Update Success!");
					a.showAndWait();
				}
			}
		});
		

		delete.setOnAction(new EventHandler<ActionEvent>() {
			Alert a = new Alert(AlertType.NONE);
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (prodNameTF.getText().toString().equals("")) {
					a.setAlertType(AlertType.ERROR);
					a.setContentText("Name must be filled!");
					a.showAndWait();
				} else {
					String prodName = prodNameTF.getText().toString();
					String prodDescription = prodDescTF.getText().toString();
					int price = Integer.parseInt(priceTF.getText().toString());
					int qty = Integer.parseInt(qtyTF.getText().toString());
					
					deleteProd(ID);
					prodTV.getItems().clear();
					inputProdTable();
					
					prodNameTF.setText("");
					prodDescTF.setText("");
					priceTF.setText("");
					qtyTF.setText("");
					
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Delete Success!");
					a.showAndWait();
				}
			}
		});
		
		
		prBtn.setOnAction(e -> {
			window.setScene(orderScene);
		});
		
		addBtn.setOnAction(e -> {
			
			inputCartTable();	
			
		});
		
		orderBtn.setOnAction(e -> {
			Alert a = new Alert(AlertType.NONE);
			a.setAlertType(AlertType.INFORMATION);
			a.setContentText("Order Success!");
			a.showAndWait();
		});
		
		payBtn.setOnAction(e -> {
			Alert a = new Alert(AlertType.NONE);
			a.setAlertType(AlertType.INFORMATION);
			a.setContentText("Pay Success!");
			a.showAndWait();
		});
		
		cancelBtn.setOnAction(e -> {
			
			String query = "SELECT * FROM ms_cart";
			database.rs = database.execQuery(query);
			try {
				 while (database.rs.next()) {
					 Product p = prodOrderTV.getSelectionModel().getSelectedItem();
					 
					cartTV.getItems().clear();
					paymentCartTV.getItems().clear();

				 }
			} catch (Exception e1) {
				// TODO: handle exception
			}
		});
		
		window.setTitle("Makeup");
		window.setScene(loginScene);
		window.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
