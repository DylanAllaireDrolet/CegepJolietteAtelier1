package com.dad;



import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;


public class Main {
    
    // Code in english, User Interface in French

    public static void main(String[] args) throws  FileNotFoundException, IOException{

        //Variables


        long offset = 0; // Default value
        long length = 0; boolean definedLength = false;
        String f = "-f", o = "-o", l = "-l";
        String fileName = "";

        for (int i = 0; i < args.length; i++) {





            if (Objects.equals(args[i], f)) {
            fileName = args[i + 1];

            }
            if (Objects.equals(args[i], "-o")) {
                offset = Long.parseLong(args[i + 1].toString());

            }

            if (Objects.equals(args[i], "-l")) {
                length = Long.parseLong(args[i + 1]);
                definedLength = true;
            }


        }
        RandomAccessFile file = new RandomAccessFile(fileName,"r");
        if (length > file.length())
            length = file.length();
            if (!definedLength)
                length = file.length();
            printData(file,offset,length);

        // TODO: Gestion des arguments.
        // TODO: Gestion du fichier.
    }

    public static void printData(RandomAccessFile file, long offset, long length) throws IOException {

        // Reading whole file
        StringBuffer buffer = new StringBuffer();
        //Reading each line using the readLine() method
        while(file.getFilePointer() < file.length()) {
            buffer.append(file.readLine()+System.lineSeparator());
        }

        String contents = buffer.toString();

        char[] userInput = contents.toCharArray();
        System.out.println("         \t\u001B[33m0\t1\t2\t3\t4\t5\t6\t7\t8\t9\tA\tB\tC\tD\tE\tF\tASCII"); // 9 spaces at the beginning so everything lines up
        System.out.print("\u001B[37m");
        String[] memory = {"0x0000000","0x0000010","0x0000020","0x0000030","0x0000040",
                "0x0000050","0x0000060","0x0000070","0x0000080","0x0000090"};





        int line = 0; // Only for appearance
        int memoryLine = (int) (offset/16);
        boolean end =  false;
        System.out.printf("\u001B[33m%s\t",memory[memoryLine]);
        for (int i = (int)offset; i < length ;i++) { // Printing ASCII and Hexadecimal

            if (i == length - 1 && line < 16) {
                System.out.printf("\u001B[36m%s\t",Integer.toHexString((int) userInput[i]));
                for (int x = line; x != 15; x++) {
                    System.out.printf(" \t");
                    line = 16;

                    end = true;
                }
            }

            if (line ==16){
                char[] stringInput = userInput;
                memoryLine++;
                for (int z = i - 16;z < i; z++) {
                    if (stringInput[z] == '\n' || stringInput[z] =='\r') {stringInput[z] = '.';}

                        System.out.printf("\u001B[37m%s", stringInput[z]);


                }
                if(!end)
                    System.out.print('\n');
                System.out.printf("\u001B[33m%s\t",memory[memoryLine]);

                line = 0;

            }

            line ++;

            if (!end)
                System.out.printf("\u001B[36m%s\t",Integer.toHexString((int) userInput[i])); // Translate ASCII into Hexadecimal
            //System.out.printf("%d ",(int) userInput[i]); // Translate ASCII into Decimal
            char[] stringInput = userInput;


        }
    }

    public static void printUsage() {

    }

    public static void printStrings(byte minLength) {
        // TODO: Affichage des chaînes de caractères.
    }

    public static void printFormat() {
        // TODO: Affichage du format d'exécutable.
    }




}

