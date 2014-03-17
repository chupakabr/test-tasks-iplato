package ru.chupakabr.dev.test.iplato.task_d_c;

import ru.chupakabr.dev.test.iplato.task_b.Queryable;

/**
 * Created by myltik on 17/03/2014.
 */
public interface QueryableDao<T> {

    /**
     * @param id    ID is a file path of the file containing test data
     * @return Queryable object
     */
    Queryable<T> getObjectById(String id);
}
