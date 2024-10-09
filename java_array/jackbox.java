import java.util.*;

public class jackbox {
    
    public static void main(String[] args) {
        new jackbox().go();
    }
    
    public void go() {
        List<String> songList = MockSongs.getSongStrings();
        Collections.sort(songList);  // Sorting the song list
        System.out.println(songList);  // Printing the sorted list
    }
}

class MockSongs {
    public static List<String> getSongStrings() {
        List<String> songs = new ArrayList<>();
        songs.add("This");
        songs.add("That");
        songs.add("Those");
        songs.add("These");
        songs.add("Thought");
        songs.add("They");
        return songs;
    }
}
