package com.nanopay.iptvapp;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

public class PlayerActivity extends AppCompatActivity {
  private ExoPlayer player;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    PlayerView playerView = new PlayerView(this);
    setContentView(playerView);

    String url = getIntent().getStringExtra("url");
    if (url == null) url = "";

    player = new ExoPlayer.Builder(this).build();
    playerView.setPlayer(player);

    MediaItem mediaItem = MediaItem.fromUri(Uri.parse(url));
    player.setMediaItem(mediaItem);
    player.prepare();
    player.play();
  }

  @Override
  protected void onStop() {
    super.onStop();
    if (player != null) {
      player.release();
      player = null;
    }
  }
}
