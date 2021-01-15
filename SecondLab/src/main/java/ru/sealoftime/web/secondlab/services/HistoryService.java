package ru.sealoftime.web.secondlab.services;

import lombok.Getter;
import ru.sealoftime.web.secondlab.model.HistoryEntry;

import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;

@Stateful
public class HistoryService {
    @Getter
    private LinkedList<HistoryEntry> history;

    public HistoryService(){
        history = new LinkedList<>();
    }

    public void push(HistoryEntry entry){
        this.history.push(entry);
    }



}
