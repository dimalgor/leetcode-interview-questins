package com.gorban.easy.lambdas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaStreams {

    public static void main(String[] args){
        // Example 3.16
        int sum = Stream.of(1,2,3,4)
                .reduce(0, (accumulator, element) -> accumulator + element);
        System.out.println("Summary: " + sum);

        // Example 3.18
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int sumWithAccum = accumulator.apply(accumulator.apply(accumulator.apply(0,1),2),3);
        System.out.println("Sum with accumulator: " + sumWithAccum);

        // Example

        ArrayList<Artist> album2Artists = new ArrayList<>();
        album2Artists.add(new Artist("The Artist4", "Ukraine"));
        album2Artists.add(new Artist("Artist5", "Nationality5"));
        album2Artists.add(new Artist("The Artist6", "USA"));

        Album album1 = new Album("Album2", album2Artists);

        Set<String> origins = album1.getArtists()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());

        System.out.println("Origins: " + origins);

        // Example 3.20
        List<Track> tracks = List.of(new Track(90, "Track1"),
                new Track(60, "Track2"),
                new Track(90, "Track3"));
        List<Album> albums = List.of(new Album("Album1", album2Artists, tracks));

        System.out.println("Long tracks: " + findLongTracks(albums));

        // Example 3.21
        System.out.println("Long tracks 2: " + findLongTracks2(albums));

        // Example 3.22
        System.out.println("Long tracks 3: " + findLongTracks3(albums));

        // Example 3.23
        System.out.println("Long tracks 4: " + findLongTracks4(albums));

        // Exercise 1a
        int sumUp = addUp(List.of(1,2,3,4,5).stream());
        System.out.println("sumUp: " + sumUp);

        // Exercise 1b


    }

    // exercise 1a
    private static int addUp(Stream<Integer> numbers){
        return numbers
                .map(num -> num.intValue())
                .reduce(0, (num1, num2) -> num1 + num2);
    }

    private static Set<String> findLongTracks4(List<Album> albums){
        return albums.stream()
                .flatMap(album -> album.getTracksStream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }

    private static Set<String> findLongTracks3(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(album -> album.getTracksStream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));

        return trackNames;
    }

    private static Set<String> findLongTracks(List<Album> albums){
        Set<String> trackNames = new HashSet<>();

        albums.stream().forEach(album -> {
            album.getTracks().forEach(track -> {
                if (track.getLength() > 60){
                    String name = track.getName();
                    trackNames.add(name);
                }
            });
        });

        return trackNames;
    }

    private static Set<String> findLongTracks2(List<Album> albums){
        Set<String> trackNames = new HashSet<>();

        albums.stream().forEach(album -> {
            album.getTracks().stream()
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> trackNames.add(name));
        });

        return trackNames;
    }

    public static class Track {
        private int length;
        private String name;

        public Track(int length, String name) {
            this.length = length;
            this.name = name;
        }

        public int getLength() {
            return length;
        }

        public String getName() {
            return name;
        }
    }

    public static class Album{
        private String name;
        private List<Artist> artists;
        private List<Track> tracks;


        public Album(String name, List<Artist> artists, List<Track> tracks) {
            this.name = name;
            this.artists = artists;
            this.tracks = tracks;
        }

        public Album(String name, ArrayList<Artist> artists) {
            this.name = name;
            this.artists = artists;
        }

        public String getName() {
            return name;
        }

        public Stream<Artist> getArtists() {
            return artists.stream();
        }

        public List<Track> getTracks() {
            return tracks;
        }

        public Stream<Track> getTracksStream() {
            return tracks.stream();
        }
    }

    public static class Artist{
        private String name;
        private String nationality;

        public Artist(String name, String nationality) {
            this.name = name;
            this.nationality = nationality;
        }

        public String getName() {
            return name;
        }

        public String getNationality() {
            return nationality;
        }
    }

}
