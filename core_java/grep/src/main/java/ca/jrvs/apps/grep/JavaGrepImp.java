package ca.jrvs.apps.grep;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.*;
import java.util.stream.Collectors;

public class JavaGrepImp implements JavaGrep{

    final Logger logger = LoggerFactory.getLogger(JavaGrepImp.class);

    private String regex;
    private String rootPath;
    private String outFile;


    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<String>();
        for (File file: listFiles(rootPath)) {
            for (String line: readLines(file)) {
                if (containsPattern(line)) {
                    matchedLines.add(line);
                }
            }
        }
        writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootDir) {
        List<File> files = new ArrayList<File>();
        File root = new File(rootDir);
        File[] fileList = root.listFiles();
        if (fileList != null) {
            for (File file: fileList) {
                if (file.isDirectory()) {
                    listFiles(file.getAbsolutePath());
                } else {
                    files.add(file.getAbsoluteFile());
                }
            }
        }
        return files;
    }

    @Override
    public List<String> readLines(File inputFile) throws IllegalArgumentException {
        BufferedReader reader;
        List<String> fileLines = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            fileLines.add(line);
            while(line != null) {
                line = reader.readLine();
                fileLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }

    @Override
    public boolean containsPattern(String line) {
        //Pattern p = Pattern.compile(regex);
        Pattern p = Pattern.compile(this.regex);
        Matcher matcher = p.matcher(line);
        return matcher.find();
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        try {
            OutputStream out_f = new FileOutputStream(outFile);
            OutputStreamWriter out = new OutputStreamWriter(out_f);
            BufferedWriter bw = new BufferedWriter(out);

            for (String temp: lines) {
                bw.write(temp);
            }
            bw.close();
            out.close();
            out_f.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath=rootPath;
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex=regex;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile=outFile;
    }

    public static void main(String[] args) throws IOException {
        JavaGrepImp jg = new JavaGrepImp();
        jg.setRootPath("/home/centos/dev/jarvis_data_eng_siddarth/core_java/grep/data/txt/shakespeare.txt");
        jg.setOutFile("/home/centos/dev/jarvis_data_eng_siddarth/core_java/grep/data/txt/outf.txt");
        jg.setRegex(".*World.*");
        jg.process();
    }
}
