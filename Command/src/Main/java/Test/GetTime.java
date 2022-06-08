package Main.java.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime implements Command {

    @Override
    public String name() {

        return "time";

    }

    @Override
    public void exec() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss z");
        System.out.println( formatForDateNow.format(dateNow));
    }


}
