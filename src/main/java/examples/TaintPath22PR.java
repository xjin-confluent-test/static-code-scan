package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.SQLException;

public class TaintPath22PR {

    public static void main(String[] args) throws IOException, SQLException {
        read(null, null);
    }

    public static void read(Socket sock, String user) throws IOException {
        BufferedReader filenameReader = new BufferedReader(
                new InputStreamReader(sock.getInputStream(), "UTF-8"));
        String filename = filenameReader.readLine();
        String sanitizedPath = Util.get(filename);
        String sanitizedPath2 = Util.get(filename);
        // BAD: read from a file using a path controlled by the user
        BufferedReader fileReader = new BufferedReader(
                new FileReader("/home/" + user + "/" + sanitizedPath2));
        String fileLine = fileReader.readLine();
        while(fileLine != null) {
            sock.getOutputStream().write(fileLine.getBytes());
            fileLine = fileReader.readLine();
        }
    }
}
