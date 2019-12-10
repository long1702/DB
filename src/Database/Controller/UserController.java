package Database.Controller;

import Database.Connector.ConnectionClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    JFXButton btnUpload,btnUser,btnSearch;
    @FXML
    JFXTextField txtSearch;
    @FXML
    Label lblNoResult;
    @FXML
    ListView<Label> searchResult;
    @FXML
    Label lblSubNum,lblUserName;
    Statement statement;
    String sql;
    private String UserID;

    public void setUserID(String userID) {
        UserID = userID;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void onbtnUserClicked(MouseEvent mouseEvent) {
    }

    public void onbtnUploadClicked(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/UploadVid.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public void onbtnLeave(MouseEvent mouseEvent) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection con = connectionClass.getConnection();
        try {
            sql = "CALL get_user_info("+UserID+");";
            statement = con.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while(resultSet.next()) {
                lblUserName.setText(resultSet.getString(1));
                String a = resultSet.getString(2) ;
                if (a == null) {
                    a = "0";
                }
                lblSubNum.setText(a+ " đã đăng ký");
            }
        } catch (SQLException e) {
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
                    lbl.setGraphic(new ImageView(new Image(new FileInputStream("D:/Study/DB/src/Database/img/YoutubeVN.png"))));
                    searchResult.getItems().add(lbl);
                }
            } catch (SQLException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
