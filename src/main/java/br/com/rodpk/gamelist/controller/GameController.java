package br.com.rodpk.gamelist.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodpk.gamelist.dto.GameFilters;
import br.com.rodpk.gamelist.dto.request.GameRequest;
import br.com.rodpk.gamelist.model.Game;
import br.com.rodpk.gamelist.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public Page<Game> findAll(
            @RequestParam(defaultValue = "createdAt", required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String dir,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "99", required = false) int size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String developer) {

        var filters = new GameFilters(sortBy, dir, page, size, title, description, developer);
        return service.findAllByFilters(filters);
    }

    @PostMapping
    public Game save(@RequestBody GameRequest gr) {
        return service.save(gr);
    }

    @GetMapping("/{id}")
    public Game findById(@PathVariable UUID id) {
        return service.findById(id);
    }

}
