package hr.fer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class PalacinkaDTO {
    private String imePalacinke;
    private float cijenaPalacinke;
    private boolean customPalacinka;

    private Set<DodatakDTO> dodaci;

    public String getImePalacinke() {
        return imePalacinke;
    }
    public void setImePalacinke(String imePalacinke) {
        this.imePalacinke = imePalacinke;
    }
    public float getCijenaPalacinke() {
        return cijenaPalacinke;
    }
    public void setCijenaPalacinke(float cijenaPalacinke) {
        this.cijenaPalacinke = cijenaPalacinke;
    }
    public boolean isCustomPancake() {
        return customPalacinka;
    }
    public void setCustomPancake(boolean customPalacinka) {
        this.customPalacinka = customPalacinka;
    }
    public Set<DodatakDTO> getDodaci() {
        return dodaci;
    }
    public void setDodaci(Set<DodatakDTO> dodaci) {
        this.dodaci = dodaci;
    }
}
