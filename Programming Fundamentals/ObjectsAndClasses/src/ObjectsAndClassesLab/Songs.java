package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
   static class Song {
       String typeList;
       String name;
       String time;

       public void setSong(String typeList, String name, String time) {
           this.typeList = typeList;
           this.name = name;
           this.time = time;
       }

       public String getTypeList(){
           return this.typeList;
       }

       public String getName() {
           return this.name;
       }

       public String getTime() {
           return this.time;
       }
   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int songsCount = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 0; i < songsCount; i++) {
            Song songs = new Song();
            String[] currentSong = scanner.nextLine().split("_");
            String typeList = currentSong[0];
            String name = currentSong[1];
            String time = currentSong[2];

            songs.setSong(typeList, name, time);
            songList.add(songs);
        }
        String input = scanner.nextLine();

            if (input.equals("all"))    {
                for (Song song : songList) {
                    System.out.println(song.getName());
                }
        }   else {
                for (Song song : songList)  {
                    if (song.getTypeList().equals(input))   {
                        System.out.println(song.getName());
                    }
                }
            }
    }
}
