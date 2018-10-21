package duke.soccer.service;

import java.util.List;

import javax.persistence.EntityManager;

import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.model.Register;
import duke.soccer.utils.JpaUtils;

public class EntityManagerTest {
public static void main(String[] args) {
	Player player = new Player("Robin","address","101","123","456");
	createAndStorePlayer(player);
	listPlayers();
	League league = new League(2018,"summer","Robin Team");
	createAndStoreLeague(league);
	Register register = new Register(league,player,"Taipei");
	createAndStoreLeague(league);
	listLeagues();
}
public static void createAndStorePlayer(Player player) {
	EntityManager em = JpaUtils.getEntityManager();
	em.getTransaction().begin();
	em.persist(player);
	em.getTransaction().commit();
}
public static void listPlayers() {
	EntityManager em = JpaUtils.getEntityManager();
	em.getTransaction().begin();
	List<Player> players = em.createQuery("from Player p").getResultList();
	em.getTransaction().commit();
	for(Player player:players) {
		System.out.println("Player:"+player.getName());
	}
}
public static void createAndStoreLeague(League league) {
	EntityManager em = JpaUtils.getEntityManager();
	em.getTransaction().begin();
	em.persist(league);
	em.getTransaction().commit();
}
public static void listLeagues() {
	EntityManager em = JpaUtils.getEntityManager();
	em.getTransaction().begin();
	List<League> leagues = em.createQuery("from League l").getResultList();
	em.getTransaction().commit();
	for(League league:leagues) {
		System.out.println("League:"+league.getId()+" "+league.getYear()+" "
				+league.getSeason()+" "+league.getTitle());
		System.out.println(league.getRegisters().size());
	}
}
}
