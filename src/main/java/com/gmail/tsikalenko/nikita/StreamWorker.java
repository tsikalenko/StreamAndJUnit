package com.gmail.tsikalenko.nikita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

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

    /**
     * Task 1:
     * The method takes a list of names. Returns a string of the form
     * "1. Ivan, 3. Peter ...", only with names on odd indices, respectively.
     */
    public String fromListToFormString(List<String> names) {

        StringBuffer sb = new StringBuffer();

        names.forEach(n -> {
            if (names.indexOf(n) % 2 == 0) {
                sb.append(names.indexOf(n) + 1).append(". ").append(n);
                if (names.indexOf(n) != (names.size()) - 1) {
                    sb.append(", ");
                }
            }

        });

        return sb.toString();
    }

    /**
     * Task 3:
     * Given and collection = Arrays.asList ("1, 2, 0", "4, 5")
     * From the collection get all the numbers listed, separated by commas from all the elements
     */
    public List<Integer> sparate(List<String> sList) {
        List<Integer> iList = new ArrayList<>();

        sList.forEach(str -> Arrays.asList(str.split(",")).forEach(s -> iList.add(Integer.parseInt(s.trim()))));

        return iList;
    }
    /**
     * Task 4:
     * Using Stream.iterate, make an infinite stream of random numbers —
     * not by calling Math.random but by directly implementing a linear
     * congruential generator. In such a generator, you start with x[0] = seed
     * and then produce x[n + 1] = 1 (a x[n] + c) % m, for appropriate values
     * of a, c, and m. You should implement a method with parameters a, c, m,
     * and seed that yields a Stream<Long>. Try out a = 25214903917, c = 11,
     * and m = 2^48.
     */
    public Stream<Long> random(){
        long a  = 25214903917L;
        int c = 11;
        long m = (long)Math.pow(2, 48);
        long seed = 1L;

        return Stream.iterate(seed, n -> ((a * n + c ) % m));
    }

    /**
     * Task 5:
     * Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
     * that alternates elements from the stream first and second, stopping when one of
     * them runs out of elements
     * */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        List<T> finalList = new ArrayList<>();
        int size;

        if(firstList.size() <= secondList.size()){
            size = firstList.size();
        } else {
            size = secondList.size();
        }

        for (int i = 0; i < size; i++) {
            finalList.add(firstList.get(i));
            finalList.add(secondList.get(i));
        }

        return finalList.stream();
    }

}