package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EntitateJuridica extends Utilizator{
    static String nume;
    static String reprezentant;
    public static ArrayList<String> tip_cerere = new ArrayList<String>();

    public EntitateJuridica(){
        tip_cerere.add("creare act constitutiv");
        tip_cerere.add("reinnoire autorizatie");
    }

    public static void cerereEntitate(String fileName) {
        String pattern = "dd-MMM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        writeFile(fileName, EntitateJuridica.nume + " - cereri in asteptare:");
        for(int i = 0; i < cerere_util.size(); i ++) {
            if (tip_cerere.contains(cerere_util.get(i))) {
                writeFile(fileName, simpleDateFormat.format(data.get(i)) + " - Subsemnatul " +
                        EntitateJuridica.reprezentant + ", reprezentant legal al companiei " +
                        EntitateJuridica.nume + ", va rog sa-mi aprobati urmatoarea solicitare: " + cerere_util.get(i));
            }
        }
    }
    public void checkEntitateJuridica(String line, String fileName) throws ParseException {
        if(line.split("; ")[0].equals("cerere_noua")){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            Date date = formatter.parse(line.split("; ")[3]);
            data.add(date);
            cerere_util.add(line.split("; ")[2]);
            for(int i = 0; i < cerere_util.size(); i ++) {
                if (!EntitateJuridica.tip_cerere.contains(cerere_util.get(i))) {
                    writeFile(fileName, "Utilizatorul de tip " + functie
                            + " nu poate inainta o cerere de tip " + cerere_util.get(i));
                    cerere_util.remove(i);
                    data.remove(i);
                }
            }
        }
    }
}
