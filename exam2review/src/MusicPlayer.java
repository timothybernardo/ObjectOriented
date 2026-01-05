/* ============================================================================
 * SCENARIO: You have an old MusicPlayer interface and a new StreamingService
 * interface. You need to make old MusicPlayer implementations work with code
 * that expects the new StreamingService interface.
 * ============================================================================ */

import java.util.List;

// OLD INTERFACE (Adaptee)
interface MusicPlayer {
  void play(String filename);

  void pause();

  void stop();

  int getCurrentPosition(); // returns seconds

  List<String> getLocalFiles();
}