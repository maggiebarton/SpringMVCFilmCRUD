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
	
//	@RequestMapping(path="getFilm.do", method=RequestMethod.GET)
//	public String getFilm(@RequestParam Integer filmId, Model model) {
//		System.out.println("filmID:" + filmId);
//		model.addAttribute("filmId", filmId);
//		return "WEB-INF/film.jsp";
//	}
	
	@RequestMapping(path = "getFilm.do", method = RequestMethod.GET, params = "filmId")
	public ModelAndView getFilmById(int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/film.jsp");
		mv.addObject("films", dao.findFilmById(filmId));
		return mv;
	}
	
	@RequestMapping(path = "getFilm.do", method = RequestMethod.GET, params = "keyword")
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/film.jsp");
		mv.addObject("films", dao.findFilmsByKeyword(keyword));
		return mv;
	}
	
	@RequestMapping(path = "addFilm.do", method = RequestMethod.GET, params = "film")
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		
		//maybe we make a new .jsp for this?
		mv.setViewName("WEB-INF/film.jsp");
		mv.addObject("film", dao.createFilm(film));
		return mv;
	}
	
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.GET, params = "film")
	public ModelAndView deleteFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		
		//maybe we make a new .jsp for this?
		mv.setViewName("WEB-INF/film.jsp");
		mv.addObject("film", dao.deleteFilm(film));
		return mv;
	}
}
