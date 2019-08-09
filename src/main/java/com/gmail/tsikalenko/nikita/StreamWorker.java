package com.gmail.tsikalenko.nikita;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamWorker {

    public StreamWorker() {
    }

    public double average(int[] array) {
        return IntStream.of(array).average().getAsDouble();
    }

    public int minNumber(int[] array) {
        return IntStream.of(array).min().getAsInt();
    }

    public int minIdex(int[] array) {
        return IntStream.of(array).boxed().collect(Collectors.toList()).indexOf(minNumber(array));
    }

    public int cuontityOfZero(int[] array) {
        return (int) IntStream.of(array).filter(arr -> arr == 0).count();
    }

    public int moreOfZero(int[] array) {
        return (int) IntStream.of(array).filter(arr -> arr > 0).count();
    }

    public IntStream multipleAllElements(int[] array, int number) {
        return IntStream.of(array).map(arr -> arr * number);
    }
}