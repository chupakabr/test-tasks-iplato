package ru.chupakabr.dev.test.iplato.task_a;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by myltik on 17/03/2014.
 */
public class ArrayUtilTest {

    @Test
    public void testSymmetricDifferenceEmptyData() throws Exception {
        int[] a1 = new int[] {1, 2, 3};
        int[] a2 = new int[] {};
        int[] a3 = null;

        int[] res = ArrayUtil.symmetricDifference(a1, a2);
        assert Arrays.equals(res, a1);

        res = ArrayUtil.symmetricDifference(a2, a1);
        assert Arrays.equals(res, a1);

        res = ArrayUtil.symmetricDifference(a3, a1);
        assert Arrays.equals(res, a1);
    }

    @Test
    public void testSymmetricDifferenceUniqueElements() throws Exception {
        int[] a1 = new int[] {1, 2, 3};
        int[] a2 = new int[] {3, 4, 5};
        int[] expected = new int[] {1, 2, 4, 5};

        int[] res = ArrayUtil.symmetricDifference(a1, a2);
        assert Arrays.equals(res, expected);
    }

    @Test
    public void testSymmetricDifferenceDuplicatedElements() throws Exception {
        int[] a1 = new int[] {1, 2, 2, 3};
        int[] a2 = new int[] {3, 4, 4, 5, 5};
        int[] expected = new int[] {1, 2, 4, 5};

        int[] res = ArrayUtil.symmetricDifference(a1, a2);
        assert Arrays.equals(res, expected);
    }
}
