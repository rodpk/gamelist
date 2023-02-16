package br.com.rodpk.gamelist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.dto.request.GameRequest;
import br.com.rodpk.gamelist.model.Game;
import br.com.rodpk.gamelist.repository.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public Game save(GameRequest gameRequest) {
        var savedGame = gameRepository.save(Game.of(gameRequest));

        return savedGame;
    }

    public List<Game> listAllByFilters() {
        return gameRepository.findAll();
    }

}
