package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private FilmDAO dao;

	@RequestMapping(path = "getFilm.do", method = RequestMethod.GET, params = "filmId")
	public ModelAndView getFilmById(int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/singleFilm.jsp");
		Film film = dao.findFilmById(filmId);
		if (film != null) {
			dao.findFilmCategory(film);
		}
		mv.addObject("film", film);
		return mv;
	}

	@RequestMapping(path = "getFilm.do", method = RequestMethod.GET, params = "keyword")
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/films.jsp");
		mv.addObject("films", dao.findFilmsByKeyword(keyword));
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.GET, params = { "title", "description", "releaseYear",
			"langId" })

	// , "rentDur", "rate", "length", "repCost", "rating", "features"
	public ModelAndView addFilm(String title, String description, short releaseYear, int langId, int rentDur,
			double rate, int length, double repCost, String rating, String features) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		// to do: actors?
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLangId(langId);
		film.setRentDur(rentDur);
		film.setRate(rate);
		film.setLength(length);
		film.setRepCost(repCost);
		film.setRating(rating);
		film.setFeatures(features);

		mv.setViewName("WEB-INF/singleFilm.jsp");
		mv.addObject("film", dao.createFilm(film));
		return mv;
	}

	@RequestMapping(path = "updateFilmForm.do", params = "filmId")
	public ModelAndView updateFilmForm(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/updateFilmForm.jsp");
		return mv;
	}

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilmForm(Film film) {
		ModelAndView mv = new ModelAndView();
		dao.updateFilm(film);
		mv.setViewName("WEB-INF/updateStatus.jsp");
		mv.addObject("film", dao.findFilmById(film.getFilmId()));
		return mv;
	}

	// NOT WORKING YET
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.GET, params = "filmId")
	public ModelAndView deleteFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film filmToDelete = dao.findFilmById(filmId);
		dao.deleteFilm(filmToDelete);
		Film testIfFilmDeleted = dao.findFilmById(filmId);
		mv.setViewName("WEB-INF/deleteStatus.jsp");
		mv.addObject("film", testIfFilmDeleted);
		return mv;
	}
}
