package ca.jrvs.apps.practice;

import java.util.Locale;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegexExcImp implements RegexExc {
    private final Logger logger = LoggerFactory.getLogger(RegexExcImp.class);
    private Boolean t;
    private Boolean oldT;

    public boolean matchJpeg(String filename) {
        filename = filename.toLowerCase();
        oldT=t;
        t=filename.matches(".+\\.jp(eg|g)");
        logger.debug("old return was {} new return is {}", oldT, t);
        return filename.matches(".+\\.jp(eg|g)");
    }

    public boolean isEmptyLine(String line) {
        return line.matches("^\\s*$");
    }

    public boolean matchIp(String ip) {
        return ip.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        RegexExcImp regexExcImp = new RegexExcImp();
        regexExcImp.matchJpeg("kek.jps");
        regexExcImp.logger.info("hello");
    }
}
