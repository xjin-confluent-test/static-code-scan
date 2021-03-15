package examples;

import java.io.IOException;
import java.sql.SQLException;

public class InfiniteLoop835 {

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                for (int k=0; j<10; k++) {
                    // do stuff
                    if (shouldBreak()) break;
                }
            }
        }
    }

    public static  boolean shouldBreak(){
        return false;
    }
}
