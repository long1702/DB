package Database.Controller;

import Database.Connector.ConnectionClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class SignupScreenController implements Initializable {

    @FXML
    JFXButton btnOK,btnCancel;
    @FXML
    public AnchorPane mainStage;
    @FXML
    Label lblWarning1, lblWarning2;
    @FXML
    JFXTextField txtGmail, txtName;
    @FXML
    JFXPasswordField txtPass;
    private boolean Signupable = true;
    Statement statement;
    String sql;
    public  String UserID = "None";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblWarning1.setVisible(false);
        lblWarning2.setVisible(false);
    }

    public void onbtnOkClicked(MouseEvent mouseEvent) throws IOException, SQLException {
        lblWarning1.setVisible(false);
        lblWarning2.setVisible(false);
        ConnectionClass connectionClass = new ConnectionClass();
        Connection con = connectionClass.getConnection();
        try {
            sql = "SELECT Gmail FROM USER;";
            statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(txtGmail.getText().equals(resultSet.getString(1))) {
                    Signupable = false;
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(Signupable && !txtGmail.getText().equals("") && !txtName.getText().equals("") && !txtPass.getText().equals("")) {
            String Name = txtName.getText();
            String Gmail= txtGmail.getText();
            String Pass= txtPass.getText();
            CallableStatement cs = con.prepareCall("{call SignUp(?,?,?)}");
            cs.setString(1,Name);
            cs.setString(2,Gmail);
            cs.setString(3,Pass);
            cs.executeUpdate();
            //sql = "INSERT INTO User (UserID, isRegistered, Name, Gmail, Password, SignUpDate) VALUES (20001, TRUE,"+Name+","+Gmail+","+Pass+","+Date+");";
            //statement.executeUpdate(sql);
            Stage stage = (Stage) btnOK.getScene().getWindow();
            stage.close();

        }
        else {
            if (!Signupable) lblWarning2.setVisible(true);
            else lblWarning1.setVisible(true);
        }
    }

    public void onbtnCancelClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
