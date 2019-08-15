package com.gmail.tsikalenko.nikita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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


}