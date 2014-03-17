package ru.chupakabr.dev.test.iplato.task_a;

import java.util.HashSet;
import java.util.Set;

/**
 * Task A. Symmetric difference.
 *
 * Created by myltik on 17/03/2014.
 */
public class ArrayUtil {

    /**
     * @param array1    First array
     * @param array2    Second array
     * @return Symmetric difference of two passed arrays, not null. The origin of the difference is the size
     * of resulting array
     */
    public static int[] symmetricDifference(final int[] array1, final int[] array2) {
        // At first check for at least one empty array
        if (array1 == null || array1.length <= 0) {
            if (array2 == null || array2.length <= 0) {
                return new int[0];
            } else {
                return array2;
            }
        } else if (array2 == null || array2.length <= 0) {
            return array1;
        }

        // Both arrays has some data, so proceed
        Set<Integer> result = new HashSet<Integer>() {{
            for (int i = 0; i < array1.length; ++i) {
                add(array1[i]);
            }
        }};
        Set<Integer> firstArray = new HashSet<Integer>(result);

        for (int i = 0; i < array2.length; ++i) {
            if (firstArray.contains(array2[i])) {
                result.remove(array2[i]);
            } else {
                result.add(array2[i]);
            }
        }

        // Convert to array of integers
        int[] intArray = new int[result.size()];
        int i = 0;
        for (Integer val : result) {
            intArray[i++] = val;
        }

        return intArray;
    }

}
