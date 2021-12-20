package ca.jrvs.apps.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImp implements LambdaStreamExc{

    @Override
    public Stream<String> createStrStream(String... strings) {
        return Arrays.stream(strings);
    }

    @Override
    public Stream<String> toUpperCase(String... strings) {
        return Stream.of(strings).map(String::toUpperCase);
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        return null;
    }

    @Override
    public IntStream createIntStream(int[] arr) {
        return null;
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {
        return null;
    }

    @Override
    public List<Integer> toList(IntStream intStream) {
        return null;
    }

    @Override
    public IntStream createIntStream(int start, int end) {
        return null;
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
        return null;
    }

    @Override
    public IntStream getOdd(IntStream intStream) {
        return null;
    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        return null;
    }

    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {

    }

    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {

    }

    @Override
    public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
        return null;
    }

    public static void main(String[] args) {
        LambdaStreamExcImp x = new LambdaStreamExcImp();
        x.toUpperCase("sd", "ds", "cv").forEach(System.out::println);
    }
}
