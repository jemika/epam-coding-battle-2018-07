package com.epam.lab.coding.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface Greeting extends RemoteService {
    String greetServer(String name) throws IllegalArgumentException;
}
