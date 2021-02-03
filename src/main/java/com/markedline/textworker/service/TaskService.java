package com.markedline.textworker.service;

import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;

public interface TaskService {

    AbstractResult solve(AbstractInputData inputData);
}
