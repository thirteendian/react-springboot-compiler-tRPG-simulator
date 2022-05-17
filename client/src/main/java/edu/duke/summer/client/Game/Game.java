package edu.duke.summer.client.Game;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "game_sequence")
    private Long id;  //game id, primary key
    @Column(nullable = false, unique = true, length = 45)
    private String CreatorEmail;

    @Column(nullable = false, length = 16)
    private String password;
    @Column(nullable = false, length = 45)
    private String gameName;

    public Game() {}


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getCreatorEmail() {
        return CreatorEmail;
    }

    public String getGameName() {
        return gameName;
    }

    public String getPassword() {
        return password;
    }

    public void setCreatorEmail(String creatorEmail) {
        CreatorEmail = creatorEmail;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Game(Long id, String creatorEmail, String password, String gameName) {
        this.id = id;
        CreatorEmail = creatorEmail;
        this.password = password;
        this.gameName = gameName;
    }

    public Game(String creatorEmail, String password, String gameName) {
        CreatorEmail = creatorEmail;
        this.password = password;
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", CreatorEmail='" + CreatorEmail + '\'' +
                ", gameName='" + gameName + '\'' +
                '}';
    }
}
