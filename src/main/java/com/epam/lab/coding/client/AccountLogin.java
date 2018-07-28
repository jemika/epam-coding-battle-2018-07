package com.epam.lab.coding.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

  @RemoteServiceRelativePath("accounts")
  public interface AccountLogin extends RemoteService {
    String accountServer(String name) throws IllegalArgumentException;
  }
