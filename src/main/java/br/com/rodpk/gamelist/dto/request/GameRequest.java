package br.com.rodpk.gamelist.dto.request;

import java.util.List;

public record GameRequest(
    String title,
    String description,
    String developer,
    List<String> genres,
    List<String> platforms
) {
    
}
