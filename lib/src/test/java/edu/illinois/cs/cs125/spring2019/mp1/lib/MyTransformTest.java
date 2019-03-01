package edu.illinois.cs.cs125.spring2019.mp1.lib;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MyTransformTest {
    private static final RGBAPixel FILL_VALUE = RGBAPixel.getFillValue();
    private static final int F = FILL_VALUE.getData();
    @Test
    public void testRightShift1() {
        RGBAPixel[][] input = RGBAPixel.fromIntArray(new int[][] {
                {2,4,6},
                {7,8,9},
                {10,12,13}
        });

        int amount = 1;

        RGBAPixel[][] expectedOutput = RGBAPixel.fromIntArray(new int[][] {
                {F,F,F},
                {2,4,6},
                {7,8,9}
        });

        testMain(input,amount,expectedOutput,0);
    }

    @Test
    public void testRightShift2() {
        RGBAPixel[][] input = RGBAPixel.fromIntArray(new int[][]{
                {2, 4, 6},
                {7, 8, 9},
                {10, 12, 13}
        });

        int amount = 2;

        RGBAPixel[][] expectedOutput = RGBAPixel.fromIntArray(new int[][]{
                {F, F, F},
                {F, F, F},
                {2, 4, 6}
        });
        testMain(input,amount,expectedOutput,0);
    }

    @Test
    public void testLeftShift() {
        RGBAPixel[][] input = RGBAPixel.fromIntArray(new int[][] {
                {2,4,6},
                {7,8,9},
                {10,12,13}
        });

        int amount = 1;

        RGBAPixel[][] expectedOutput = RGBAPixel.fromIntArray(new int[][] {
                {7,8,9},
                {10,12,13},
                {F,F,F}
        });

        testMain(input,amount,expectedOutput,1);
    }

    private void testMain(RGBAPixel[][] input, int amount, RGBAPixel[][] expectedOutput, int functionSelector) {
        RGBAPixel[][] output = null;
        if (functionSelector == 0) {
            output = Transform.shiftRight(input, amount);
        } else if (functionSelector == 1) {
            output = Transform.shiftLeft(input, amount);
        } else if (functionSelector == 2) {
            output = Transform.shiftUp(input, amount);
        } else if (functionSelector == 3){
            output = Transform.shiftDown(input, amount);
        }
        RGBAPixel[][] copyOfInput = RGBAPixel.copyArray(input);
        Assert.assertTrue("Expected:\n" + RGBAPixel.printArray(expectedOutput)
                        + "\nFound:\n" + RGBAPixel.printArray(output)
                        + "\nDiff:\n" + RGBAPixel.diffArrays(output, expectedOutput) + "\n",
                Arrays.deepEquals(output, expectedOutput));
        Assert.assertTrue("Input array was modified", Arrays.deepEquals(input, copyOfInput));
    }
}
