package com.rong;

class test{
    int fun(int i1, int i2){
        return Math.max(i1, i2);
    }
    double fun(double d1, double d2, double d3){
        return d1 * d2 * d3;
    }
    String fun(String s1, String s2){
        return s1.equals(s2)?"相同":"不同";
    }
    int fun(double d1, double d2){
        return (int) (d1 / d2);
    }
}