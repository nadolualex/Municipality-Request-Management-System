package org.example;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Angajat extends Utilizator{
    public static String companie;
    public static ArrayList<String> tip_cerere = new ArrayList<>();

    public Angajat() {
        tip_cerere.add("inlocuire buletin");
        tip_cerere.add("inlocuire carnet de sofer");
        tip_cerere.add("inregistrare venit salarial");
    }

    public static void cerereAngajat(String fileName) {
        writeFile(fileName, Angajat.nume + " - cereri in asteptare:");
        String pattern = "dd-MMM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //System.out.println("nume persoana" + Angajat.nume + "nume simplu" + nume);

        for(int i = 0; i < cerere_util.size(); i ++) {
            if (tip_cerere.contains(cerere_util.get(i))) {
                writeFile(fileName, simpleDateFormat.format(data.get(i)) + " - Subsemnatul " +
                       Angajat.nume + ", " + functie + " la compania " +
                        Angajat.companie + ", va rog sa-mi aprobati urmatoarea solicitare: " + cerere_util.get(i));
            }
        }
    }

    public void checkAngajat(String line, String fileName) throws ParseException {
        if(line.split("; ")[0].equals("cerere_noua")){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            Date date = formatter.parse(line.split("; ")[3]);
            data.add(date);
            cerere_util.add(line.split("; ")[2]);
            for(int i = 0; i < cerere_util.size(); i ++) {
                if (!Angajat.tip_cerere.contains(cerere_util.get(i))) {
                    writeFile(fileName, "Utilizatorul de tip " + functie
                            + " nu poate inainta o cerere de tip " + cerere_util.get(i));
                    cerere_util.remove(i);
                    data.remove(i);
                }
            }
        }
    }

}
