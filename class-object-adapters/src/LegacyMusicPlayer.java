public interface LegacyMusicPlayer {
  void playSong(String songId);

  void stopMusic();

  String getCurrentSong();

  boolean isPlaying();
}
