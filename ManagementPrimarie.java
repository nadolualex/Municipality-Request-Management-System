package org.example;

import jdk.jshell.execution.Util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

public class ManagementPrimarie {

    public static void main(String[] args) throws IOException, ParseException {
        // Your code here
            Utilizator util = new Utilizator() {
            };

            util.emptyfile(args[0]);
            util.readFile(args[0]);
    }
}