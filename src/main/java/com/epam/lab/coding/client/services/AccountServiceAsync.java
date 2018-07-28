package com.epam.lab.coding.client.services;

import com.epam.lab.coding.client.OurUser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AccountServiceAsync {

  OurUser login(String userName, String password, AsyncCallback<OurUser> async);
}
