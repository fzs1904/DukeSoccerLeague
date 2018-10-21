package duke.soccer.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This domain object represents a player in a soccer league.
 */
@Entity
@Table(name="player")
public class Player {
    @Id
    @Column(name="player_name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="province")
    private String province;
    @Column(name="postalCode")
    private String postalCode;
    @OneToMany(targetEntity=Register.class,
    		mappedBy="player")
    private Set<Register> registers;

    public Set<Register> getRegisters() {
		return registers;
	}
	public void setRegisters(Set<Register> registers) {
		this.registers = registers;
	}
	public Player() {
    	super();
    }
    /**
     * This is the constructor.  It is package-private to prevent misuse.
     * The PlayerService.getPlayer method should be used to create a
     * new player object.
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * This is the full constructor.
     */
    public Player(String name, String address, String city,
            String province, String postalCode) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String value) {
        name = value;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String value) {
        address = value;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String value) {
        city = value;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String value) {
        province = value;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String value) {
        postalCode = value;
    }
    
} // END of Player class
