package duke.soccer.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This domain object represents a soccer league.
 */
@Entity
@Table(name="league")
public class League {
    @Id
    @Column(name="league_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="year")
    private int year;
    @Column(name="season")
    private String season;
    @Column(name="title")
    private String title ;
    @OneToMany(targetEntity=Register.class
    		,mappedBy="league")
    private Set<Register> registers;
    public Set<Register> getRegisters() {
		return registers;
	}
	public void setRegisters(Set<Register> registers) {
		this.registers = registers;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//Following Constructor Used By <jsp:useBean> Tag
    public League() {        
    }
    public League(int year, String season, String title) {
        this.year = year;
        this.season = season;
        this.title = title;
    }   
    public League(int id, int year, String season, String title) {
        this.id = id;
        this.year = year;
        this.season = season;
        this.title = title;
    }
    
    public int getYear() {
        return year;
    }
    public String getSeason() {
        return season;
    }
    public void setYear(int year) {
		this.year = year;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTitle() {
        return title;
    }
    
    // League entities are compared by their object IDs
    public boolean equals(Object o) {
        boolean result = false;
        if ( o instanceof League ) {
            League l = (League) o;
            result = (this.id.equals(l.id));
        }
        return result;
    }
    
    // You need to override hashCode if you override equals
    public int hashCode() {
        return id.hashCode();
    }
    
    public String toString() {
        return title;
    }

	public int getId() {
		return id;
	}
}
