package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PASS = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver");
			throw new RuntimeException("Unable to load MySQL Driver class");
		}
	}

	@Override
	public Film findFilmById(int filmId) {

		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
//
			String sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet filmResult = stmt.executeQuery();

			if (filmResult.next()) {
				film = new Film(); // Create the object

				// map query columns to our object fields

				film.setFilmId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getShort("release_year"));
				film.setLangId(filmResult.getInt("language_id"));
				film.setRentDur(filmResult.getInt("rental_duration"));
				film.setRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setRepCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setFeatures(filmResult.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId)); // a film has actors
			}

			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {

		Actor actor = null;
		try {

			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			String sql = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);

			ResultSet actorResult = stmt.executeQuery();

			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setActorId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
				actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
			}

			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			String sql = "SELECT * FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
//				Film film = new Film();
				Film film = new Film(id, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			// String test = "select * from film where (title like '%data%') or (description
			// like '%data%')";
			String sql = "select * from film where (title like ?) or (description like ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
//					Film film = new Film();
				Film film = new Film(id, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	// new DB methods for group project

	@Override
	public Actor createActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			// start transaction
			conn.setAutoCommit(false);

			String sql = "INSERT INTO actor (first_name, last_name) " + " VALUES (?,?)";

			// prepare statement and generate key(s)
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// set bind variables
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());

			// execute update (tells us how many rows were affected or 0 if nothing
			// happened)
			int updateCount = stmt.executeUpdate();

			// if the count is what we expected, add key(s) to result set
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();

				// assign actor ID and films
				if (keys.next()) {
					int newActorId = keys.getInt(1);
					actor.setActorId(newActorId);

					// if actor has films, insert film IDs into film_actor table
					if (actor.getFilms() != null && actor.getFilms().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Film film : actor.getFilms()) {
							stmt.setInt(1, film.getFilmId());
							stmt.setInt(2, newActorId);

							// execute update
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				actor = null;
			}

			// commit transaction
			conn.commit();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + actor);
		}
		return actor;
	}

	@Override
	public boolean updateActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			// start transaction
			conn.setAutoCommit(false);

			String sql = "UPDATE actor SET first_name=?, last_name=? " + " WHERE id=?";

			// prepare statement
			PreparedStatement stmt = conn.prepareStatement(sql);

			// bind variables using the actor object with potentially new information, even
			// if nothing changed here it will still update with the same values
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			stmt.setInt(3, actor.getActorId());

			// execute update
			int updateCount = stmt.executeUpdate();

			// if count is what we expected, update film_actor table (required because of
			// the association of keys from actor & film_actor)
			if (updateCount == 1) {
				// delete film associations in film_actor
				sql = "DELETE FROM film_actor WHERE actor_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, actor.getActorId());

				// execute delete
				updateCount = stmt.executeUpdate();

				// insert film associations in film_actor (even if they end up the same as
				// before - because at this moment in the code it's empty)
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);
				for (Film film : actor.getFilms()) {
					stmt.setInt(1, film.getFilmId());
					stmt.setInt(2, actor.getActorId());

					// execute update
					updateCount = stmt.executeUpdate();
				}
			conn.commit();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			// start transaction
			conn.setAutoCommit(false);

			// delete from child table first
			String sql = "DELETE FROM film_actor WHERE actor_id = ?";

			// prepare statement and set bind variable
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getActorId());

			// execute update
			int updateCount = stmt.executeUpdate();

			// delete from parent table next
			sql = "DELETE FROM actor WHERE id = ?";

			// prepare statement and bind variable
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getActorId());

			// execute delete
			updateCount = stmt.executeUpdate();

			// commit
			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			// start transaction
			conn.setAutoCommit(false);

			String sql = "insert into film (title, description, release_year, language_id) values (?,?,?,?)";

			// prepare statement and generate key(s)
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// set bind variables
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLangId());

			// execute update (tells us how many rows were affected or 0 if nothing
			// happened)
			int updateCount = stmt.executeUpdate();

			// if the count is what we expected, add key(s) to result set
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();

				// assign Film ID and actors
				if (keys.next()) {
					int newFilmID = keys.getInt(1);
					film.setFilmId(newFilmID);

					// if film has actors, insert actor IDs into film_actor table
					if (film.getActors() != null && film.getActors().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Actor actor : film.getActors()) {
							stmt.setInt(1, newFilmID);
							stmt.setInt(2, actor.getActorId());

							// execute update
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				film = null;
			}

			// commit transaction
			conn.commit();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting film " + film);
		}
		return film;
	}

	@Override
	public boolean deleteFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			// start transaction
			conn.setAutoCommit(false);

			// delete from film table table (only deleting films we added, so no child table
			// is dependent)
			String sql = "delete from film where id = ?";

			// prepare statement and set bind variable
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getFilmId());

			// execute delete
			int updateCount = stmt.executeUpdate();

			// commit
			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean updateFilm(Film film) {
		System.out.println("***********************" + film);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			// start transaction
			conn.setAutoCommit(false);

			String sql = "update film set title=?, description=?, release_year=?, language_id=?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=? "
					+ " WHERE id=?";

			// prepare statement
			PreparedStatement stmt = conn.prepareStatement(sql);

			// bind variables using the film object with potentially new information, even
			// if nothing changed here it will still update with the same values
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLangId());
			stmt.setInt(5, film.getRentDur());
			stmt.setDouble(6, film.getRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getRepCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getFeatures());
			stmt.setInt(11, film.getFilmId());

			// execute update
			int updateCount = stmt.executeUpdate();

			// commit
			conn.commit();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film findFilmCategory(Film film) {
		String category = "";

		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);

			// select c.name from category c join film_category fc on fc.category_id = c.id
			// join film f on f.id = fc.film_id where f.id = 13;
			String sql = "select c.name from category c join film_category fc on fc.category_id = c.id join film f on f.id = fc.film_id where f.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getFilmId());

			ResultSet catResult = stmt.executeQuery();
			if (catResult.next()) {
				category = catResult.getString("name");
				film.setCategory(category);
			}
			catResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}
}