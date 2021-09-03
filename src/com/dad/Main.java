package com.dad;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Main {
 // Code in english, User Interface in French

    public static void main(String[] args) throws  FileNotFoundException, IOException{

        //Variables
        RandomAccessFile file = new RandomAccessFile("text.txt", "r");

        long offset = 0; // Default value
        long length = file.length();



        for (int i = 0; i < args.length; i++) {

            String a = args[i]; // Reads each input (a = args[i]-> allo)

            System.out.println(args[i]);

            // o (position) l (largeur) dans la fonction print data o = offset et l pour length

        }

            printData(file,offset,length);

        // TODO: Gestion des arguments.
        // TODO: Gestion du fichier.
    }

    public static void printData(RandomAccessFile file, long offset, long length) throws IOException {
        // TODO: Affichage des données.
        file.seek(offset);
        String a = file.readLine();
        char[] userInput=a.toCharArray();
        for (int i = 0; i < (int)length; i++) {
            userInput[i] = file.readChar();
        }

        for (int z = 0; z < length;z++) {
            System.out.printf("%d ",(int) userInput[z]);
        }
    }

    public static void printUsage() {
        // TODO: Affichage des indications.
    }

    public static void printStrings(byte minLength) {
        // TODO: Affichage des chaînes de caractères.
    }

    public static void printFormat() {
        // TODO: Affichage du format d'exécutable.
    }



}

