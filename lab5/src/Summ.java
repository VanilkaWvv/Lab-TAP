import javax.swing.*;
import java.awt.event.*;

public class Summ {

    public void start(){
        JFrame window = new JFrame("Exemplu Fereastră");
        JLabel eticheta = new JLabel("Introdu numerele");
        JTextField field = new JTextField();
        JButton button = new JButton("Calculate");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proceseing(field.getText());
            }
        });

        button.setBounds(320, 60 ,100, 30);
        eticheta.setBounds(10, 10, 300, 30);
        field.setBounds(10, 60, 300, 30);
        window.setSize(500, 500);

        window.add(eticheta);
        window.add(field);
        window.add(button);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setVisible(true);
    }
    private void proceseing(String input)
    {
        try {
            verifyString(input);
        }catch (StringGolException e)
        {
            System.out.println("Nu este nimic introdus!");
            return;
        }
        System.out.println("Valorile introduse sunt:\n " + input);
        int[] list = toInt(input);
        try {
            verifyVector(list);
        } catch (VectorGolException e) {
            System.out.println("Lista goala");
            return;
        }
        showList(list);
        int[] list1 = list;
        int lg;
        if(list.length%2 == 0) lg = list.length/2; else lg = list.length/2 +1;
        for (int i = 0; i < lg; i++) {
            list1 = toCalculate(list1);
            showList(list1);
        }
    }

    private int[] toCalculate(int[] input)
    {
        int[] out;
        int k=0;
        if (input.length == 1) return input;
        if(input.length == 2) out = new int[1]; else  if (input.length%2 == 0)  out = new int[input.length/2]; else out = new int[input.length/2+1];
        for (int i = 0; i < input.length; i+=2) {
            if (!(i+1 >= input.length)) {
                out[k] = input[i] + input[i + 1];
            } else out[k] = input[i];
            k++;
        }
        return out;
    }
    private int[] toInt(String input)
    {
        String[] out = input.split(" ");
        int[] temp = new int[out.length];
        int k=0;
        for (String s : out) {
            try {
                temp[k] = Integer.parseInt(s);
                k++;
            } catch (NumberFormatException e) {
                System.out.println("Este prezent un caracter!");
            }
            finally {
                System.out.println("Caracterul procesat este :"+ s);
            }
        }
        int[] toReturn = new int[k];
        k=0;
        for (int t : temp) {
            if (t != 0) toReturn[k] = t;
            k++;
        }
        return toReturn;
    }

    private void showList(int[] input){
        for (int j : input) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void verifyString(String text) throws StringGolException {
        if (text.isEmpty()) {
            throw new StringGolException();
        }
    }
    public static void verifyVector(int[] vector) throws VectorGolException {
        if (vector.length == 0) {
            throw new VectorGolException();
        }
    }

}
class StringGolException extends Exception {
    public StringGolException() {
        super("Stringul este gol!");
    }
    public StringGolException(String mesaj) {
        super(mesaj);
    }
}

class VectorGolException extends Exception {
    public VectorGolException() {
        super("Vectorul este gol!");
    }
    public VectorGolException(String mesaj) {
        super(mesaj);
    }
}