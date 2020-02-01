package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private ObservableList<Person> personData = FXCollections.observableArrayList();


    public MainApp() {
        // ������ �߰�
    	personData.add(new Person("��", "����","��ǻ�Ͱ��а�",201533004,"����","1.PNG"));
        personData.add(new Person("��", "����","��ǻ�Ͱ��а�",201533025,"��õ","2.PNG"));
        personData.add(new Person("��", "����","��ǻ�Ͱ��а�",201533003,"����","4.PNG"));
        personData.add(new Person("��", "����","��ǻ�Ͱ��а�",201533008,"�ǿ�","5.PNG"));
        personData.add(new Person("��", "����","��ǻ�Ͱ��а�",201533023,"����","7.PNG"));
        personData.add(new Person("��", "��ȫ","��ǻ�Ͱ��а�",201333012,"��õ","6.PNG"));
        personData.add(new Person("��", "����","��ǻ�Ͱ��а�",201533009,"�д�","8.PNG"));
        personData.add(new Person("��", "����","��ǻ�Ͱ��а�",201533000,"����","3.PNG"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("�л���Ϻ� ���α׷�");

        initRootLayout();

        showPersonOverview();
    }

    //�������̾ƿ� �ʱ�ȭ
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("root.fxml"));
            rootLayout = (BorderPane) loader.load();


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Show.fxml"));
            AnchorPane show = (AnchorPane) loader.load();

            rootLayout.setCenter(show);
            ShowController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}