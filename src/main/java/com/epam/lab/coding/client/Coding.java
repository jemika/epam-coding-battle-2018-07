package com.epam.lab.coding.client;

import com.epam.lab.coding.client.services.AccountService;
import com.epam.lab.coding.client.services.AccountServiceAsync;
import com.epam.lab.coding.client.widgets.LoginDialogBox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;

public class Coding implements EntryPoint {

  private final AccountServiceAsync accountService = GWT.create(AccountService.class);
  private LoginDialogBox loginDialogBox;
  private final FlexTable userInfoTable = new FlexTable();

  @Override
  public void onModuleLoad() {

    userInfoTable.setText(0, 0, "Name");
    userInfoTable.setText(0, 1, "Avatar");
    userInfoTable.setText(0, 2, "SteamId");
    userInfoTable.setText(0, 3, "Remained attempts");

    loginDialogBox = new LoginDialogBox((userName, password)
        -> accountService.login(userName, password, new AsyncCallback<OurUser>() {
      @Override
      public void onSuccess(OurUser user) {
        if (user != null) {
          loginDialogBox.hide();
          RootPanel.get().remove(loginDialogBox);

          userInfoTable.setText(1, 0, user.getUser().getName());
          userInfoTable.setText(1, 1, user.getUser().getUrl());
          userInfoTable.setText(1, 2, String.valueOf(user.getUser().getId()));
          userInfoTable.setText(1, 3, String.valueOf(user.getAttempts()));

          RootPanel.get().add(userInfoTable);
        } else {
          Window.alert("User is not registered");
        }
      }

      @Override
      public void onFailure(Throwable caught) {
        // LOG.log(Level.SEVERE, caught.getMessage());
      }
    }));
    RootPanel.get().add(loginDialogBox);
    loginDialogBox.show();
    loginDialogBox.center();
  }
}
