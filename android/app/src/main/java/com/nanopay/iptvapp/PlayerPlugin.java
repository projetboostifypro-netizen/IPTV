package com.nanopay.iptvapp;

import android.content.Intent;
import com.getcapacitor.*;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Player")
public class PlayerPlugin extends Plugin {

  @PluginMethod
  public void open(PluginCall call) {
    String url = call.getString("url");
    String title = call.getString("title", "Player");

    if (url == null || url.trim().isEmpty()) {
      call.reject("URL manquante");
      return;
    }

    Intent i = new Intent(getContext(), PlayerActivity.class);
    i.putExtra("url", url);
    i.putExtra("title", title);
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    getContext().startActivity(i);

    call.resolve();
  }
}
