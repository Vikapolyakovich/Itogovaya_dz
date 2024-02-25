package org.example.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pet {
    protected String name;
    protected Date birthday;
    protected List<String> command = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void getCommand() {
        for (String com: command) {
            System.out.println(com);
        }
    }

    public void addCommand(String newcomand) {
        command.add(newcomand);
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        String strDate = format.format(birthday);

        return  name + " " + strDate + " " + command;
    }
}
