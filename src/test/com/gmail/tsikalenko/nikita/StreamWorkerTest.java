package com.gmail.tsikalenko.nikita;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWorkerTest {

    int[] arr = {3, 4, 8, 5, 12, 2, 7};
    StreamWorker sw = new StreamWorker();

    @Test
    public void averange() {
        double expected = 0;
        for (int i = 0; i < arr.length; i++) {
            expected += arr[i];
        }
        expected /= arr.length;

        double actual = sw.average(arr);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void minNumber() {
        int expected = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < expected) {
                expected = arr[i];
            }
        }

        int actual = sw.minNumber(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minIdex() {
        int expected = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < expected) {
                expected = i;
            }
        }

        int actual = sw.minIdex(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cuontityOfZero() {
        int expected = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                expected++;
            }
        }

        int actual = sw.cuontityOfZero(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moreOfZero() {
        int expected = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                expected++;
            }
        }

        int actual = sw.moreOfZero(arr);
        Assert.assertEquals(expected, actual);
    }

    static int c;

    @Test
    public void multipleAllElements() {
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] * 2;
        }

        List<Integer> expected = Arrays.asList(newArr);
        List<Integer> actual = sw.multipleAllElements(arr, 2).boxed().collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void separete(){
        List<Integer> expected = Arrays.asList(1, 2, 0, 4, 5);
        List<Integer> actual = sw.sparate(Arrays.asList("1, 2, 0", "4, 5"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fromListToFormString(){
        String expected = "1. Ivan, 3. Peter";
        String actual = sw.fromListToFormString(Arrays.asList("Ivan", "Nikita", "Peter"));
        Assert.assertEquals(expected, actual);
    }
}