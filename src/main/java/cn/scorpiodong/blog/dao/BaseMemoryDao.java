package cn.scorpiodong.blog.dao;

import cn.scorpiodong.blog.entity.BaseEntity;
import cn.scorpiodong.blog.entity.Page;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/6/30 7:38 下午
 */
public class BaseMemoryDao<T extends BaseEntity> {
    protected String path;
    protected List<T> list;
    protected int count = 0;

    protected BaseMemoryDao() {
        this.path = System.getProperty("user.dir") + "/.blog/data/" + this.getClass().getName() + ".yml";
        this.load();
    }

    public void save() {
        try {
            Writer writer = new FileWriter(new File(this.path));
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("count", this.count);
            map.put("list", this.list);
            new Yaml().dump(map, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        File file = new File(this.path);

        if (file.exists()) {
            try {
                Map<String, Object> map = new Yaml().load(new FileInputStream(file));
                this.list = (List<T>) map.get("list");
                this.count = (int) map.get("count");
                return;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.list = new ArrayList<>(5);
        this.count = 0;
    }

    public T select(Integer id) {
        return this.list.get(getIndexById(id));
    }

    public List<T> selectAll() {
        return this.list;
    }

    public Page<T> selectPage(Page<T> page) {
        int current = page.getCurrent();
        int size = page.getSize();
        int listSize = this.list.size();
        int fromIndex = size * (current - 1);
        int toIndex = size * current;
        if (toIndex > listSize) {
            toIndex = listSize;
        }
        page.setTotal(listSize);
        page.setPages(listSize / size + (listSize % size == 0 ? 0 : 1));
        page.setRecords(this.list.subList(fromIndex, toIndex));
        return page;
    }

    public boolean insert(T t) {
        t.setId(this.count++);
        return this.list.add(t);
    }

    public T update(T t) {
        int index = getIndexById(t.getId());
        return this.list.set(index, t);
    }

    public T delete(Integer id) {
        return this.list.remove(getIndexById(id));
    }

    private int getIndexById(Integer id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "BaseMemoryDao{" +
                "path='" + path + '\'' +
                ", list=" + list +
                ", count=" + count +
                '}';
    }
}
