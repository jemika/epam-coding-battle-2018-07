package com.epam.lab.coding.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface AccountServiceAsync {

  void login(String userName, String password, AsyncCallback<Boolean> async);
}
