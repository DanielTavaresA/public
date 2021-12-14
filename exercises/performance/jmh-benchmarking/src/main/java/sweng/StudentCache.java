package sweng;

import java.util.HashMap;

public class StudentCache implements Cache<Integer, Student>{

    private HashMap<Integer, Student> map;

    public StudentCache() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean contains(Integer key) {
        return map.containsKey(key);
    }

    @Override
    public void put(Integer key, Student value) {
        map.put(key, value);
    }

    @Override
    public Student get(Integer key) {
        return map.get(key);
    }

    @Override
    public void clear() {
        map = new HashMap<>();
    }
}
