package ru.chupakabr.dev.test.iplato.task_d_c;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by myltik on 17/03/2014.
 */
public class MaxValueListTest {

    private String dataFile;
    private String emptyFile;

    private static final List<Integer> fileContent = new ArrayList<Integer>() {{
        add(1);
        add(5);
        add(10);
        add(555);
        add(2);
        add(0);
        add(4);
        add(7890);
    }};

    @Before
    public void setUp() throws Exception {
        dataFile = getClass().getResource("/task_d_data.txt").getFile();
        emptyFile = getClass().getResource("/empty.txt").getFile();
    }

    @Test
    public void testGetTopValuesOnNull() throws Exception {
        try {
            new MaxValueList((File) null);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }

    @Test
    public void testGetTopValuesOnEmptyFile() throws Exception {
        MaxValueList lst = new MaxValueList(emptyFile);
        Collection<Integer> res = lst.getTopValues(1);
        assert res.size() == 0;
    }

    @Test
    public void testGetTopValuesWithDataCached() throws Exception {
        MaxValueList lst = new MaxValueList(dataFile, true);

        Collection<Integer> res = lst.getTopValues(5);
        assert res.size() == 5;
        assert Arrays.equals(res.toArray(), fileContent.subList(0, 5).toArray());

        res = lst.getTopValues(7);
        assert res.size() == 7;
        assert Arrays.equals(res.toArray(), fileContent.subList(0, 7).toArray());
    }

    @Test
    public void testGetTopValuesWithDataNonCached() throws Exception {
        MaxValueList lst = new MaxValueList(dataFile, false);

        Collection<Integer> res = lst.getTopValues(7);
        assert res.size() == 7;
        assert Arrays.equals(res.toArray(), fileContent.subList(0, 7).toArray());

        res = lst.getTopValues(9);
        assert res.size() == 8;
        assert Arrays.equals(res.toArray(), fileContent.subList(0, 8).toArray());
    }

    @Test
    public void testGetTopValuesOutOfIndex() throws Exception {
        MaxValueList lst = new MaxValueList(dataFile);
        Collection<Integer> res = lst.getTopValues(100);
        assert res.size() == 8;
    }
}
