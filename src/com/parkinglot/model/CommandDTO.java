package com.parkinglot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.command.constant.CommandType;

public class CommandDTO {

	private CommandType commandType;
	
	private List<String> commandArray;
	
	public CommandDTO(String inputCommands) {
	   
		List<String> commandsArray = new ArrayList<>(Arrays.asList(inputCommands.split(" ")));
	    this.commandType = CommandType.valueOf(commandsArray.get(0).trim());
	    commandsArray.remove(0);
	    this.commandArray = commandsArray;
	}

	public CommandType getCommandType() {
		return commandType;
	}

	public void setCommandType(CommandType commandType) {
		this.commandType = commandType;
	}

	public List<String> getCommandArray() {
		return commandArray;
	}

	public void setCommandArray(List<String> commandArray) {
		this.commandArray = commandArray;
	}
	
}
