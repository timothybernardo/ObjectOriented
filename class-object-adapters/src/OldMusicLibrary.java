public class OldMusicLibrary implements LegacyMusicPlayer {
  private String currentSong = null;
  private boolean playing = false;

  @Override
  public void playSong(String songId) {
    currentSong = songId;
    playing = true;
    System.out.println("Legacy player: Playing song " + songId);
  }

  @Override
  public void stopMusic() {
    playing = false;
    System.out.println("Legacy player: Stopped");
  }

  @Override
  public String getCurrentSong() {
    return currentSong;
  }

  @Override
  public boolean isPlaying() {
    return playing;
  }
}
