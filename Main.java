import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Kategorie kategorie = new Kategorie();
        List<String>listaKategoriMain=kategorie.getKategorieLista();//Wypisuje liste kategori

        Produkty produkty =new Produkty();
        List<Produkty.produktyNasze>listaProduktyMain=produkty.getProdukty();
        List<Produkty.produktyNasze>listaProduktyMainPoTerminie=produkty.getZepsuteProdukty();
        List<Produkty.produktyNasze>listaProduktyMainPrzedTerminem=produkty.getSwiezeProdukty();

        while(true) {
            System.out.println("Wybierz numer: \n" +
                    "1. Najbliższe terminy\n" +
                    "2. Sprawdź produkty \n" +
                    "3. Dodaj produkty \n" +
                    "4. Dodaj kategorie\n\n" +
                    "Podaj: ");
            int wybor = sc.nextInt();
            if (wybor == 1) {
                System.out.println("Produkty\n");
                produkty.segregacja();
                System.out.println("Produkty po terminie:");
                int i=1;
                for (Produkty.produktyNasze produkciki:listaProduktyMainPoTerminie){
                    System.out.println(i+". "+produkciki);
                    i++;
                }
                System.out.println("W terminie");
                for (Produkty.produktyNasze produkciki:listaProduktyMainPrzedTerminem){
                    System.out.println(i+". "+produkciki);
                    i++;
                }
                System.out.println("Jesli chesz usunac produkt wpisz jego pelna odpowiednia nazwe\n" +
                        "A jesli nie kliknij enter");
                sc.nextLine();
                String wpisane= sc.nextLine();
                if(wpisane.equals("")){

                }else{
                    if(listaProduktyMain.contains(wpisane)){
                        produkty.usunPoNazwie(wpisane);
                    }else{
                        System.out.println("Nie istnieje taki produkt");
                    }

                }
            } else if (wybor == 2) {
                int i=1;
                for (Produkty.produktyNasze produkciki:listaProduktyMain){
                    System.out.println(i+". "+produkciki);
                    i++;
                }
            } else if (wybor == 3) {
                int i=1;
                for(String kategoriaFor:listaKategoriMain){

                    System.out.println(i+". "+kategoriaFor);
                    i++;
                }
                System.out.println("Do jakiej kategori chcesz dodac produkt podaj pelna nazwę\n" +
                        "Wpisz: ");
                sc.nextLine();
                String wybranaKategoria = sc.nextLine();

                if(listaKategoriMain.contains(wybranaKategoria)){
                    System.out.println("Podaje nazwe: ");
                    String nazwa = sc.nextLine();
                    System.out.println("Podaje termin: ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate termin = null;
                    while (termin == null) {
                        try {
                            String dateString = sc.nextLine().trim();
                            termin = LocalDate.parse(dateString, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.print("Błędny format! Podaj datę jeszcze raz (RRRR-MM-DD): ");
                        }
                    }
                    produkty.dodajProdukt(nazwa,termin,wybranaKategoria);
                }else {
                    System.out.println("no ni chuja");
                }
            } else if (wybor == 4)
            {
                int i=1;
                for(String kategoriaFor:listaKategoriMain){

                    System.out.println(i+". "+kategoriaFor);
                    i++;
                }
                System.out.println("Dodaj kategorie.\n" +
                        "Jeśli jednak nie chicialbys nic dodac \n" +
                        "kliknij po prostu enter\n\n");
                System.out.println("wpisz: ");
                sc.nextLine();
                String nowaKategoriaMain = sc.nextLine();
                if(nowaKategoriaMain.equals("")){

                }else{
                    if(listaKategoriMain.contains(nowaKategoriaMain)){
                        System.out.println("Już takie cos istneije");
                    }else{
                        kategorie.dodajKategorie(nowaKategoriaMain);
                    }

                }

            }else {
                System.out.println("Błedny numer\n\n");
            }
        }
    }
}
