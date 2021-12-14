package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JavaGrepImp implements JavaGrep{
    public void process() throws IOException {

    }

    public List<File> listFiles(String rootDir) {
        return null;
    }

    public List<String> readLines(File inputFile) {
        return null;
    }

    public boolean containsPattern(String line) {
        return false;
    }

    public void writeToFile(List<String> lines) throws IOException {

    }

    public String getRootPath() {
        return null;
    }

    public void setRootPath(String rootPath) {

    }

    public String getRegex() {
        return null;
    }

    public void setRegex(String regex) {

    }

    public String getOutFile() {
        return null;
    }

    public void setOutFile(String outFile) {

    }
}
