package com.epam.lab.coding.client.services;

import com.epam.lab.coding.client.OurUser;
import com.epam.lab.coding.client.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("accounts")
public interface AccountService extends RemoteService {

  OurUser login(String userName, String password);

}

