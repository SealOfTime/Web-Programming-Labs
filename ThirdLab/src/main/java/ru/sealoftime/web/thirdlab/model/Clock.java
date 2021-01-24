package ru.sealoftime.web.thirdlab.model;

import org.icefaces.application.PortableRenderer;
import org.icefaces.application.PushRenderer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.faces.context.FacesContext;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Named("clock")
@SessionScoped
public class Clock implements Serializable{
    private final static String CLOCKS_GROUP = "clocksGroup";
    private static ScheduledExecutorService scheduler;

    private Locale locale;
    private Future<?> runningTask;
    @Inject @Push(channel = "clockPush")
    private PushContext push;
    private PortableRenderer renderer;

    private Date time;

    public Date getTime(){
        System.out.println("Time was got");
        return this.time;
    }

    private void updateTime(){
        try {
            System.out.println("Trying to push");
            this.time = Calendar.getInstance(this.locale).getTime();
            this.renderer.render(CLOCKS_GROUP);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostConstruct
    public void init() {
        if(scheduler == null)
            scheduler = Executors.newSingleThreadScheduledExecutor();
        this.locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

        renderer = PushRenderer.getPortableRenderer();
        renderer.addCurrentSession(CLOCKS_GROUP);

        this.updateTime();

        this.runningTask = scheduler.scheduleAtFixedRate(this::updateTime, 0, 5, TimeUnit.SECONDS);
    }


    @PreDestroy
    public void destroy() {
        this.runningTask.cancel(true);
    }

}
