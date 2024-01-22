package hr.fer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class NarudzbaDTO {
    private float cijenaNarudzbe;
    private Boolean dostava;
    private String adresa;

    private Set<PalacinkaDTO> palacinke;

    public float getCijenaNarudzbe() {
        return cijenaNarudzbe;
    }
    public void setCijenaNarudzbe(float cijenaNarudzbe) {
        this.cijenaNarudzbe = cijenaNarudzbe;
    }
    public Boolean getDostava() {
        return dostava;
    }
    public void setDostava(Boolean dostava) {
        this.dostava = dostava;
    }
    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public Set<PalacinkaDTO> getPalacinke() {
        return palacinke;
    }
    public void setPalacinke(Set<PalacinkaDTO> palacinke) {
        this.palacinke = palacinke;
    }
}
