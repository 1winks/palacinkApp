package projektr.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Korisnik {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String username, email, kucnaAdresa, brojTelefona;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "korisnik")
    private Set<Narudzba> narudzbe;

    public Korisnik() {}

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
