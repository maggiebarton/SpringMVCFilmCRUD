package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;


public class Film {
	private int filmId;
	private String title;
	private String description;
	private short releaseYear;
	private int langId;
	private int rentDur;
	private double rate;
	private int length;
	private double repCost;
	private String rating;
	private String features;
	private String category;
	private List<Actor> actors;

	public Film() {}
	
	public Film(int id, String title, String description, short releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features) {
		super();
		this.filmId = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}


	public int getFilmId() {
		return filmId;
	}


	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public short getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}


	public int getLangId() {
		return langId;
	}


	public void setLangId(int langId) {
		this.langId = langId;
	}


	public int getRentDur() {
		return rentDur;
	}


	public void setRentDur(int rentDur) {
		this.rentDur = rentDur;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public double getRepCost() {
		return repCost;
	}


	public void setRepCost(double repCost) {
		this.repCost = repCost;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getFeatures() {
		return features;
	}


	public void setFeatures(String features) {
		this.features = features;
	}


	public List<Actor> getActors() {
		return actors;
	}


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, description, features, filmId, langId, length, rate, rating, releaseYear, rentDur,
				repCost, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& Objects.equals(features, other.features) && filmId == other.filmId && langId == other.langId
				&& length == other.length && Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear && rentDur == other.rentDur
				&& Double.doubleToLongBits(repCost) == Double.doubleToLongBits(other.repCost)
				&& Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film ID: ");
		builder.append(filmId);
		builder.append(", \n Title: ");
		builder.append(title);
		builder.append(", \n Description: ");
		builder.append(description);
		builder.append(", \n Release Year: ");
		builder.append(releaseYear);
		builder.append(", \n ID of Language: ");
		builder.append(langId);
		builder.append(", \n Rental Duration: ");
		builder.append(rentDur);
		builder.append(", \n Rental Rate: ");
		builder.append(rate);
		builder.append(", \n Length of Film: ");
		builder.append(length);
		builder.append(", \n Replacement Costs: ");
		builder.append(repCost);
		builder.append(", \n Ratings: ");
		builder.append(rating);
		builder.append(", \n Special Features: ");
		builder.append(features);
		return builder.toString();
	}
}
