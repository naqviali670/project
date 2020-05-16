package Model;

import org.tinylog.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;


/**
 * StoreData represents a model class which has functionality to store, retreive and update data to database.
 *
 * @author Syed Kausar Ali Naqvi
 */
public class StoreData {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Game-mysql");
    private ArrayList<Game> game;
    private ArrayList<Player1> player;
    private EntityManager entityManager = emf.createEntityManager();

    /**
     * To store Game in the database.
     *
     * @param game Game object (represents one game)
     */
    public void setGame(Game game) {
        System.out.println(game);
        emf = Persistence.createEntityManagerFactory("Game-mysql");
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(game);
            entityManager.getTransaction().commit();
        } catch (Exception x) {
            System.out.println(x);
        }
        Logger.info("Game data has been stored successfully!");
        entityManager.close();
        emf.close();
    }

    /**
     * To store Player in the database.
     *
     * @param player Player1(class_name) object (represents one player of the game)
     */
    public void setPlayer(Player1 player) {
        emf = Persistence.createEntityManagerFactory("Game-mysql");
        entityManager = emf.createEntityManager();
        Player1 a = entityManager.find(Player1.class, "");
        if ((entityManager.find(Player1.class, player.getName())) == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
        emf.close();
    }

    /**
     * to retreive players records from Player1 table in the database
     *
     * @return players records in the form of ArrayList
     */
    public ArrayList<Player1> getPlayer() {
        emf = Persistence.createEntityManagerFactory("Game-mysql");
        entityManager = emf.createEntityManager();
        player = (ArrayList<Player1>) entityManager.createQuery("SELECT l from Player1 l ORDER BY l.wins desc", Player1.class).getResultList();
        entityManager.close();
        emf.close();
        return player;
    }

    /**
     * To update specific player record in the database
     *
     * @param entity Player1(class_name) object (represents player whose record should be updated)
     */
    public void updateData(Player1 entity) {
        emf = Persistence.createEntityManagerFactory("Game-mysql");
        entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query setParameter = entityManager.createQuery("UPDATE Player1 set wins = wins + 1 where name = :name")

                    .setParameter("name", entity.getName());
            System.out.println("13");
            setParameter.executeUpdate();
            System.out.println("14");
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        entityManager.close();
        emf.close();

    }

}
