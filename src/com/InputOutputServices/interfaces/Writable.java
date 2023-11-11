package com.InputOutputServices.interfaces;

import com.DataBase.Entetys.Employee;

import java.util.Map;

public interface Writable {
    public void write(Map<String, Employee> data);
}
