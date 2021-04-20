package com.codecool.geekofplanets.world.jdbc.service;

import com.codecool.geekofplanets.world.jdbc.model.FieldModel;
import com.codecool.geekofplanets.world.jdbc.model.PlayerModel;
import com.codecool.geekofplanets.world.jdbc.repository.PlayerRepository;
import com.codecool.geekofplanets.world.model.Field;
import com.codecool.geekofplanets.world.model.actors.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAllPlayers() {
        List<PlayerModel> playerModalList = (List<PlayerModel>) playerRepository.findAll();
        List<Player> playerList = new ArrayList<>();
        for(PlayerModel player : playerModalList) {
            FieldModel field = player.getField();
            Field playerField = new Field(field.getX(), field.getY());
            playerList.add(new Player(playerField, player.getName()));
        }
        return playerList;
    }

    @Override
    public Player getPlayerById(String id) {
        PlayerModel model = playerRepository.getPlayerById(id);
        String name = model.getName();
        FieldModel field = model.getField();
        Field playerField = new Field(field.getX(), field.getY());
        return new Player(playerField, name);
    }

    @Override
    public Player getPlayerByUserId(UUID userId) {
        PlayerModel model = playerRepository.getPlayerByUserId(userId);
        String name = model.getName();
        FieldModel field = model.getField();
        Field playerField = new Field(field.getX(), field.getY());
        return new Player(playerField, name);
    }

    @Override
    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void addNewPlayer(Player player, UUID id) {
        String name = player.getName();
        PlayerModel newPlayer = new PlayerModel();
        newPlayer.setName(name);
        newPlayer.setUserId(id);
        playerRepository.save(newPlayer);
    }

    @Override
    public long getPlayerCount() {
        return playerRepository.count();
    }

    @Override
    public void changePlayerName(String newName) {
        playerRepository.changePlayerName(newName);
    }
}
