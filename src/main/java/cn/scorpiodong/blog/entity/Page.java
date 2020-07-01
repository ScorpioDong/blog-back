package cn.scorpiodong.blog.entity;

import java.util.List;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/7/1 7:24 下午
 */
public class Page<T> {
    private int current;
    private int size;
    private int total;
    private List<T> records;
    private int pages;

    public Page(int current, int size) {
        this.current = current;
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
