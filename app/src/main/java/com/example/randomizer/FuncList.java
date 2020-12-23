package com.example.randomizer;

public class FuncList {
    private String[] array;

    public FuncList(String[] array) {
        this.setArray(array);
    }

    public String pop(int pos) {
        String[] out = new String[this.array.length - 1];
        String item = null;

        int j = 0;
        for(int i = 0; i<array.length; i++) {
            if(i != pos) {
                out[j] = array[i];
                j+=1;
            }
            else
                item = array[i];
        }
        array = out;
        return item;
    }

    public int length() {
        return this.array.length;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }
}
