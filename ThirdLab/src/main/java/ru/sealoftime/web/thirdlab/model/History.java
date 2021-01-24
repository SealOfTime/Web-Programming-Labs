package ru.sealoftime.web.thirdlab.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="history")
@SessionScoped
public class History {


    private EntityManager em;

    private List<HistoryEntry> history;
    public History(){
        this.history = new LinkedList<>();
    }

    public List<HistoryEntry> getHistory(){
        return this.history;
    }

    public void push(HistoryEntry entry){
        this.history.add(entry);
    }
}
