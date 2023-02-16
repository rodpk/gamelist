package br.com.rodpk.gamelist.model;

import java.time.LocalDateTime;

import lombok.Getter;


@Getter
public abstract class BaseEntity {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;

}
