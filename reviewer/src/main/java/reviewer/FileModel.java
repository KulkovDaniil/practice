package reviewer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileModel {
    private final String name;
    private final boolean link;

    private final  String date;



    public FileModel(File file) {
        this.name = file.getName();
        this.link = file.isDirectory();
        Date dateNow = new Date(file.lastModified());
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
        this.date =( formatForDateNow.format(dateNow));
    }

    public String getName() {
        return name;
    }

    public boolean isLink() {
        return link;
    }
    
    public String getDate() {return date;}
}
