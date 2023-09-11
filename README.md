
# Spring MVC Film CRUD
Made by Maggie Barton and Sawyer Harnedy


# Overview
Hello and Welcome to our MVC Film Query Web Application! Here you can find data on movies stored in our database by either, entering in the movie's film ID, or a relevant keyword that is contained within the title or description of the film.

Once you have submitted your search, you will come to a page of results. If you chose to search by ID, it will immediately print a page with details about the film pertaining to the associated ID. If you chose to search by a keyword, it will print a list of films that match the search terms. Each film that was presented functions as a hyperlink to the film details page for that film.

You may choose to either delete or update the film you have selected, or even add a new film. You may also choose to add actors to the database, as well as edit and delete actors from the database.

# Technologies Used
- Git/Github
- Eclipse
- HTML/XML/JSP
- Bootstrap/CSS
- MAMP
- SQL
- Java
- Terminal
- Apache Tomcat
- Spring


# Lessons Learned
- Became much more familiar and comfortable with JSP syntax, specifically towards c: functions.
- Being very thorough with mapping and using field names that are not ambiguous. 

- Using DAO and MVC design patterns to pass data between the front and back end of our site, while maintaining a separation of concerns.
	
The biggest obstacle we faced was deciphering how to update rows in the database using the UI in the front end. We found that this required two different methods in the Film Controller, as it was actually a two step process. First, when a user chooses to update information, they are directed to an update form. This form needs the current information of the object stored in the database, in this case, a film or an actor. We used the Controller to reach into the database and pull out the object in it's current state by the unique ID number (Film film = dao.findFilmById(filmId)), and add that object to the view (mv.setViewName("WEB-INF/updateFilmForm.jsp")).
	
	@RequestMapping(path = "updateFilmForm.do", params = "filmId")
	public ModelAndView updateFilmForm(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/updateFilmForm.jsp");
		return mv;
	}

The user will supply the changes to the object via the form on the webpage. These changes need to be passed back to database via the Controller (dao.updateFilm(film)). The user is then directed to a status page, alerting them whether the update worked or failed. To determine if the update worked, we need the object returned in it's new state (mv.addObject("film", dao.findFilmById(film.getFilmId()))). If the database threw an error trying to retrieve the object, the update failed. The logic in our updateStatus.jsp file asks if the object returned is empty (update failed) or not empty (update worked - show the details).

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilmForm(Film film) {
		ModelAndView mv = new ModelAndView();
		dao.updateFilm(film);
		mv.setViewName("WEB-INF/updateStatus.jsp");
		mv.addObject("film", dao.findFilmById(film.getFilmId()));
		return mv;
	}
	
Passing the object's unique ID number was also particularly tricky with the update methods. We didn't want the ID to be an editable field on the form, as users should not be able to change this information; it is assigned by the database. We used a hidden field in the form to associate the ID with the film, but users cannot see it happening on the webpage.
	
	<input type="hidden" name="filmId" value="${film.filmId}">
			
