package ru.chupakabr.dev.test.iplato.task_b;

import java.util.Collection;

/**
 * Created by myltik on 17/03/2014.
 */
public interface Queryable<T> {

    /**
     * Query for a values.
     * Note: non of child classes guarantees thread-safety.
     *
     * Example queries to return only specified values if found, empty collection otherwise:
     * 1,2,3,4
     * 1,5,7,8
     * 8
     *
     * @param query    Query pattern
     * @return Found values
     */
    Collection<T> query(String query);
}
