package cn.cslg.bus_ZB1018144;

import org.litepal.crud.LitePalSupport;

/**
 * Created by Alice on 2019/12/21.
 */
public class History extends LitePalSupport {
    private int id;
    private String start;
    private String end;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
