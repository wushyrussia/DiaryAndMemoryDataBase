package com.company.backend;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Packard Bell on 22.09.2018.
 */
public class Menu {
    Menu() throws IOException {
        listMenu();

        Scanner cmdNumber = new Scanner(System.in);
        int number = 0;
           number = cmdNumber.nextInt();
           System.out.println(number);
           switch (number){
            case 1: {
                Entry newEntry = new Entry();
                newEntry.createDocument();
                break;
            }
            case 2:{
                new ListEntry();

            break;
            }
        }

    }
        public void listMenu(){
            System.out.println("Enter the number of command");
            System.out.println("*1* - Write new Entry");
            System.out.println("*2* - Read Entry");
           // System.out.println("");
    }
    }

