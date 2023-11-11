package com.Services.AbstractClasses;

import com.DataBase.Entetys.Employee;
import com.InputOutputServices.Readers.ReaderJson;
import com.InputOutputServices.Writers.WriterJson;
import com.Services.interfaces.Serviceble;

import java.util.HashMap;
import java.util.Map;

public abstract class Service implements Serviceble {

    public Map<String, Employee> inMemoryDatabase;
    public ReaderJson ReaderJson;
    public WriterJson WriterJson;
    public Service(ReaderJson reader, WriterJson writerJson){

        this.WriterJson = writerJson;
        this.ReaderJson=reader;

        this.inMemoryDatabase=reader.read();
    }

}
