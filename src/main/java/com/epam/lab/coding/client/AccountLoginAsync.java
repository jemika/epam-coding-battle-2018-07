package com.epam.lab.coding.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface AccountLoginAsync {

  void accountServer(String name, AsyncCallback<String> async);
}
