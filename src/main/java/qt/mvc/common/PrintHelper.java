package qt.mvc.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by qiutian on 16-10-15.
 */
public class PrintHelper {

    public static String GetString(Exception e) throws IOException {
        ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream();
        e.printStackTrace(new java.io.PrintWriter(buf, true));
        String  expMessage = buf.toString();
        buf.close();
        return expMessage;
    }
}
