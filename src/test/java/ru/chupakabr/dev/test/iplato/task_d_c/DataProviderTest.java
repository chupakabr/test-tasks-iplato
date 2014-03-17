package ru.chupakabr.dev.test.iplato.task_d_c;

import org.junit.Before;
import org.junit.Test;
import ru.chupakabr.dev.test.iplato.task_b.Queryable;

import java.util.Arrays;
import java.util.Collection;

/**
 * Task C: DAO and IoC.
 *
 * Created by myltik on 17/03/2014.
 */
public class DataProviderTest {

    private String dataFile;

    @Before
    public void setUp() throws Exception {
        dataFile = getClass().getResource("/task_d_data.txt").getFile();
    }

    @Test
    public void testSetDao() throws Exception {
        DataProvider dataProvider = new DataProvider();
        dataProvider.setDao(new MaxValueListDao());

        Queryable q1 = dataProvider.getDao().getObjectById(dataFile);
        Queryable q2 = dataProvider.getDao().getObjectById(dataFile);
        assert !q1.equals(q2);

        Collection<Integer> res1 = q1.query("1,100,200,5");
        Collection<Integer> res2 = q2.query("0,1,4,5,6,7,8");
        assert !Arrays.equals(res1.toArray(), res2.toArray());
        assert 2 == res1.size(); // 1,5
        assert 4 == res2.size(); // 0,1,4,5
    }
}
