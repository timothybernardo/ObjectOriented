import java.util.LinkedList;
import java.util.Queue;

public class LegacyToStreamingAdapter implements LegacyMusicPlayer, StreamingService {
  // ============ YOUR TASK ============

  /*
   * PROBLEM: You need to make OldMusicLibrary work with the StreamingService interface.
   *
   * REQUIREMENTS:
   * 1. Your adapter should make the legacy player work with the modern interface
   * 2. Consider these scenarios:
   *    - You might need to support multiple legacy player implementations in the future
   *    - The legacy system might be updated occasionally (but interface stays same)
   *    - Your app needs to treat all music sources uniformly through StreamingService
   *
   * DECISIONS TO MAKE:
   * 1. Should you use a CLASS adapter or OBJECT adapter? Why?
   * 2. How will you handle the mismatch between pause/resume vs stop/play?
   * 3. How will you implement queue functionality that doesn't exist in legacy?
   *
   * IMPLEMENT YOUR SOLUTION BELOW:
   */
  private final LegacyMusicPlayer adaptee;
  private final Queue<String> songQueue;
  private boolean isPaused;
  private String lastPausedSong;

  public LegacyToStreamingAdapter(LegacyMusicPlayer adaptee, Queue<String> songQueue) {
    if (adaptee == null) {
      throw new IllegalArgumentException("Cannot be null");
    }
    this.adaptee = adaptee;
    this.songQueue = new LinkedList<>();
    this.isPaused = false;
    this.lastPausedSong = null;
  }

  @Override
  public void playSong(String songId) {
    adaptee.playSong(songId);
  }

  @Override
  public void stopMusic() {
    adaptee.stopMusic();
  }

  @Override
  public String getCurrentSong() {
    return adaptee.getCurrentSong();
  }

  @Override
  public boolean isPlaying() {
    return adaptee.isPlaying();
  }

  @Override
  public void stream(String trackUri) {
    isPaused = false;
    lastPausedSong = null;
    adaptee.playSong(trackUri);
  }

  @Override
  public void pause() {
    if (adaptee.isPlaying()) {
      lastPausedSong = adaptee.getCurrentSong();
      adaptee.stopMusic();
      isPaused = true;
      System.out.println("Paused song: " + lastPausedSong);
    }
  }

  @Override
  public void resume() {
    if (isPaused && lastPausedSong != null) {
      adaptee.playSong(lastPausedSong);
      isPaused = false;
      System.out.println("Playing song: " + lastPausedSong);
    }
  }

  @Override
  public void addToQueue(String trackUri) {
    songQueue.add(trackUri);
    System.out.println("Adapter: Added " + trackUri + " to queue");

    // If nothing is playing, start playing from queue
    if (!adaptee.isPlaying() && !isPaused) {
      playNextInQueue();
    }
  }

  @Override
  public TrackInfo getTrackInfo() {
    String currentSong = adaptee.getCurrentSong();
    if (currentSong == null) {
      return null;
    }
    return new TrackInfo(currentSong, "Track " + currentSong, 180);
  }

  @Override
  public PlayerState getPlayerState() {
    if (isPaused) {
      return PlayerState.PAUSED;
    } else if (isPlaying()) {
      return PlayerState.PLAYING;
    } else {
      return PlayerState.STOPPED;
    }
  }

  // Helper method to play next song in queue
  private void playNextInQueue() {
    if (!songQueue.isEmpty()) {
      String nextSong = songQueue.poll();
      stream(nextSong);
    }
  }
}
