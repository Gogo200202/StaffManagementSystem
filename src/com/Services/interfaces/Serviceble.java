package com.Services.interfaces;

import com.DataBase.Entetys.Employee;
import com.InputOutputServices.Readers.ReaderJson;
import com.InputOutputServices.Writers.WriterJson;

import java.util.Map;

public interface Serviceble {

    public Map<String, Employee> inMemoryDatabase = null;
    public com.InputOutputServices.Readers.ReaderJson ReaderJson = null;
    public com.InputOutputServices.Writers.WriterJson WriterJson = null;
}
