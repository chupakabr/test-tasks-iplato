package ru.chupakabr.dev.test.iplato.task_d_c;

import ru.chupakabr.dev.test.iplato.task_b.Queryable;

/**
 * Created by myltik on 17/03/2014.
 */
public class MaxValueListDao implements QueryableDao<Integer> {

    /**
     * @param id    ID is a file path of the file containing test data
     * @return Queryable object
     */
    public Queryable<Integer> getObjectById(String id) {
        return new MaxValueList(id);
    }
}
