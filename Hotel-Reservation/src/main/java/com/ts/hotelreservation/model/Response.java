package com.ts.hotelreservation.model;


public class Response {

	private int operationStatus;
	private Object resultSet= null;
	
	
	public int getOperationStatus() {
		return operationStatus;
	}


	public void setOperationStatus(int operationStatus) {
		this.operationStatus = operationStatus;
	}


	public Object getResultSet() {
		return resultSet;
	}


	public void setResultSet(Object resultSet) {
		this.resultSet = resultSet;
	}


	@Override
	public String toString() {
		return "Response [operationStatus=" + operationStatus + ", resultSet=" + resultSet + "]";
	}
	
	
}
