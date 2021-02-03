package com.markedline.textworker.exchange;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface UserRequestHandler {

    void handle(ObjectInputStream reader, ObjectOutputStream writer);
}
