import java.time.Year;
import java.util.Scanner;
public class Main {
    public static class obj1{
        public String nume;
        public String prenume;
        public int dateOfBirth=0;
        private boolean student=false;
        int currentYear = Year.now().getValue();
        public obj1(String nume,String prenume)
        {
            this.nume = nume;
            this.prenume = prenume;
        }
        public obj1(String nume, String prenume, int dateOfBirth)
        {
            this.nume = nume;
            this.prenume = prenume;
            this.dateOfBirth = dateOfBirth;
        }
        public obj1(String nume, String prenume, int dateOfBirth,boolean student)
        {
            this.nume = nume;
            this.prenume = prenume;
            this.dateOfBirth = dateOfBirth;
            this.student = student;
        }
        public void ShowInfo0(){
            System.out.println("Numele:"+nume);
            System.out.println("Prenume:"+prenume);
        }
        public void ShowInfo1(){
            ShowInfo0();
            System.out.println("Anul nasterii:"+dateOfBirth);
            System.out.println("Varsta:"+(currentYear-dateOfBirth));
            System.out.println("Student:"+(student? "DA":"NU"));
        }
    }
    public static class obj2 extends obj1{
        private boolean bursier=false;
        public String universitatea;
        public String facultatea;
        public obj2(String nume, String prenume, int dateOfBirth,boolean student,String universitatea, String facultatea){
            super(nume,prenume,dateOfBirth,student);
            this.universitatea=universitatea;
            this.facultatea=facultatea;
        }
        public obj2(String nume, String prenume, int dateOfBirth,boolean student,String universitatea, String facultatea,boolean bursier){
            super(nume,prenume,dateOfBirth,student);
            this.universitatea=universitatea;
            this.facultatea=facultatea;
            this.bursier=bursier;
        }
        public void Show()
        {
            super.ShowInfo1();
            System.out.println("Universitatea:"+universitatea);
            System.out.println("Facultatea:"+facultatea);
        }
         public void Show1(){
            Show();
             System.out.println("Bursier:"+(bursier? "Da":"NU"));
         }

         public void changeDate()
         {
             Scanner scanner = new Scanner(System.in);
             System.out.println("Introduceti anul nou:");
             super.dateOfBirth=scanner.nextInt();
             System.out.println("Datele schimbate:");
             Show();
         }
    }
    public static void main(String[] args) {

        obj1 obiect, obc,ob, deriv;
        obj2 Obiect, Obc;
        String nume="Oleja";
        String prenume="Oleg";
        int dateOfBirth=2004;
        boolean st=true;
        obiect=new obj1(nume,prenume);
        obc=new obj1(nume,prenume,dateOfBirth);
        ob=new obj1(nume,prenume,dateOfBirth,st);
        System.out.println("\n\n1 Obiect cu primul constructor");
        obiect.ShowInfo0();
        System.out.println();
        obiect.ShowInfo1();
        System.out.println("\n\n1 Obiect cu al 2 constructor");
        obc.ShowInfo0();
        System.out.println();
        obc.ShowInfo1();
        System.out.println("\n\n1 obiect cu al 3 constructor");
        ob.ShowInfo0();
        System.out.println();
        ob.ShowInfo1();

        String universitatea = "UTM";
        String facultatea = "CIM";
        boolean bursier = false;
        Obiect = new obj2(nume,prenume,dateOfBirth,st,universitatea,facultatea);
        Obc = new obj2(nume,prenume,dateOfBirth,st,universitatea,facultatea,bursier);
        System.out.println("\n\n2 obiect cu 1 constructor");
        Obiect.Show();
        System.out.println();
        Obiect.Show1();
        System.out.println();
        //Obiect.changeDate();
        System.out.println("\n\n2 obiect cu al 2 constructor");
        Obc.Show();
        System.out.println();
        Obc.Show1();
        System.out.println();
        //Obc.changeDate();

        deriv = new obj2(nume,prenume,dateOfBirth,st,universitatea,facultatea);
        System.out.println("\n\nobiect de baza folosind constructor din clasa derivat");
        deriv.ShowInfo0();
        System.out.println();
        deriv.ShowInfo1();

    }
}