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

    private Narudzba() {}

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
    public void setId(Long id) {
        this.id = id;
    }
    public void setCijenaNarudzbe(float cijenaNarudzbe) {
        this.cijenaNarudzbe = cijenaNarudzbe;
    }
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    public void setPalacinke(Set<Palacinka> palacinke) {
        this.palacinke = palacinke;
    }
}
