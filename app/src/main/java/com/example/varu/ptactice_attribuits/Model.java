package com.example.varu.ptactice_attribuits;

/**
 * Created by varu on 26-12-2017.
 */

public class Model {

    private String values;
    private int res;
    
    public String getName() {
        return values;
    }

    public int getRes() {
        return res;
    }


    public Model(String name, int res) {
        this.values = name;
        this.res = res;
    }

    @Override
    public String toString() {
        return values;
    }
}
