package br.com.rodpk.gamelist.dto;

public record GameFilters(
        String sortBy,
        String direction,
        int page,
        int size,
        String title,
        String description,
        String developer) {

}
