package rocket.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController implements Initializable {

	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgageAmt;
	@FXML TextField txtHouseCost;
	@FXML TextField txtTerms;
	@FXML TextField txtDownPayment;
	@FXML TextField txtIncome;
	@FXML TextField txtExpenses; //From word doc
	@FXML Label lblMortgagePayment;
	@FXML ComboBox<String> period;
	
	
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@Override //Taken from http://stackoverflow.com/questions/35260061/combobox-items-via-scene-builder
	public void initialize(URL location, ResourceBundle resources)
	{
		period.getItems().removeAll(period.getItems());
		period.getItems().addAll("15 Years", "30 Years");
		period.getSelectionModel().select("15 Years");
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
		LoanRequest loan = new LoanRequest();
		if (period.getValue() == "15 Years") {
			loan.setiTerm(15);
		}
		else if (period.getValue() == "30 Years") {
			loan.setiTerm(30);
		}
		
		//Setting the values when the button is pressed
		
		loan.setiCreditScore(Integer.parseInt(txtCreditScore.getText())); //need to put Integer before it to set as int
		loan.setdAmount(Integer.parseInt(txtHouseCost.getText()));
		loan.setdPayment(Integer.parseInt(txtDownPayment.getText()));
		loan.setIncome(Integer.parseInt(txtIncome.getText()));
		loan.setExpenses(Integer.parseInt(txtExpenses.getText()));
		mainApp.messageSend(loan);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double income = lRequest.getIncome();
		double samplepayment = lRequest.getdPayment();
		
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		
		if(((income/12)*.36)-lRequest.getExpenses()>samplepayment)
		{
			lblMortgagePayment.setText((String.format("%.2f", samplepayment)));
		}
	}
}
