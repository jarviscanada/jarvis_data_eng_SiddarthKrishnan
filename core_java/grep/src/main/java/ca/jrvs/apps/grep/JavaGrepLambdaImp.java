package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ca.jrvs.apps.practice.RegexExcImp;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaGrepLambdaImp extends JavaGrepImp {
    private final Logger logger = LoggerFactory.getLogger(RegexExcImp.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        if (args.length != 3) {
            return;
        }

        JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();
        javaGrepLambdaImp.setRegex(args[2]);
        javaGrepLambdaImp.setOutFile(args[0]);
        javaGrepLambdaImp.setRootPath(args[1]);

        try {
            javaGrepLambdaImp.process();
        } catch (Exception ex) {
            javaGrepLambdaImp.logger.error(ex.getMessage());
            throw new RuntimeException("failed method reason", ex);
        }
    }

    @Override
    public List<File> listFiles(String rootDir) {
        Path path = Paths.get(rootDir);
        try {
            return Files.walk(path).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("failed method reason", e);
        }
    }

    @Override
    public List<String> readLines(File inputFile) throws IllegalArgumentException {
        Path filepath = inputFile.toPath();
        try {
            Stream<String> lines = Files.lines(filepath).onClose(() -> System.out.println("done read"));
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("failed method reason", e);
        }
    }
}


