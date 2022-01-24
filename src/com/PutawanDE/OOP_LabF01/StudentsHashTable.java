package com.PutawanDE.OOP_LabF01;

import java.util.HashMap;
import java.util.Map;

public class StudentsHashTable {
    private Map<Integer, Student> map = new HashMap<>();

    public Student put(int id, Student student) {
        return map.put(id, student);
    }

    public Student get(int id) {
        return map.get(id);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
