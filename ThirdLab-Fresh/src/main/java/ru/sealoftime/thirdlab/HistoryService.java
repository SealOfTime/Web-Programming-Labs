package ru.sealoftime.thirdlab;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class HistoryService implements Serializable {
    @PersistenceContext
    private EntityManager manager;

    public List<Point> getAllPoints(){
        TypedQuery<Point> q = manager.createQuery("from Point", Point.class);
        List<Point> resultList = q.getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }

    @Transactional
    public boolean addPoint(Point entry) {
        try {
            manager.persist(entry);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
