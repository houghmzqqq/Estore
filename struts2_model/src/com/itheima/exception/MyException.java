package com.itheima.exception;

public class MyException extends Exception 
{
	public MyException(){}
	
	public MyException(String exception_msg)
	{
		super(exception_msg);
	}
}
