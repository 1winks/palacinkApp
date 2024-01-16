package hr.fer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PalacinkaDTO {
    private String imePalacinke;
    private float cijenaPalacinke;
    private boolean customPalacinka;

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
}
