package com.Services.StaffServices;

import com.InputOutputServices.Readers.ReaderJson;
import com.InputOutputServices.Writers.WriterJson;
import com.Services.AbstractClasses.Service;

public class StaffService extends Service {

    public StaffService(ReaderJson readerJson,WriterJson writerJson){
        super(readerJson,writerJson);
    }

}
