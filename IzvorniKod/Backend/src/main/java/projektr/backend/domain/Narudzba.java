package projektr.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Narudzba {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private float cijenaNarudzbe;

    @ManyToOne @JoinColumn(name = "korisnik-id")
    private Korisnik korisnik;
    @OneToMany(mappedBy = "narudzba")
    private Set<Palacinka> palacinke;

    public Long getId() {
        return id;
    }
    public float getCijenaNarudzbe() {
        return cijenaNarudzbe;
    }
    public Set<Palacinka> getPalacinke() {
        return palacinke;
    }
    public Korisnik getKorisnik() {
        return korisnik;
    }
}
