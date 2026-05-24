
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Produkty {

    public record produktyNasze(String nazwa, LocalDate termin, String kategoria) {
        @Override
        public String toString() {
            return "Produkt: " + nazwa + " | Data ważności: " + termin + " | Kategoria: " + kategoria;
        }
    }
    LocalDate dzisiaj = LocalDate.now();
    private List<produktyNasze> listaproduktow = new ArrayList<>();


    public List<produktyNasze> getProdukty() {
        return listaproduktow;
    }
    public void dodajProdukt(String nazwa, LocalDate termin, String kategoria){
        produktyNasze nowyProdukt = new produktyNasze(nazwa, termin, kategoria);
        this.listaproduktow.add(nowyProdukt);
    }

    private List<produktyNasze> zepsuteProdukty = new ArrayList<>();
    private List<produktyNasze> swiezeProdukty = new ArrayList<>();

    public void segregacja(){
        zepsuteProdukty.clear();
        swiezeProdukty.clear();
        for(produktyNasze produkt:listaproduktow){
            if(produkt.termin().isBefore(dzisiaj)){
                zepsuteProdukty.add(produkt);
            }else{
                swiezeProdukty.add(produkt);
            }
        }
    }

    public List<produktyNasze> getZepsuteProdukty() {
        return zepsuteProdukty;
    }

    public List<produktyNasze> getSwiezeProdukty() {
        return swiezeProdukty;
    }

    public List<produktyNasze> getProduktyPosortowanePoDacie() {
        return listaproduktow.stream()
                .sorted(Comparator.comparing(produktyNasze::termin))
                .collect(Collectors.toList());
    }

    public void usunPoNazwie(String szukanaNazwa) {
        listaproduktow.removeIf(produkt -> produkt.nazwa().equals(szukanaNazwa));
    }
}
