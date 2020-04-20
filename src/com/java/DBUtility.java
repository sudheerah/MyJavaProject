package com.java;

import java.sql.*;


public class DBUtility {

    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=txnd01-scan.dev.db.anz)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=TASCI03D)))";
    private static final String DB_USER = "DEV01_PAYMENT_USER";
    private static final String DB_PASSWORD = "Pymnt_03d_dev01_Usr_893";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        String jdbcUrl = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=txnd01-scan.dev.db.anz)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=TASCI03D)))";
//        String username = "DEV01_PAYMENT_USER";
//        String password = "Pymnt_03d_dev01_Usr_893";
//        String sql = "delete from payment_auth_sign where CAAS_CREDENTIAL_ID ='txvrc66s3llafiqzsrmzu6anjd'";
//
//        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
//             Statement stmt = conn.createStatement();) {
//
//            stmt.executeUpdate(sql);
//            System.out.println("Record deleted successfully");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        Class.forName(DB_DRIVER);
        dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                DB_PASSWORD);
//        String deleteSQL = "DELETE Person WHERE USER_ID = ?";
        String updateSQL = "UPDATE DEV01_TBOS_OWNER.PAYMENT_AUTH_SIGN SET CAAS_HTTP_STATUS_CODE = '504', CAAS_RESULT_CODE = '416', STATUS = 'POL' " +
                "WHERE CAAS_CREDENTIAL_ID IN ('kgtyazcxwwtxoo8gepqlqm6beg'," +   //Declined
                "'qovpcjbzzi81sgiziwljpyhfwt'," +  // Server Error
                "'i47mgyhwczwzd18mmlhwta1lh2'," +  // Expired
                "'3gopaqf5oeytwaycayhbdozxtb'," + // QR Challenged
                "'xgui001mwd1i0phymhrsbujo97'," + // Invalid
                "'txvrc66s3llafiqzsrmzu6anjd')"; //Accepted
//        String updateSQL = "SELECT * FROM DEV01_TBOS_OWNER.PAYMENT_AUTH_SIGN WHERE CAAS_CREDENTIAL_ID ='txvrc66s3llafiqzsrmzu6anjd'";
        preparedStatement = dbConnection.prepareStatement(updateSQL);
//        preparedStatement.setInt(1, 1001);

        preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnection.close();
    }
}
