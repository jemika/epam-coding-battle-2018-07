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
  private final FlexTable userInfoTable = new FlexTable();

  @Override
  public void onModuleLoad() {

    userInfoTable.setText(0, 0, "Name");
    userInfoTable.setText(0, 1, "Avatar");
    userInfoTable.setText(0, 2, "SteamApiKey");
    userInfoTable.setText(0, 3, "Remained attempts");

    loginDialogBox = new LoginDialogBox((userName, password) -> {
      accountService.login(userName, password, new AsyncCallback<Boolean>() {
        @Override
        public void onSuccess(Boolean isLoggedIn) {
          if (isLoggedIn) {
            loginDialogBox.hide();
            RootPanel.get().remove(loginDialogBox);
            //TEMPORARY

            OurUser user = new OurUser("user123", "123","Steam User", "0EE6E555212B0399670196862E5A30DE");

            userInfoTable.setText(1, 0, user.getName());
            userInfoTable.setText(1, 1, "IMAGE");
            userInfoTable.setText(1, 2, user.getSteamApiKey());
            userInfoTable.setText(1, 3, "6");

            //TEMPORARY

            RootPanel.get().add(userInfoTable);
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
