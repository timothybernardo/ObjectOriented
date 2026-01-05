class TrackInfo {
  String trackId;
  String title;
  int durationSeconds;

  TrackInfo(String trackId, String title, int duration) {
    this.trackId = trackId;
    this.title = title;
    this.durationSeconds = duration;
  }
}

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