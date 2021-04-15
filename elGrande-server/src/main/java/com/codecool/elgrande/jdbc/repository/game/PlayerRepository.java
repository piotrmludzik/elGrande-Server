package com.codecool.elgrande.jdbc.repository.game;

import com.codecool.elgrande.model.game.actors.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Query("SELECT p FROM Player p WHERE p.id = ?1")
    Player getPlayerById(String id);

    @Query("SELECT p FROM Player p WHERE p.userId = ?1")
    Player getPlayerByUserId(UUID userId);

    @Modifying
    @Query("UPDATE Player p SET p.name = ?1")
    void changePlayerName(String newName);
}
