package projektr.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Palacinka {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String imePalacinke;
    @Column(nullable = false)
    private float cijenaPalacinke;
    public enum Type {
        NORMAL,
        CUSTOM;
    }
    @Enumerated(EnumType.STRING)
    private Type tipPalacinke;
    @OneToMany(mappedBy = "palacinka")
    private Set<Dodatak> dodatci;
    @ManyToOne @JoinColumn(name = "narudzba-id")
    private Narudzba narudzba;

    public Palacinka() {}

    public Long getId() {return id;}
    public String getImePalacinke() {return imePalacinke;}
    public float getCijenaPalacinke() {return cijenaPalacinke;}
    public Type getTipPalacinke() {
        return tipPalacinke;
    }
    public Set<Dodatak> getDodatci() {
        return dodatci;
    }
    public Narudzba getNarudzba() {
        return narudzba;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setImePalacinke(String imePalacinke) {
        this.imePalacinke = imePalacinke;
    }
    public void setCijenaPalacinke(float cijenaPalacinke) {
        this.cijenaPalacinke = cijenaPalacinke;
    }
    public void setTipPalacinke(Type tipPalacinke) {
        this.tipPalacinke = tipPalacinke;
    }
    public void setDodatci(Set<Dodatak> dodatci) {
        this.dodatci = dodatci;
    }
    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }
}
