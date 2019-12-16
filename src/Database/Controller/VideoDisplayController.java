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

public class VideoDisplayController implements Initializable {
    @FXML
    JFXButton btnLogin,btnUser, btnSignUp, btnBell, btnSearch, btnLike, btnDisLike, btnCmt, btnCancel, btnAuthor,btnMain;
    @FXML
    JFXButton btnSubscribe, btnLater;
    public String UserID = "None";
    Statement statement;
    String sql;
    @FXML
    JFXTextField txtSearch,txtCmt;
    @FXML
    Label lblNoResult;
    @FXML
    AnchorPane mainStage;
    @FXML
    JFXListView<Label> searchResult;
    String VideoID="None";

    public void setUserID(String userID) {
        UserID = userID;
    }

    public void setVideoID(String videoID) {
        VideoID = videoID;
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
                        }
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        txtCmt.setOnMouseClicked(actionEvent ->{
            if (UserID == "None"){
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
                            }
                        }
                    });
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                btnCancel.setVisible(true);
                btnCmt.setVisible(true);
                btnCancel.setDisable(false);
                btnCmt.setDisable(false);
            }

        });
        btnCancel.setOnMouseClicked(actionEvent ->{
            btnCancel.setVisible(false);
            btnCmt.setVisible(false);
            btnCancel.setDisable(true);
            btnCmt.setDisable(true);
            txtCmt.clear();
        });
        btnCmt.setOnMouseClicked(actionEvent ->{
            ConnectionClass connectionClass = new ConnectionClass();
            Connection con = connectionClass.getConnection();
            if(txtCmt.getText()!=null){
                try {
                    sql = "Call pressComment(" + UserID + "," + VideoID + ",'" + txtCmt.getText() + "');";
                    statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    listCmt.getItems().clear();
                    sql = "CALL show_Comment("+VideoID+");";
                    statement = con.createStatement();
                    ResultSet resultSet2 =statement.executeQuery(sql);
                    while(resultSet2.next()){
                        Label lbl = new Label(resultSet2.getString(1) + " \n"+resultSet2.getString(4));
                        lbl.setGraphic(new ImageView(new Image(new FileInputStream("D:/Study/DB/src/Database/img/User.png"))));
                        listCmt.getItems().add(lbl);
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnMain.setOnMouseClicked(actionEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/MainStage.fxml"));
                Parent root = (Parent)fxmlLoader.load();
                MainStageController inputController = fxmlLoader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                inputController.setUserID(UserID);
                mainStage.getChildren().setAll(root);
                AnchorPane.setTopAnchor(root, 0.0);
                AnchorPane.setBottomAnchor(root, 0.0);
                AnchorPane.setLeftAnchor(root, 0.0);
                AnchorPane.setRightAnchor(root, 0.0);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        btnLike.setOnMouseClicked(a ->{
            if (UserID == "None") {
                try {
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
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                ConnectionClass connectionClass = new ConnectionClass();
                Connection con = connectionClass.getConnection();
                try {
                    sql = "Call pressLikeorDislikeObject(" + UserID + "," + VideoID + ",1,@a);";
                    statement = con.createStatement();
                    statement.executeQuery(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int b = Integer.parseInt(btnLike.getText()) + 1;
                btnLike.setText(b + "");
                if (btnDisLike.isDisable()) {
                    b = Integer.parseInt(btnDisLike.getText()) - 1;
                    btnDisLike.setText(b + "");
                }
                btnDisLike.setDisable(false);
                btnLike.setDisable(true);
            }
        });
        btnDisLike.setOnMouseClicked(a ->{
            if (UserID == "None") {
                try {
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
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                ConnectionClass connectionClass = new ConnectionClass();
                Connection con = connectionClass.getConnection();
                try {
                    sql = "Call pressLikeorDislikeObject(" + UserID + "," + VideoID + ",0,@a);";
                    statement = con.createStatement();
                    statement.executeQuery(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int b = Integer.parseInt(btnDisLike.getText()) + 1;
                btnDisLike.setText(b + "");
                if (btnLike.isDisable()) {
                    b = Integer.parseInt(btnLike.getText()) - 1;
                    btnLike.setText(b + "");
                }
                btnLike.setDisable(false);
                btnDisLike.setDisable(true);
            }
        });
        btnLater.setOnMouseClicked(act ->{
            if (UserID == "None") {
                try {
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
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                ConnectionClass connectionClass = new ConnectionClass();
                Connection con = connectionClass.getConnection();
                try {
                    sql = "Call addVideotoLater(" + UserID + "," + VideoID + ",@a);";
                    statement = con.createStatement();
                    statement.executeQuery(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                btnLater.setDisable(true);
            }
        });
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
    @FXML
    Label lblVidName,lblViewCount,lblCmtNum;
    @FXML
    ListView<Label> listCmt;
    int i =0;
    public void onMouseMoved(MouseEvent mouseEvent) throws SQLException, FileNotFoundException {
        if(i<1){
            i++;
            ConnectionClass connectionClass = new ConnectionClass();
            Connection con = connectionClass.getConnection();

            String PublisherID = "None";
            String Time = " ";
            try {
                sql = "SELECT UserID,Time FROM object WHERE ID = " + VideoID + ";";
                statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    PublisherID = resultSet.getString(1);
                    Time = resultSet.getString(2);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            if (UserID != "None" ) {
                btnLogin.setDisable(true);
                btnSignUp.setDisable(true);
                btnLogin.setVisible(false);
                btnSignUp.setVisible(false);
                btnBell.setDisable(false);
                btnUser.setDisable(false);
                btnBell.setVisible(true);
                btnUser.setVisible(true);

                try {

                    sql = "SELECT * FROM Subcribe WHERE SubcriberID = " + UserID + ";";
                    statement = con.createStatement();
                    ResultSet resultSet1 = statement.executeQuery(sql);
                    while (resultSet1.next()) {
                        if (PublisherID.equals(resultSet1.getString(1))) {
                            btnSubscribe.setText("ĐÃ ĐĂNG KÝ");
                            btnSubscribe.setDisable(true);
                            break;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            sql = "CALL Video_detail("+VideoID+");";
            statement = con.createStatement();
            ResultSet resultSet1 =statement.executeQuery(sql);
            int a = 0;
            while(resultSet1.next()) {
                lblVidName.setText(resultSet1.getString(2));
                if(resultSet1.getString(9)!=null){
                    a = Integer.parseInt(resultSet1.getString(9));
                }
                btnAuthor.setText(resultSet1.getString(6) + " \n" + a + " người đăng ký");
                a=0;
                if(resultSet1.getString(8)!=null){
                    a = Integer.parseInt(resultSet1.getString(8));
                }
                a+=1;
                lblViewCount.setText(a + " lượt xem - " + Time.substring(0,9));
                a=0;
                if(resultSet1.getString(10)!=null){
                    a = Integer.parseInt(resultSet1.getString(10));
                }
                btnLike.setText(a+"");
                a=0;
                if(resultSet1.getString(11)!=null){
                    a = Integer.parseInt(resultSet1.getString(11));
                }
                btnDisLike.setText(a+"");
                a=0;
                if(resultSet1.getString(12)!=null) {
                    a = Integer.parseInt(resultSet1.getString(12));
                }
                lblCmtNum.setText(a+" bình luận");
            }
            sql = "CALL show_Comment("+VideoID+");";
            statement = con.createStatement();
            ResultSet resultSet2 =statement.executeQuery(sql);
            while(resultSet2.next()){
                Label lbl = new Label(resultSet2.getString(1) + " \n"+resultSet2.getString(4));
                lbl.setGraphic(new ImageView(new Image(new FileInputStream("D:/Study/DB/src/Database/img/User.png"))));
                listCmt.getItems().add(lbl);
            }
        }
    }
}
