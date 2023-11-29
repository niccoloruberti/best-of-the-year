package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
		public String index(Model model) {
		
			String name = "Niccolo\'";
			
			model.addAttribute("name", name);
			
			return "step1";
		}
	
	private List<Movie> getBestMovies() {
		
		List <Movie> movies = new ArrayList<Movie>();
		
		Movie m1 = new Movie(1, "Lo stagista");
		
		movies.add(m1);
		
		Movie m2 = new Movie(2, "The wolf of wall street");
		
		movies.add(m2);
		
		Movie m3 = new Movie(3, "Dune");
		
		movies.add(m3);
		
		return movies;
	}
	
	@GetMapping("/movies")
		public String moviesList(Model model) {
		
		List<Movie> moviesList = getBestMovies();
		
		model.addAttribute("moviesList", moviesList);
		
		return "movies";
	}
	
	private List<Song> getBestSongs() {
		
		List <Song> songs = new ArrayList<Song>();
		
		Song s1 = new Song(1, "Wanna Play?");
		
		songs.add(s1);
		
		Song s2 = new Song(2, "Lovely Day To Die");
		
		songs.add(s2);
		
		Song s3 = new Song(3, "Jolene");
		
		songs.add(s3);
		
		return songs;
		}

	@GetMapping("/songs")
	public String songsList(Model model) {
	
	List<Song> songsList = getBestSongs();
	
	model.addAttribute("songsList", songsList);
	
	return "songs";
		
	}

	@GetMapping("/movies/{id}")
	public String showMovie(Model model, @PathVariable int id) {
		
        Movie movie = null;
        
        for (Movie m : getBestMovies()) {
            
            if (m.getId() == id) {
                movie = m;    
            }
        }
        
        if (movie == null) {
            movie = new Movie(id, "movie not found");
        }
        
        model.addAttribute("movie", movie);
        
        return "showMovie";
    }
	
	@GetMapping("/songs/{id}")
	public String showSong(Model model, @PathVariable int id) {
		
        Song song = null;
        
        for (Song s : getBestSongs()) {
            
            if (s.getId() == id) {
                song = s;    
            }
        }
        
        if (song == null) {
            song = new Song(id, "song not found");
        }
        
        model.addAttribute("song", song);
        
        return "showSong";
    }
	
	
	
}
