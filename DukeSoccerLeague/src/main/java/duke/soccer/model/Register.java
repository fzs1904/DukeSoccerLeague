package duke.soccer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class Register {
	@Id
	@Column(name="register_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(targetEntity=League.class)
	@JoinColumn(name="league_id")
	private League league;
	@ManyToOne(targetEntity=Player.class)
	@JoinColumn(name="player_name")
	private Player player;
	@Column(name="division")
	private String division;
	public Register() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Register(League league, Player player,String division) {
		super();
		this.division = division;
		this.league = league;
		this.player = player;
	}

	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
 