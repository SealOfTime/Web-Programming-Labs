package ru.sealoftime.web.thirdlab.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="history")
@SessionScoped
public class History {
//    @EJB
//    private HistoryService service;

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
