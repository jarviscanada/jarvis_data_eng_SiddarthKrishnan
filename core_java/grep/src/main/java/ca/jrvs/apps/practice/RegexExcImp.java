package ca.jrvs.apps.practice;

import java.util.Locale;

public class RegexExcImp implements RegexExc {

    public boolean matchJpeg(String filename) {
        filename = filename.toLowerCase();
        return filename.matches(".+\\.jp(eg|g)");
    }

    public boolean isEmptyLine(String line) {
        return line.matches("^\\s*$");
    }

    public boolean matchIp(String ip) {
        return ip.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
    }

    public static void main(String[] args) {
        RegexExcImp regexExcImp = new RegexExcImp();
        System.out.println(regexExcImp.isEmptyLine(""));
    }
}
