package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Elev extends Utilizator{
    static String nume;
    static String scoala;
    public static ArrayList<String> tip_cerere = new ArrayList<String>();

    public Elev () {
        tip_cerere.add("inlocuire buletin");
        tip_cerere.add("inlocuire carnet de elev");
    }

    public static void cerere (String fileName) {
        String pattern = "dd-MMM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for(int i = 0; i < cerere_util.size(); i ++) {
            if (tip_cerere.contains(cerere_util.get(i))) {
                writeFile(fileName, simpleDateFormat.format(data.get(i)) + " - Subsemnatul " +
                        nume + ", " + functie + " la scoala " +
                        Elev.scoala + ", va rog sa-mi aprobati urmatoarea solicitare: " + cerere_util.get(i));
            }
        }
    }
    public static void checkElev(String line, String fileName) throws ParseException {
        if(line.split("; ")[0].equals("cerere_noua")){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            Date date = formatter.parse(line.split("; ")[3]);
            data.add(date);
            cerere_util.add(line.split("; ")[2]);
            System.out.println("TIP CERERE" + tip_cerere);
            for(int i = 0; i < cerere_util.size(); i ++) {
                if (!Elev.tip_cerere.contains(cerere_util.get(i))) {
                    writeFile(fileName, "Utilizatorul de tip " + functie
                            + " nu poate inainta o cerere de tip " + cerere_util.get(i));
                    cerere_util.remove(i);
                    data.remove(i);
                }
            }
        }
    }
}
