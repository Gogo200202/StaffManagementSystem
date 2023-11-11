package com.InputOutputServices.Readers;

import com.DataBase.Entetys.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.InputOutputServices.interfaces.Readable;

public class ReaderJson implements Readable {
    public Map<String, Employee> read(){
        File path=new File("src/com/DataBase/DataJson/Data.json").getAbsoluteFile();
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String,Employee> map = new HashMap<>();
            List<Employee> ListOfJsonObjects = Arrays.asList(mapper.readValue(path, Employee[].class));
            map=ListOfJsonObjects.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
            return map;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
