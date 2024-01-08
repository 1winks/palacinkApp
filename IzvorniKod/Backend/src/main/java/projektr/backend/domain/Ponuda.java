package projektr.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ponuda {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String imePonude;
    @Column(nullable = false)
    private float cijenaPonude;
    @OneToMany(mappedBy = "ponuda")
    private Set<Dodatak> dodatci;

    private Ponuda() {}

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getImePonude() {
        return imePonude;
    }
    public void setImePonude(String imePonude) {
        this.imePonude = imePonude;
    }
    public float getCijenaPonude() {
        return cijenaPonude;
    }
    public void setCijenaPonude(float cijenaPonude) {
        this.cijenaPonude = cijenaPonude;
    }
    public Set<Dodatak> getDodatci() {
        return dodatci;
    }
    public void setDodatci(Set<Dodatak> dodatci) {
        this.dodatci = dodatci;
    }
}
