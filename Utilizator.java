package org.example;
import java.util.ArrayList;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
            while (line != null) {
                if (line.split("; ")[0].equals("adauga_utilizator")) {
                    if (line.split("; ")[1].equals("angajat")) {
                        Angajat angajat = new Angajat();
                        angajat.nume = line.split("; ")[2];
                        functie = line.split("; ")[1];
                        angajat.companie = line.split("; ")[3];
                    }
                    else if (line.split("; ")[1].equals("persoana")) {
                        Persoana persoana = new Persoana();
                        persoana.nume = line.split("; ")[2];
                        functie = line.split("; ")[1];
                    }
                    else if (line.split("; ")[1].equals("elev")) {
                        Elev elev = new Elev();
                        elev.nume = line.split("; ")[2];
                        functie = line.split("; ")[1];
                        elev.scoala = line.split("; ")[3];
                    }
                    else if (line.split("; ")[1].equals("pensionar")) {
                        Pensionar pensionar = new Pensionar();
                        pensionar.nume = line.split("; ")[2];
                        functie = line.split("; ")[1];
                    }
                    else if (line.split("; ")[1].equals("entitate juridica")) {
                        EntitateJuridica entitateJuridica = new EntitateJuridica();
                        entitateJuridica.nume = line.split("; ")[2];
                        functie = line.split("; ")[1];
                        entitateJuridica.reprezentant = line.split("; ")[3];
                    }
                }
                if(functie.equals("angajat")){
                    Angajat.checkAngajat(line, fileName);
                    if (line.split("; ")[0].equals("afiseaza_cereri_in_asteptare"))
                        writeFile(fileName, Angajat.nume + " - cereri in asteptare:");
                }
                else if(functie.equals("persoana")){
                    Persoana.checkPersoana(line, fileName);
                    if (line.split("; ")[0].equals("afiseaza_cereri_in_asteptare"))
                        writeFile(fileName, Persoana.nume + " - cereri in asteptare:");
                }
                else if(functie.equals("elev")){
                    Elev.checkElev(line, fileName);
                    if (line.split("; ")[0].equals("afiseaza_cereri_in_asteptare"))
                        writeFile(fileName, Elev.nume + " - cereri in asteptare:");
                }
                else if(functie.equals("pensionar")){
                    Pensionar.checkPensionar(line, fileName);
                    if (line.split("; ")[0].equals("afiseaza_cereri_in_asteptare"))
                        writeFile(fileName, Pensionar.nume + " - cereri in asteptare:");
                }
                else if(functie.equals("entitate juridica")){
                    EntitateJuridica.checkEntitateJuridica(line, fileName);
                    if (line.split("; ")[0].equals("afiseaza_cereri_in_asteptare"))
                        writeFile(fileName, EntitateJuridica.nume + " - cereri in asteptare:");
                }
                line = bReader.readLine();
            }
            if(functie.equals("angajat"))
                sortDateAngajat(fileName);
            else if (functie.equals("persoana"))
                sortDatePersoana(fileName);
            else if (functie.equals("elev"))
                sortDateElev(fileName);
            else if (functie.equals("pensionar"))
                sortDatePensionar(fileName);
            else if (functie.equals("entitate juridica"))
                sortDateEntitateJuridica(fileName);
            System.out.println(functie);
            System.out.println(cerere_util);
            System.out.println(data);
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

    public static void sortDateAngajat(String fileName) {
        System.out.println(cerere_util.size());
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Angajat.cerere(fileName);
    }

    public static void sortDatePersoana(String fileName) {
        System.out.println(cerere_util.size());
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Persoana.cerere(fileName);
    }

    public static void sortDateElev(String fileName) {
        System.out.println(cerere_util.size());
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Elev.cerere(fileName);
    }

    public static void sortDatePensionar(String fileName) {
        System.out.println(cerere_util.size());
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        Pensionar.cerere(fileName);
    }

    public static void sortDateEntitateJuridica(String fileName) {
        System.out.println(cerere_util.size());
        for (int x = 0; x < data.size(); x++) {
            for (int j = x + 1; j < data.size(); j++) {
                if (data.get(x).compareTo(data.get(j)) > 0) {
                    Collections.swap(data, x, j);
                    Collections.swap(cerere_util, x, j);
                }
            }
        }
        EntitateJuridica.cerere(fileName);
    }
    public static void emptyfile(String filename){
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/output/" + filename);
            writer.print("");
            data.clear();
            cerere_util.clear();
            tip_cerere.clear();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.print(e);
        }
    }
}