public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Carte de","Sergiu",2020,"Hololive");
        biblioteca.display();
        biblioteca.display(1);
        biblioteca.display("Cocs");
        biblioteca.find("carte");
    }
}