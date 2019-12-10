package Database.Controller;

import Database.Connector.ConnectionClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {
    @FXML
    JFXButton btnOK,btnCancel;
    @FXML
    JFXTextField txtGmail;
    @FXML
    JFXPasswordField txtPass;
    @FXML
    Label lblWarning1, lblWarning2;
    Statement statement;
    String sql;
    public String UserID = "None";
    boolean showable = false;

    boolean Loginable;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblWarning1.setVisible(false);
        lblWarning2.setVisible(false);
    }

    public void onbtnOkClicked(MouseEvent mouseEvent) {
        lblWarning1.setVisible(false);
        lblWarning2.setVisible(false);
        ConnectionClass connectionClass = new ConnectionClass();
        Connection con = connectionClass.getConnection();
        try {
            sql = "SELECT UserID, Gmail,Password FROM USER;";
            statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(txtGmail.getText().equals(resultSet.getString(2)))
                    if(txtPass.getText().equals(resultSet.getString(3))) {
                        Loginable = true;
                        UserID = resultSet.getString(1);
                        break;
                    }
                    else {
                        Loginable = false;
                        break;
                    }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (txtPass.getText().equals("") || txtGmail.getText().equals(""))
            lblWarning1.setVisible(true);
        else {
            if(!Loginable)
            lblWarning2.setVisible(true);
            else{
                showable = true;
                Stage stage = (Stage) btnOK.getScene().getWindow();
                stage.close();
            }
        }

    }

    public void onbtnCancelClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
