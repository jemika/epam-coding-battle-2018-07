package com.epam.lab.coding.client;

import com.google.gwt.core.client.JavaScriptObject;
import java.io.Serializable;

public class User extends JavaScriptObject implements Serializable {

  protected User() {}

  public final native int getId()/*-{ return this.steamid; }-*/;
  public final native String getName()/*-{ return this.realname; }-*/;
  public final native String getUrl()/*-{ return this.url; }-*/;
}

