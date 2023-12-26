package projektr.backend.domain;

import jakarta.persistence.*;

@Entity
public class Dodatak {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String nazivDodatka;
    @Column(nullable = false)
    private float cijenaDodatka;
    @ManyToOne @JoinColumn(name = "palacinka-id")
    private Palacinka palacinka;

    public Long getId() {
        return id;
    }
    public String getNazivDodatka() {
        return nazivDodatka;
    }
    public float getCijenaDodatka() {
        return cijenaDodatka;
    }
    public Palacinka getPalacinka() {
        return palacinka;
    }
}
