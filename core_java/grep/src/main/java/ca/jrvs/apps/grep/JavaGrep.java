package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Interface that handles:
 * <ul>
 * <li>ListFiles: list files available in given directory</li>
 * <li>ReadLines: read all lines of file</li>
 * <li>ContainsPattern: Search for regex pattern in string</li>
 * <li>WriteToFile: Write the string on a particular file</li>
 * </ul>
 *
 * <p>
 * copyright & copy; 2021 Jarvis.
 * </p>
 *
 * @author Siddarth Krishnan.
 */

public interface JavaGrep {
    /**
     * Top level search workflow
     * @throws IOException
     */
    void process() throws IOException;

    /**
     * Traverse a given directory and return all files
     * @param rootDir input directory
     * @return files under the rootDir
     */
    List<File> listFiles(String rootDir);
    /**
     * Read a file and return all lines
     *
     * Explain FileReader, BufferedReader, and character encoding
     *
     * @param inputFile to be read
     * @return lines
     * @throws IllegalArgumentException if a given inputFile is not a file
     */
    Stream<String> readLines(File inputFile);

    /**
     * check if a line contains the regex pattern (passed by user)
     * @param line input string
     * @return true if there is a match
     */
    boolean containsPattern(String line);

    /**
     * Write lines to a file
     * Explore: FileOutputStream, OutputStreamWriter, and BufferedWriter
     *
     * @param lines matched line
     * @throws IOException if write failed
     */
    void writeToFile(List<String> lines) throws IOException;

    String getRootPath();

    void setRootPath(String rootPath);

    String getRegex();

    void setRegex(String regex);

    String getOutFile();

    void setOutFile(String outFile);

}
