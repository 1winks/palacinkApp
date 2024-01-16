package hr.fer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NarudzbaDTO {
    private float cijenaNarudzbe;
    private Boolean dostava;
    private String adresa;

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
}
