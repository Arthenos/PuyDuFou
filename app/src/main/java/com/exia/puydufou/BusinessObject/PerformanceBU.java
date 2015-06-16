package com.exia.puydufou.BusinessObject;

/**
 * Created by maxim_000 on 16/06/2015.
 */
public class PerformanceBU {


    //region Attributes
    private int id;
    private int startPerformance;
    //endregion

    //region Getters / Setters
    public int getStartPerformance() {
        return startPerformance;
    }

    public void setStartPerformance(int startPerformance) {
        this.startPerformance = startPerformance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //endregion



    public PerformanceBU(int id, int startPerformance) {
        this.id = id;
        this.startPerformance = startPerformance;
    }

}
