package qt.mvc.entity;

import java.io.InputStream;

/**
 * Created by qiutian on 16-10-12.
 */
public class DownloadFile {

    private String Name;
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
