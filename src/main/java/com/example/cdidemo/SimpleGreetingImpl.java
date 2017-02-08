package com.example.cdidemo;

import java.io.Serializable;

public class SimpleGreetingImpl implements Greeting, Serializable {

	public SimpleGreetingImpl() {
	}
	
    @Override
    public String getText() {
        return "Hello, World!";
    }
}