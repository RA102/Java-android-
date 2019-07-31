package it.step.sixlesson.model;

import java.util.List;

public class TypesResponse {
    private List<Type> data;
    private int total;
    private int from;

    public TypesResponse() {
    }

    public TypesResponse(List<Type> data, int total, int from) {
        this.data = data;
        this.total = total;
        this.from = from;
    }

    public List<Type> getData() {
        return data;
    }

    public void setData(List<Type> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
}
