package com.InputOutputServices.Writers;

import com.DataBase.Entetys.Employee;
import com.InputOutputServices.interfaces.Writable;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WriterJson implements Writable {
    public void write(Map<String, Employee> data){

        File path=new File("src/com/DataBase/DataJson/Data.json").getAbsoluteFile();

        List<Employee> Persons=new ArrayList<>(data.values());
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer();
        try {
            writer.writeValue(path, Persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
