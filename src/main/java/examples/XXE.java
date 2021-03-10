package examples;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class XXE {

    public static void main(String[] args) throws Exception {
        parse(null);
    }

    public static void parse(Socket sock) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.parse(sock.getInputStream()); //unsafe
    }
}
