import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Menedzer bazy danych.");
            System.out.println("[1] - Stworz Tablice");
            System.out.println("[2] - Ustaw tablice");
            System.out.println("[3] - Dodaj rekord");
            System.out.println("[4] - Wyszukaj dane");
            System.out.println("[5] - wyjscie");
            byte wybranaOpcja = s.nextByte();
            s.nextLine();

            switch (wybranaOpcja) {
                case 1: // Tworzenie Tablicy
                    tworzenieTablicy();
                    break;
                case 2: // ustaw tablice
                    break;
                case 3: // dodaj rekord
                    break;
                case 4: // wyszukaj dane
                    break;
                case 5: // wyjdz z programu
                    System.out.println("Wylaczanie.");
                    System.exit(1);
                    break;
                default: // domyslnie, powrot do opcji
                    System.out.println("Niepoprawna opcja, wybierz ponownie");
                    break;
            }

        }
    }

    private static void tworzenieTablicy(){

        Scanner s = new Scanner(System.in);
        System.out.println("Wybierz nazwe nowej tablicy:");
        String nazwa = s.next();
        System.out.println("Ile kolumn powinna miec tablica:");

        int iloscKolumn = s.nextInt();
        String[] nazwyKolumn = new String[iloscKolumn];
        String[] rodzajeKolumn = new String[iloscKolumn];
        boolean[] czyAutoIncrement = new boolean[iloscKolumn];
        String primaryKey;

        for (int i = 0; i<iloscKolumn;i++) {
            System.out.println("UWAGA: pierwsza kolumna jest tez automatycznie kluczem glownym.");
            System.out.println("Podaj nazwe "+(i+1)+" kolumny: ");
            nazwyKolumn[i] = s.next();
            System.out.println("Podaj rodzaj "+(i+1)+" kolumny:");
            System.out.println("liczba | tekst");
            rodzajeKolumn[i] = s.next();
            if (Objects.equals(rodzajeKolumn[i], "liczba")) {
                System.out.println("Ustawiono rodzaj na: liczba");
                rodzajeKolumn[i] = "INT";
            } else if (Objects.equals(rodzajeKolumn[i], "tekst")) {
                System.out.println("Ustawiono rodzaj na: tekst");
                rodzajeKolumn[i] = "TEXT";
            } else {
                System.out.println("nieznaleziono takiej opcji, zmieniono na tekst");
                rodzajeKolumn[i] = "TEXT";
            }
            if (Objects.equals(rodzajeKolumn[i], "INT")) {
                System.out.println("Czy wlaczyc Auto-Increment:");
                System.out.println("[1] - tak");
                System.out.println("[2] - nie");
                int wybor = s.nextInt();
                switch (wybor) {
                    case 1:
                        System.out.println("Wlaczono Auto-Increment");
                        czyAutoIncrement[i] = true;
                        break;
                    case 2:
                        System.out.println("Nie wlaczono Auto-incrmeent");
                        czyAutoIncrement[i] = false;
                        break;
                }
            } else {
                czyAutoIncrement[i] = false;
            }


        }

        String query = "CREATE TABLE "+nazwa+" (";
        for (int i = 0; i<iloscKolumn;i++){
            if (czyAutoIncrement[i]){
                String pattern = nazwyKolumn[i]+" "+rodzajeKolumn[i]+" "+"AUTO_INCREMENT"+",";
                query = query.concat(pattern);
            } else{
                String pattern = nazwyKolumn[i]+" "+rodzajeKolumn[i]+",";
                query = query.concat(pattern);
            }
        }
        String pattern = "PRIMARY KEY ("+nazwyKolumn[0]+"));";
        query = query.concat(pattern);
        System.out.println(query);
    }

    private void ustawienieTablicy(){
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj nazwe tablicy ktorej chcesz uzyc:");
        String nazwa = s.next();
        String query = "USE TABLE "+nazwa;
        System.out.println("Ustawiono tablice na: "+nazwa);
    }

    private void dodawanieRekordu(){
        Scanner s = new Scanner(System.in);
    }

    private void wyszukiwanieDanych(){
        Scanner s = new Scanner(System.in);
    }


}