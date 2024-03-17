package org.example;
import java.util.ArrayList;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import static org.example.Angajat.*;


public abstract class Utilizator {
    public static String nume;
    public static ArrayList<Date> data = new ArrayList<Date>();
    public static ArrayList<String> cerere_util = new ArrayList<>();
    public static String functie;
    public static String text;

    public static void readFile(String fileName) {
        try {
            FileReader fReader = new FileReader("src/main/resources/input/" + fileName);
            BufferedReader bReader = new BufferedReader(fReader);
            String line = bReader.readLine();
            data.clear();
            cerere_util.clear();
            tip_cerere.clear();
            functie = "";
            Utilizator util = new Utilizator() {
            };
            Angajat angajat = new Angajat();
            Persoana persoana = new Persoana();
            Elev elev = new Elev();
            Pensionar pensionar = new Pensionar();
            EntitateJuridica entitateJuridica = new EntitateJuridica();

            while (line != null) {
                if (line.split("; ")[0].equals("adauga_utilizator")) {
                    if (line.split("; ")[1].equals("angajat")) {
                        angajat.nume = line.split("; ")[2];
                        Angajat.functie = line.split("; ")[1];
                        angajat.companie = line.split("; ")[3];
                    }
                    else if (line.split("; ")[1].equals("persoana")) {
                        persoana.nume = line.split("; ")[2];
                        Persoana.functie = line.split("; ")[1];
                    }
                    else if (line.split("; ")[1].equals("elev")) {
                        elev.nume = line.split("; ")[2];
                        Elev.functie = line.split("; ")[1];
                        Elev.scoala = line.split("; ")[3];
                    }
                    else if (line.split("; ")[1].equals("pensionar")) {
                        pensionar.nume = line.split("; ")[2];
                        pensionar.functie = line.split("; ")[1];
                    }
                    else if (line.split("; ")[1].equals("entitate juridica")) {
                        entitateJuridica.nume = line.split("; ")[2];
                        entitateJuridica.functie = line.split("; ")[1];
                        entitateJuridica.reprezentant = line.split("; ")[3];
                    }
                    System.out.println(line.split("; ")[1] + " a fost adaugat cu succes");
                }

                if (line.split("; ")[0].equals("retrage_cerere")){
                    String pattern = "dd-MMM-yyyy HH:mm:ss";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    for(int i = 0; i < data.size(); i++){
                        if(simpleDateFormat.format(data.get(i)).equals(line.split("; ")[2])){
                            data.remove(i);
                            cerere_util.remove(i);
                        }
                    }
                }

                if(functie.equals("angajat") ){
                    angajat.checkAngajat(line, fileName);
                }
                else if(functie.equals("persoana")){
                    persoana.checkPersoana(line, fileName);
                }
                else if(functie.equals("elev")){
                    elev.checkElev(line, fileName);
                }
                else if(functie.equals("pensionar")){
                    pensionar.checkPensionar(line, fileName);
                }
                else if(functie.equals("entitate juridica")){
                    entitateJuridica.checkEntitateJuridica(line, fileName);
                }

                if(line.split("; ")[0].equals("afiseaza_cereri_in_asteptare") && functie.equals("angajat")){
                    //System.out.println(functie);
                    util.sortDateAngajat(fileName);
                }
                if(line.split("; ")[0].equals("afiseaza_cereri_in_asteptare") && functie.equals("persoana")){
                    System.out.println("muie");
                    //System.out.println(functie);
                    util.sortDatePersoana(fileName);
                }
                if(line.split("; ")[0].equals("afiseaza_cereri_in_asteptare") && functie.equals("elev")){
                    //System.out.println(functie);
                    util.sortDateElev(fileName);
                }
                if(line.split("; ")[0].equals("afiseaza_cereri_in_asteptare") && functie.equals("pensionar")){
                    util.sortDatePensionar(fileName);
                    //System.out.println(functie);
                }
                if(line.split("; ")[0].equals("afiseaza_cereri_in_asteptare") && functie.equals("entitate juridica")){
                    util.sortDateEntitateJuridica(fileName);
                    //System.out.println(functie);
                }
                line = bReader.readLine();
            }
            bReader.close();
            fReader.close();
        } catch (IOException e) {
            System.err.print(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(String filename, String text) {
        try (FileWriter fw = new FileWriter("src/main/resources/output/" + filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(text);
            out.println();
        } catch (IOException e) {
            System.err.print(e);
        }
    }

    public void sortDateAngajat(String fileName) {
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Angajat.cerereAngajat(fileName);
    }

    public void sortDatePersoana(String fileName) {
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Persoana.cererePersoana(fileName);
    }

    public void sortDateElev(String fileName) {
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Elev.cerereElev(fileName);
    }

    public static void sortDatePensionar(String fileName) {
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Pensionar.cererePensionar(fileName);
    }

    public void sortDateEntitateJuridica(String fileName) {
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        EntitateJuridica.cerereEntitate(fileName);
    }
    public void emptyfile(String filename){
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/output/" + filename);
            writer.print("");
            data.clear();
            cerere_util.clear();
            tip_cerere.clear();
            functie = "";
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.print(e);
        }
    }
}