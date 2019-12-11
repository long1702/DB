package Database.Controller;

import Database.Connector.ConnectionClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UpLoadVidController implements Initializable {
    @FXML
    JFXRadioButton radioBeauty, radioGame,radioLife,radioFood,radioMusic,radioDrama,radioCartoon,radioSport,radioNature;
    @FXML
    JFXRadioButton radioPrivate,radioPublic;
    @FXML
    ToggleGroup Type,Mode;
    @FXML
    JFXButton btnOK,btnCancel;
    String sql;
    Statement statement;
    String UserID = "None";
    @FXML
    TextField txtName;
    @FXML
    TextArea txtDis;

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String radioTypeChecked(){
        radioBeauty.setUserData("Beauty");
        radioGame.setUserData("Game");
        radioLife.setUserData("Life");
        radioFood.setUserData("Food");
        radioMusic.setUserData("Music");
        radioDrama.setUserData("Drama");
        radioCartoon.setUserData("Cartoon");
        radioSport.setUserData("Sport");
        radioNature.setUserData("Nature");
        Object Sstate = Type.getSelectedToggle().getUserData();
        return Sstate.toString();
    }
    public String radioModeChecked(){
        radioPrivate.setUserData("Private");
        radioPublic.setUserData("Public");
        Object Sstate = Mode.getSelectedToggle().getUserData();
        return Sstate.toString();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnCancel.setOnMouseClicked(a->{
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        });
        btnOK.setOnMouseClicked(a->{
            ConnectionClass connectionClass = new ConnectionClass();
            Connection con = connectionClass.getConnection();
            try {
                sql = "CALL pressUploadVideo("+UserID+"," + txtDis.getText() + ","+txtName.getText()+ "," + radioModeChecked()+");";
                statement = con.createStatement();
                statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) btnOK.getScene().getWindow();
            stage.close();
        });
    }

}
