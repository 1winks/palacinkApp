package projektr.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Korisnik {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String username, email, kucnaAdresa, brojTelefona;
    @OneToMany(mappedBy = "korisnik")
    private Set<Narudzba> narudzbe;

    private Korisnik() {}

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getKucnaAdresa() {
        return kucnaAdresa;
    }
    public String getBrojTelefona() {
        return brojTelefona;
    }
    public Set<Narudzba> getNarudzbe() {
        return narudzbe;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setKucnaAdresa(String kucnaAdresa) {
        this.kucnaAdresa = kucnaAdresa;
    }
    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
    public void setNarudzbe(Set<Narudzba> narudzbe) {
        this.narudzbe = narudzbe;
    }
}
