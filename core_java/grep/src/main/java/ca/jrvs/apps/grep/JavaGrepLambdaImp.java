package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp extends JavaGrepImp {
    public static void main(String[] args) {
        JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();
        javaGrepLambdaImp.setRegex(args[2]);
        javaGrepLambdaImp.setOutFile(args[0]);
        javaGrepLambdaImp.setRootPath(args[1]);

        System.out.println(javaGrepLambdaImp.getRootPath());
        try {
            javaGrepLambdaImp.process();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<File> listFiles(String rootDir) {
        Path path = Paths.get(rootDir);
        try {
            return Files.walk(path).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> readLines(File inputFile) throws IllegalArgumentException {
        Path filepath = inputFile.toPath();
        try {
            Stream<String> lines = Files.lines(filepath).onClose(() -> System.out.println("done read"));
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


