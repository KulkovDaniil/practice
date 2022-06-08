package Main.java.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate implements Command {
    @Override
    public String name() {

        return "date";
    }

    @Override
    public void exec() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println( formatForDateNow.format(dateNow));


    }

}
