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

    private Dodatak() {}

    public Long getId() {
        return id;
    }
    public String getNazivDodatka() {
        return nazivDodatka;
    }
    public float getCijenaDodatka() {
        return cijenaDodatka;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNazivDodatka(String nazivDodatka) {
        this.nazivDodatka = nazivDodatka;
    }
    public void setCijenaDodatka(float cijenaDodatka) {
        this.cijenaDodatka = cijenaDodatka;
    }
    public void setPalacinka(Palacinka palacinka) {
        this.palacinka = palacinka;
    }
    public Palacinka getPalacinka() {
        return palacinka;
    }
}
