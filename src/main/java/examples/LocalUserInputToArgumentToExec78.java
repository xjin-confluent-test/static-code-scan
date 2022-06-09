package examples;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LocalUserInputToArgumentToExec78 extends HttpServlet {


    public static void main(String[] args) throws IOException {
        String script = System.getenv("SCRIPTNAME");
        if (script != null) {
            // BAD: The script to be executed is controlled by the user.
            String y = script;
            String z = y+ "looks good";
            Runtime.getRuntime().exec(z);
        }
    }
}

