package xin.mengzuo.moviemanager.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Movie implements Serializable{
@GeneratedValue(generator="paymentableGenerator")
  @Id
 @GenericGenerator(name="paymentableGenerator",strategy="uuid")
 private String movieId;
 
 private String movieType;
 
 private String movieLang;
 
 private String movieName;
 private String movieArea;
 private Integer movieLength;

 private Integer movieStatus;
 private String movieImages;
 private String movieIntroduction;
 public String getMovieIntroduction() {
	return movieIntroduction;
}
public void setMovieIntroduction(String movieIntroduction) {
	this.movieIntroduction = movieIntroduction;
}
public String getDiretor() {
	return diretor;
}
public void setDiretor(String diretor) {
	this.diretor = diretor;
}
public String getLeader() {
	return leader;
}
public void setLeader(String leader) {
	this.leader = leader;
}
private String diretor;
 private String leader;
 
 
 
 public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
}
public String getMovieType() {
	return movieType;
}
public void setMovieType(String movieType) {
	this.movieType = movieType;
}
public String getMovieLang() {
	return movieLang;
}
public void setMovieLang(String movieLang) {
	this.movieLang = movieLang;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}

public String getMovieArea() {
	return movieArea;
}
public void setMovieArea(String movieArea) {
	this.movieArea = movieArea;
}
public Integer getMovieLength() {
	return movieLength;
}
public void setMovieLength(Integer movieLength) {
	this.movieLength = movieLength;
}

public Integer getMovieStatus() {
	return movieStatus;
}
public void setMovieStatus(Integer movieStatus) {
	this.movieStatus = movieStatus;
}
public String getMovieImages() {
	return movieImages;
}
public void setMovieImages(String movieImages) {
	this.movieImages = movieImages;
}
	
	
}
