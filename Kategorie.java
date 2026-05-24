import java.util.ArrayList;
import java.util.List;

public class Kategorie {
    private List<String>kategorieLista= new ArrayList<>();
    
    public List<String> getKategorieLista() {
        return kategorieLista;
    }


    public void dodajKategorie(String nowaKategoria) {
        kategorieLista.add(nowaKategoria);
    }
}
