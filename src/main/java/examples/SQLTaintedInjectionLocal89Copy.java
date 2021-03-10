package examples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTaintedInjectionLocal89Copy {

    public static void main(String[] args) throws IOException, SQLException {
        Connection con = null;
        String category = System.getenv("ITEM_CATEGORY");
        String changed = category + "abc";
        Statement statement = con.createStatement();
        String query1 = "SELECT ITEM,PRICE FROM PRODUCT WHERE ITEM_CATEGORY='"
                + changed + "' ORDER BY PRICE";
        ResultSet results = statement.executeQuery(query1);
    }
}
