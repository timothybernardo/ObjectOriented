import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassAdapter extends MP3Player implements StreamingService {
  private Set<String> library = new HashSet<>();
  private Map<String, List<String>> playlists = new HashMap<>();
  private Map<String, Integer> playCount = new HashMap<>();

  @Override
  public void stream(String songId) {
    play(songId);
    int count = playCount.getOrDefault(songId, 0);
    playCount.put(songId, count + 1);
  }

  @Override
  public void pauseStream() {
    pause();
  }

  @Override
  public void createPlaylist(String name, List<String> songIds) {
    playlists.put(name, songIds);
  }

  @Override
  public void addToLibrary(String songId) {
    library.add(songId);
  }

  @Override
  public List<String> getLibrary() {
    Set<String> combined = new HashSet<>(library);
    combined.addAll(getLocalFiles());
    return new ArrayList<>(combined);
  }

  @Override
  public Map<String, Integer> getStreamStats() {
    return playCount;
  }
}
