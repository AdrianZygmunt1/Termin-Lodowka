

import java.time.LocalDate;

public class Produkty {
    private String nazwa;
    private LocalDate termin;
    private String kategoria;

    public Produkty(String nazwa, LocalDate termin, String kategoria) {
        this.nazwa = nazwa;
        this.termin = termin;
        this.kategoria = kategoria;
    }

    public void WyswietlDane() {
        String var10001 = this.nazwa;
        System.out.println(var10001 + "\n" + String.valueOf(this.termin) + "\n" + this.kategoria);
    }
}
