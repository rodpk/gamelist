package br.com.rodpk.gamelist.model;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import br.com.rodpk.gamelist.dto.request.GameRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Table(name = "games")
@Getter
@Setter
public class Game {

    @Id
    @Column(name = "game_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    private String title;
    private String description;
    private String developer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private File image;

    @Column(name = "average_rating")
    private Float averageRating;
    private List<String> genres;
    private List<String> platforms;
    private List<String> Reviews;

    public static Game of(GameRequest gr) {
        return Game.builder()
                .title(gr.title())
                .description(gr.description())
                .developer(gr.developer())
                .genres(gr.genres())
                .platforms(gr.platforms())
                .build();
    }

}
