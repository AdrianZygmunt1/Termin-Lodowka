import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kategorie kategorie = new Kategorie();
        List<String>listaKategoriMain=kategorie.getKategorieLista();
        while(true) {
            System.out.println("Wybierz numer: \n" +
                    "1. Najbliższe terminy\n" +
                    "2. Sprawdź produkty \n" +
                    "3. Dodaj produkty \n4. Dodaj kategorie\n\n" +
                    "Podaj: ");
            int wybor = sc.nextInt();
            if (wybor == 1) {

            } else if (wybor == 2) {

            } else if (wybor == 3) {

            } else if (wybor == 4) {
                for(String kategoriaFor:listaKategoriMain){
                    int i=1;
                    System.out.println(i+". "+kategoriaFor);
                    i++;
                }
            }else {
                System.out.println("Błedny numer\n\n");
            }
        }
    }
}
