package com.cg.onlineMovieBookingSystem.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Screen")
public class Screen {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="screenId")
	private int screenId;
	
	//@ManyToOne(targetEntity=Theatre.class)
	private int theatreId;
	
	@Column(name="screenName")
	private String screenName;
	
	@OneToMany
	private List<Show> showList;
	
	@Column(name="rows1")
	private int rows1;
	
	@Column(name="columns")
	private int columns;

	public Screen() {
		
	}

	public Screen(int screenId, int theatreId, String screenName, List<Show> showList, int rows1, int columns) {
		super();
		this.screenId = screenId;
		this.theatreId = theatreId;
		this.screenName = screenName;
		this.showList = showList;
		this.rows1 = rows1;
		this.columns = columns;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<Show> getShowList() {
		return showList;
	}

	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}

	public int getRows1() {
		return rows1;
	}

	public void setRows1(int rows1) {
		this.rows1 = rows1;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	
	
}
