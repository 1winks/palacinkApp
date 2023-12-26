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
}
