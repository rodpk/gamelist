package br.com.rodpk.gamelist.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rodpk.gamelist.model.Game;

public interface GameRepository extends JpaRepository<Game, UUID> {

        @Query("SELECT g FROM Game g WHERE (:title IS NULL OR g.title LIKE %:title%) "
                        + "AND (:description IS NULL OR g.description LIKE %:description%) "
                        + "AND (:developer IS NULL OR g.developer = :developer) ")
        Page<Game> findAllByFilters(
                        @Param("title") String title,
                        @Param("description") String description,
                        @Param("developer") String developer,
                        Pageable pageable);

}
