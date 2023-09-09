package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmsByKeyword(String keyword);

	public Actor createActor(Actor actor);

	public boolean updateActor(Actor actor);

	public boolean deleteActor(Actor actor);
	
	public Film createFilm(Film film);
	
	public boolean deleteFilm(Film film);

	public boolean updateFilm(Film film);

	public Film findFilmCategory(Film film);

}
