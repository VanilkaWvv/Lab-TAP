import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti textul dorit:");
        String sir_accesibil="aeoui";
        String txt = scanner.nextLine();
        String[] word = txt.split(" ");
        for (String h: word){
            char first = h.charAt(0);
            char last = h.charAt(h.length()-1);
            first = Character.toLowerCase(first);
            last = Character.toLowerCase(last);
            if((sir_accesibil.indexOf(first) != -1) || (sir_accesibil.indexOf(last) != -1))
                count++;
        }
        System.out.print("Intextul introdus sunt ");
        System.out.print(count);
        System.out.println(" cuvinte care se incep sau se termina cu o vocala");
    }
}