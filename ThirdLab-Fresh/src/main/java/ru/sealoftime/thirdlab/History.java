package ru.sealoftime.thirdlab;

import org.hibernate.Session;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.*;
import javax.transaction.RollbackException;
import java.util.LinkedList;
import java.util.List;

public class History {
    private List<Point> history;
    @Inject
    private HistoryService service;

    public History(){
        this.history = new LinkedList<>();
    }

    @PostConstruct
    public void init(){
        this.history.addAll(service.getAllPoints());
    }

    public List<Point> getHistory() {
        return history;
    }

    public void push(Point entry){
        if(service.addPoint(entry))
            this.history.add(entry);
    }
}

