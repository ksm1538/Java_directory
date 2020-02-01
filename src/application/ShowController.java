package application;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import application.Person;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import application.MainApp;
import application.Person;

public class ShowController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label majorLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private ImageView imageview;
    //MainApp ����
    private MainApp mainApp;
   
	private void showPersonDetails(Person person) {
        if (person != null) {
            
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            majorLabel.setText(person.getmajor());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());

        } else {
            
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            majorLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
        }
    }
    public ShowController() {
    }
    /**
     * ��Ʈ�ѷ� Ŭ������ �ʱ�ȭ�Ѵ�.
     * fxml ������ �ε�ǰ� ���� �ڵ����� ȣ��ȴ�.
     */
   
    @FXML
    private void initialize() {
    	
        // ����ó ���̺��� �� �� �ʱ�ȭ
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());
        
        personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
    		@Override
    		public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
    			if(newValue!=null) {
    				imageview.setImage(new Image(getClass().getResource("images/" + newValue.getImage()).toString()));
    			}
    		}
    	});
        // ���� ����
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
        
        
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // ���̺� observable ����Ʈ �����͸� �߰�
        personTable.setItems(mainApp.getPersonData());
    }

}