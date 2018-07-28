package com.epam.lab.coding.client;

import com.epam.lab.coding.client.services.AccountService;
import com.epam.lab.coding.client.services.AccountServiceAsync;
import com.epam.lab.coding.client.widgets.LoginDialogBox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import java.util.logging.Level;

public class Coding implements EntryPoint {

  private final AccountServiceAsync accountService = GWT.create(AccountService.class);
  private LoginDialogBox loginDialogBox;

    @Override
    public void onModuleLoad() {

      loginDialogBox = new LoginDialogBox((userName, password) -> {
        accountService.login(userName, password, new AsyncCallback<Boolean>() {
          @Override
          public void onSuccess(Boolean isLoggedIn) {
            if (isLoggedIn) {
              loginDialogBox.hide();
              RootPanel.get().remove(loginDialogBox);

            } else {
              //LOG
            }
          }

          @Override
          public void onFailure(Throwable caught) {
           // LOG.log(Level.SEVERE, caught.getMessage());
          }
        });
      });
      RootPanel.get().add(loginDialogBox);
      loginDialogBox.show();
      loginDialogBox.center();
    }
}
