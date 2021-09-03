package com.dad;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Main {


    public static void main(String[] args)  {
        try {
            RandomAccessFile file = new RandomAccessFile("text.txt", "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        for (int i = 0; i < args.length; i++) {

            String a = args[i];
            char[] characters=a.toCharArray();
            System.out.println(args[i]);
            for (int z =0; z < characters.length;z++) {
                System.out.println((int) characters[z]); // Comment écrire les données en ascii
            }
            // o (position) l (largeur) dans la fonction print data o = offset et l pour length

        }

        // TODO: Gestion des arguments.
        // TODO: Gestion du fichier.
    }

    public static void printData(RandomAccessFile file, long offset, long length) throws IOException {
        // TODO: Affichage des données.

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

