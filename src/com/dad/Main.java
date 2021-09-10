package com.dad;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;


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
        // Reading whole file
        StringBuffer buffer = new StringBuffer();
        //Reading each line using the readLine() method
        while(file.getFilePointer() < file.length()) {
            buffer.append(file.readLine()+System.lineSeparator());
        }

        String contents = buffer.toString();

        char[] userInput = contents.toCharArray();

        int line = 0; // Only for appearance
        for (int z = (int)offset; z < length;z++) {
            line ++;
            if (line ==15){
                System.out.print('\n');
                line = 0;
            }
            System.out.printf("%d",(int) userInput[z]);
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

