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
        // 데이터 추가
    	personData.add(new Person("김", "성목","컴퓨터과학과",201533004,"오산","1.PNG"));
        personData.add(new Person("임", "지인","컴퓨터과학과",201533025,"인천","2.PNG"));
        personData.add(new Person("김", "서해","컴퓨터과학과",201533003,"서울","4.PNG"));
        personData.add(new Person("김", "정연","컴퓨터과학과",201533008,"의왕","5.PNG"));
        personData.add(new Person("이", "지수","컴퓨터과학과",201533023,"서울","7.PNG"));
        personData.add(new Person("김", "지홍","컴퓨터과학과",201333012,"인천","6.PNG"));
        personData.add(new Person("김", "정헌","컴퓨터과학과",201533009,"분당","8.PNG"));
        personData.add(new Person("박", "재현","컴퓨터과학과",201533000,"광주","3.PNG"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("학생기록부 프로그램");

        initRootLayout();

        showPersonOverview();
    }

    //상위레이아웃 초기화
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