package Database.Controller;

import Database.Connector.ConnectionClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MainStageController implements Initializable {

    @FXML
    JFXButton btnLogin,btnUser, btnSignUp,btnBell, btnSearch;
    public String UserID = "None";
    @FXML
    JFXTextField txtSearch;
    @FXML
    AnchorPane mainStage;
    @FXML
    Statement statement;
    String sql;
    @FXML
    Label lblNoResult;
    @FXML
    JFXListView<Label> searchResult,subscribedChannel;

    public void setUserID(String userID) {
        UserID = userID;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnLogin.setOnMouseClicked(actionEvent -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/LoginScreen.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 450, 300));
                stage.show();
                LoginScreenController controller = fxmlLoader.getController();
                stage.setOnHidden(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {

                        UserID = controller.UserID;
                        System.out.println(UserID);
                        if (!UserID.equals("None")) {
                            btnLogin.setDisable(true);
                            btnSignUp.setDisable(true);
                            btnLogin.setVisible(false);
                            btnSignUp.setVisible(false);
                            btnBell.setDisable(false);
                            btnUser.setDisable(false);
                            btnBell.setVisible(true);
                            btnUser.setVisible(true);
                            ConnectionClass connectionClass = new ConnectionClass();
                            Connection con = connectionClass.getConnection();

                            try{
                                sql = "CALL show_ChannelSubcribe(" + UserID + ",@a);";
                                statement = con.createStatement();
                                ResultSet resultSet1 = statement.executeQuery(sql);
                                while (resultSet1.next()) {
                                    System.out.println(resultSet1.getString(2));
                                    Label lbl = new Label(resultSet1.getString(2));
                                    lbl.setId("U"+resultSet1.getString(1));
                                    lbl.setGraphic(new ImageView(new Image(new FileInputStream("D:/Study/DB/src/Database/img/User.png"))));
                                    subscribedChannel.getItems().add(lbl);
                                }
                                subscribedChannel.setVisible(true);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

    public void onbtnLoginClicked(MouseEvent mouseEvent) {
    }

    public void onbtnSignUpClicked(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/SignupScreen.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 450, 300));
            stage.show();

        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public void onbtnUserClicked(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/User.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            UserController controller = fxmlLoader.getController();
            System.out.println(controller);
            controller.setUserID(UserID);
            mainStage.getChildren().setAll(root);
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onbtnSearchClicked(MouseEvent mouseEvent) {
        if(txtSearch.getText() != null) {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection con = connectionClass.getConnection();
            try {
                sql = "CALL search_user('" + txtSearch.getText() + "');";
                statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                String sql1 = "CALL search_video('" + txtSearch.getText() + "');";
                Statement statement1 = con.createStatement();
                ResultSet resultSet1 = statement1.executeQuery(sql1);
                if(!resultSet.next() && !resultSet1.next()) lblNoResult.setVisible(true);
                searchResult.setVisible(true);
                searchResult.setDisable(false);
                while (resultSet.next()) {
                    String a = resultSet.getString(3) ;
                    if (a == null) {
                        a = "0";
                    }
                    System.out.println(resultSet.getString(2));
                    Label lbl = new Label(resultSet.getString(2)+ " - " + a + " người đăng ký");
                    lbl.setId("U"+resultSet.getString(1));
                    lbl.setGraphic(new ImageView(new Image(new FileInputStream("D:/Study/DB/src/Database/img/User.png"))));
                    searchResult.getItems().add(lbl);
                }
                while (resultSet1.next()) {
                    String a = resultSet1.getString(4) ;
                    if (a == null) {
                        a = "0";
                    }
                    System.out.println(resultSet1.getString(2));
                    Label lbl = new Label(resultSet1.getString(2)+ " \n" +resultSet1.getString(3)+" - " + a + " lượt xem");
                    lbl.setId("V"+resultSet1.getString(1));
                    lbl.setGraphic(new ImageView(new Image(new FileInputStream("D:/Study/DB/src/Database/img/YoutubeVN.png"))));
                    searchResult.getItems().add(lbl);
                }
            } catch (SQLException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickedListView(MouseEvent mouseEvent) {
        ListView<Label> list = (ListView<Label>) mouseEvent.getSource();
        list.setCellFactory(tv->{
            ListCell<Label> cell = new ListCell<>();
            cell.setOnMouseClicked(event ->{
                if ( !cell.isEmpty()) {
                    Label cellData = cell.getItem();
                    try {
                        String CellID = cellData.getId();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/OtherUser.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        //Get controller of scene2
                        System.out.println(CellID);
                        System.out.println(UserID);
                        OtherUserController inputController = fxmlLoader.getController();
                        //Pass whatever data you want. You can have multiple method calls here
                        inputController.setOtherUserID(CellID.substring(1,CellID.length()));
                        inputController.setUserID(UserID);
                        mainStage.getChildren().setAll(root);
                        AnchorPane.setTopAnchor(root, 0.0);
                        AnchorPane.setBottomAnchor(root, 0.0);
                        AnchorPane.setLeftAnchor(root, 0.0);
                        AnchorPane.setRightAnchor(root, 0.0);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return cell;
        });
    }
    int i =0;
    public void onMouseMoved(MouseEvent mouseEvent) {

        if (!UserID.equals("None")&& i<1) {
            i++;
            subscribedChannel.getItems().clear();
            btnLogin.setDisable(true);
            btnSignUp.setDisable(true);
            btnLogin.setVisible(false);
            btnSignUp.setVisible(false);
            btnBell.setDisable(false);
            btnUser.setDisable(false);
            btnBell.setVisible(true);
            btnUser.setVisible(true);
            ConnectionClass connectionClass = new ConnectionClass();
            Connection con = connectionClass.getConnection();

            try{
                sql = "CALL show_ChannelSubcribe(" + UserID + ",@a);";
                statement = con.createStatement();
                ResultSet resultSet1 = statement.executeQuery(sql);
                while (resultSet1.next()) {
                    System.out.println(resultSet1.getString(2));
                    Label lbl = new Label(resultSet1.getString(2));
                    lbl.setId("U"+resultSet1.getString(1));
                    lbl.setGraphic(new ImageView(new Image(new FileInputStream("D:/Study/DB/src/Database/img/User.png"))));
                    subscribedChannel.getItems().add(lbl);
                }
                subscribedChannel.setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
