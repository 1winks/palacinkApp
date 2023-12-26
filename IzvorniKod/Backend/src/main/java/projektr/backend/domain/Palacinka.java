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

    public Long getId() {
        return id;
    }
    public String getImePalacinke() {
        return imePalacinke;
    }
    public float getCijenaPalacinke() {
        return cijenaPalacinke;
    }
    public Type getTipPalacinke() {
        return tipPalacinke;
    }
    public Set<Dodatak> getDodatci() {
        return dodatci;
    }
    public Narudzba getNarudzba() {
        return narudzba;
    }
}
