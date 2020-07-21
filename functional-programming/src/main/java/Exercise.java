import common.Album;
import common.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qing
 */
public class Exercise {
    static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (a, b) -> a + b);
    }

    static List<String> getArtistInfo(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getName() + "-" + artist.getNationality())
                .collect(Collectors.toList());
    }

    /**
     * @param albums 专辑列表
     * @return 最多包含3首歌曲的专辑组成的列表
     */
    static List<Album> getAlbums(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getMusicianList().size() <= 3)
                .collect(Collectors.toList());
    }

    static int lowerCaseCount(String s) {
        return (int) s.chars()
                .filter(c -> c >= 'a' && c <= 'z')
                .count();
    }

//    static Optional<String> findMaxLowerCaseString(List<String> s) {
//        return s.stream().max(Comparator.comparing())
//    }


    public static void main(String[] args) {
        System.out.println(addUp(Stream.of(1, 23, 544, 5)));

    }
}
