package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Persoana extends Utilizator{
    static String nume;
    public static ArrayList<String> tip_cerere = new ArrayList<>();
    public Persoana() {
        tip_cerere.add("inlocuire buletin");
        tip_cerere.add("inlocuire carnet de sofer");
    }

    public static void cererePersoana(String fileName) {
        String pattern = "dd-MMM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        writeFile(fileName, Persoana.nume + " - cereri in asteptare:");
        System.out.println("nume persoana" + Persoana.nume + "nume simplu" + nume);
        for(int i = 0; i < cerere_util.size(); i ++) {
            if (tip_cerere.contains(cerere_util.get(i))) {
                writeFile(fileName, simpleDateFormat.format(data.get(i)) + " - Subsemnatul " +
                        Persoana.nume + ", va rog sa-mi aprobati urmatoarea solicitare: " + cerere_util.get(i));
            }
        }
    }
    public void checkPersoana(String line, String fileName) throws ParseException {
        if(line.split("; ")[0].equals("cerere_noua")){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            Date date = formatter.parse(line.split("; ")[3]);
            data.add(date);
            cerere_util.add(line.split("; ")[2]);
            for(int i = 0; i < cerere_util.size(); i ++) {
                if (!Persoana.tip_cerere.contains(cerere_util.get(i))) {
                    writeFile(fileName, "Utilizatorul de tip " + functie
                            + " nu poate inainta o cerere de tip " + cerere_util.get(i));
                    cerere_util.remove(i);
                    data.remove(i);
                }
            }
        }
    }
}
