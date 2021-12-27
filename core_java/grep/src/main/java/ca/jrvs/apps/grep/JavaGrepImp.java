package ca.jrvs.apps.grep;

import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepImp implements JavaGrep{

    final Logger logger = LoggerFactory.getLogger(JavaGrepImp.class);

    private String regex;
    private String rootPath;
    private String outFile;


    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<String>();
        for (File file: listFiles(rootPath)) {
            for (String line: readLines(file).collect(Collectors.toList())) {
                if(line == null) {continue;}
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
    public Stream<String> readLines(File inputFile) throws IllegalArgumentException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            return reader.lines();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("failed method reason", e);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("failed method reason", e);
        }
    }

    @Override
    public boolean containsPattern(String line) {
        try {
            Pattern p = Pattern.compile(this.regex);
            Matcher matcher = p.matcher(line);
            return matcher.find();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new RuntimeException("failed method reason", e);
        }
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        try {
            OutputStream out_f = new FileOutputStream(outFile);
            OutputStreamWriter out = new OutputStreamWriter(out_f);
            BufferedWriter bw = new BufferedWriter(out);

            for (String temp: lines) {
                bw.write(temp + "\n");
            }
            bw.close();
            out.close();
            out_f.close();
        }
        catch (Exception e) {
            logger.debug(e.getMessage());
            throw new RuntimeException("failed method reason", e);
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
        BasicConfigurator.configure();
        JavaGrepImp jg = new JavaGrepImp();

        BasicConfigurator.configure();
        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE: outfile, rootpath, regex");
        }

        jg.setRegex(args[2]);
        jg.setOutFile(args[0]);
        jg.setRootPath(args[1]);
        //System.out.println(jg.listFiles("/home/centos/dev/jarvis_data_eng_siddarth/core_java/grep/data/txt"));

        try {
            jg.process();
        } catch (Exception ex) {
            jg.logger.error(ex.getMessage());
            throw new RuntimeException("failed method reason", ex);
        }
    }
}
