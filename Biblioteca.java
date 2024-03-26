import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Biblioteca implements Carte {
    private final String denumire;
    private final String autor;
    private final int numarulSeriei;
    private final String denumireaBibliotecii;
    public Biblioteca(String denumire, String autor, int numarSerie,String denumireaBibliotecii){
        this.denumire = denumire;
        this.autor = autor;
        this.numarulSeriei = numarSerie;
        this.denumireaBibliotecii = denumireaBibliotecii;
    }

    @Override
    public void display() {
        System.out.println("Denumirea Cartii: "+denumire);
        System.out.println("Autor: "+autor);
        System.out.println("Numarul Seriei: "+numarulSeriei);
        System.out.println("Denumirea Bibliotecii:" +denumireaBibliotecii+"\n");
    }

    @Override
    public void display(int type) {
        switch (type){
            case 1: System.out.println("Denumirea Cartii: "+denumire);
                break;
            case 2: System.out.println("Autor: "+autor);
                break;
            case 3: System.out.println("Numarul Seriei: "+numarulSeriei);
                break;
            case 4:
                System.out.println("Denumirea bibliotecii: "+denumireaBibliotecii);
                break;
        }
        System.out.println();
    }

    @Override
    public void display(String out) {
        System.out.println("Mesajul nu a fost primit! \nEroarea: "+ out+"\n");
    }
    @Override
    public void find(String regex)
    {
        if (denumire.matches(".*\\b" + regex + "\\b.*"))
        { System.out.println("Paternul a fost gasit in denumire: "+denumire);}
        if (autor.matches(".*\\b" + regex + "\\b.*"))
        {
            System.out.println("Paternul a fost gasit in autor: "+autor);
        }
        System.out.println("Paternul nu a fost gasit!");
        System.out.println();
    }
}
