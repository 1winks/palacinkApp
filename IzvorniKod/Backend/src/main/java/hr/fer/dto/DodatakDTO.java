package hr.fer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class DodatakDTO {
    private String nazivDodatka;
    private float cijenaDodatka;

    public String getNazivDodatka() {
        return nazivDodatka;
    }
    public void setNazivDodatka(String nazivDodatka) {
        this.nazivDodatka = nazivDodatka;
    }
    public float getCijenaDodatka() {
        return cijenaDodatka;
    }
    public void setCijenaDodatka(float cijenaDodatka) {
        this.cijenaDodatka = cijenaDodatka;
    }
}
