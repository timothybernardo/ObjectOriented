public interface StreamingService {
  void stream(String trackUri);

  void pause();

  void resume();

  void addToQueue(String trackUri);

  TrackInfo getTrackInfo();

  PlayerState getPlayerState();
}