package ru.sealoftime.web.thirdlab.services;

import lombok.Getter;
import ru.sealoftime.web.thirdlab.model.HistoryEntry;

import javax.ejb.Stateful;
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
