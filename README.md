Acest program a fost creat pentru laborator
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti textul dorit:");
        String sir_accesibil="aeoui";//sir pentru a verifica daca sunt aceste caractere in cuvant la inceput sau la sfarsit
        String txt = scanner.nextLine();//citirea textului
        String[] word = txt.split(" ");//divizarea textului in cuvinte
        for (String h: word){
            char first = h.charAt(0);//extragerea primei si ultimei litere din cuvant
            char last = h.charAt(h.length()-1);
            first = Character.toLowerCase(first);//transformarea din majuscule in minuscule
            last = Character.toLowerCase(last);
            if((sir_accesibil.indexOf(first) != -1) || (sir_accesibil.indexOf(last) != -1))//verificarea daca aceste litere sunt in cuvant
                count++;
        }
        System.out.print("Intextul introdus sunt ");
        System.out.print(count);//afisarea numarului de cuvinte cu primul sau ultimul caracter vocala
        System.out.println(" cuvinte care se incep sau se termina cu o vocala");
    }
}
