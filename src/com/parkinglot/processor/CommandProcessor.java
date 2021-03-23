package com.parkinglot.processor;

import com.command.constant.CommandType;
import com.parkinglot.model.CommandDTO;

public interface CommandProcessor {

	 public boolean validate(CommandDTO commandDto);

     public abstract void execute(CommandDTO commandDto);
     
}
