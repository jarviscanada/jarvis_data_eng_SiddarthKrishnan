# Introduction
An implementation of the grep command line utility is provided in this simple Java application. The functionality is to search for a text
pattern recursively in a given directory and output matching lines to a file. This grep app leverages regular expressions in java with the Pattern
and Matcher classes. Maven was used for this project to manage the build lifecycle and download dependencies. A dockerfile was used to create a image
consisting of our grep jar files. This image was then push to the docker registry.

# Quickstart
This application can be run through a docker container. The image can be pulled from docker hub with `docker pull sidd11k/grep`.
To run a container based on this docker image use `docker run --rm \
-v `pwd`/data:/data -v `pwd`/log:/log \
sid11k/grep <OUTFILE> <ROOT_DIRECTORY> <SEARCH_PATTERN>` The --rm option removes the container after the process exits. The volume argument
to docker run can be passed a different directory to mount at the specified path in the container (-v hostpath:container_path). This can make
files in the container available to the host or vice versa.

# Implementation
The process of writing matched lines from files in a directory to a given output file was divided into several methods. A method named "process"
provided a high-level workflow to call all the individual helper methods for performing the grep search operation.
##Process
```matchedLines = []
for file in listFilesRecursively:
for line in readFileLines:
if (line contains pattern):
matchedLines.add(line)
```
The grep functionality  was implemented using iteration to check every line of searched files for the regex pattern. Recursion and lambda/stream
APIs were tested in a parent's and the child class's overridden method respectively. Both versions of these methods listed files in a given
directory recursively. Streams were also tested in a child class's overridden readLines method.

# Performance Issue
It is understood that although the JVM has heuristics for automatic heap resizing, better performance is achieved by tuning the JVM by adjusting
heap size. When running the grep app, data read from files is loaded to the heap. Our app will cause an out of memory error when the size of data allocated
to the heap is larger than the maximum size we assigned with the VM. One fix for this is increasing the heap size. Another fix for when our data
to process is bigger than physical memory size is using BufferedReaders or Stream APIs.

# Test
This application was tested with ad hoc regex search patterns and text files in different paths of the chosen root directory. So a range of manual
testing actions were carried out throughout the grep implementation. SLF4J was the logging framework used to debug the code.

# Deployment
The app was deployed using the maven build lifecycle and docker. Either the java -classpath or java -cp options are used launch the JVM and run the app.
To ensure the dependencies in our pom file are loaded into the JVM, we use uber jar. The maven shade plugin was added to our pom file to package all dependencies
into an uber jar. A docker image was built using a dockerfile and pushed to docker hub.

# Improvement
Learning how to process large volumes of data is the main implementation improvement I felt could be made. The possibility of running out
of heap memory needs consideration when data is simply stored in a collection. Many of the static factory methods in the Stream interface are
good enough to build a stream for our needs.