package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="candidates")
public class Candidate {
	private Integer id;
	private String name,politicalParty;
	private int votes;
	public Candidate(Integer id, String name, String politicalParty, int votes) {
		super();
		this.id = id;
		this.name = name;
		this.politicalParty = politicalParty;
		this.votes = votes;
	}
	public Candidate() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="political_party")
	public String getPoliticalParty() {
		return politicalParty;
	}
	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", politicalParty=" + politicalParty + ", votes=" + votes
				+ "]";
	}
	
	
	

}
