package ru.chupakabr.dev.test.iplato.task_d_c;

/**
 * {@see DataProviderTest} for DAO and IoC usage.
 *
 * Created by myltik on 17/03/2014.
 */
public class DataProvider {

    private QueryableDao dao;

    /**
     * @return DAO
     */
    public QueryableDao getDao() {
        return dao;
    }

    /**
     * @param dao DAO
     */
    public void setDao(QueryableDao dao) {
        this.dao = dao;
    }
}
