package br.com.rodpk.gamelist.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.dto.GameFilters;
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

    public Page<Game> findAllByFilters(GameFilters filters) {

        var sort = Sort.by(Direction.fromString(filters.direction()), filters.sortBy());
        var pageable = PageRequest.of(filters.page(), filters.size(), sort);

        return gameRepository.findAllByFilters(filters.title(), filters.description(), filters.developer(), pageable);
    }

    public Game findById(UUID id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void delete(UUID id) {
        gameRepository.deleteById(id);
    }

}
