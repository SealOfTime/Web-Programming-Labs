package ru.sealoftime.web.secondlab.model;

import ru.sealoftime.web.secondlab.services.HistoryService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="history")
@SessionScoped
public class History {
//    @EJB
//    private HistoryService service;

    private final LinkedList<HistoryEntry> history;
    public History(){
        this.history = new LinkedList<>();
    }

    public LinkedList<HistoryEntry> getHistory(){
        return this.history;
    }

    public void push(HistoryEntry entry){ this.history.push(entry);
    }
}
