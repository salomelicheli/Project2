package ge.tbc.tbcitacademy.data;

import ge.tbc.tbcitacademy.helper.SQLConnection;
import ge.tbc.tbcitacademy.helper.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseSteps {
    public UserModel getSpecificUserInfo(Integer id){
        UserModel user = null;
        try(Connection connect = SQLConnection.connect()) {
            String Sql = """
                    USE Registration
                    SELECT username, password FROM dbo.Users
                    WHERE id = ?
                    """;
            PreparedStatement preparedStatement = connect.prepareStatement(Sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
               user = new UserModel(resultSet.getString("username"),
                        resultSet.getString("password")); }
            return user;
        } catch (SQLException e) {
            e.getStackTrace();
            return user;
        }
    }
}
