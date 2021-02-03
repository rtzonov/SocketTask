package com.markedline.textworker.exchange.impl;

import com.markedline.textworker.exchange.UserRequestHandler;
import com.markedline.textworker.service.TaskFactory;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserRequestHandlerImpl implements UserRequestHandler {

    @Override
    public void handle(ObjectInputStream reader, ObjectOutputStream writer) {
        String command = receiveCommand(reader);
        AbstractInputData inputData = receiveInputData(reader);

        TaskService taskService = TaskFactory.createTask(command);

        AbstractResult result = taskService.solve(inputData);

        sendResult(writer, result);
    }

    private String receiveCommand(ObjectInputStream reader) {
        String command = null;
        try {
            command = (String) reader.readObject();
        } catch (IOException e) {
            System.out.println("Error receiving command: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Command's class is not String: " + e.getMessage());
        }
        return command;
    }

    private AbstractInputData receiveInputData(ObjectInputStream reader) {
        AbstractInputData inputData = null;
        try {
            inputData = (AbstractInputData) reader.readObject();
        } catch (IOException e) {
            System.out.println("Error receiving input data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class of input data is not AbstractInputData or its child: " + e.getMessage());
        }
        return inputData;
    }

    private void sendResult(ObjectOutputStream writer, AbstractResult result) {
        try {
            writer.writeObject(result);
        } catch (IOException e) {
            System.out.println("Error sending result: " + e.getMessage());
        }
    }
}
