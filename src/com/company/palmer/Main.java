package com.company.palmer;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> tasks = new ArrayList<>();
        String user = "1";

        while(user == "1" || user == "2" || user == "3" || user == "4"){

            menu();
            user = user();

            switch(user) {
                case "1":
                    add(tasks);
                    user = "1";
                    break;
                case "2":
                    remove(tasks);
                    user = "1";
                    break;
                case "3":
                    update(tasks);
                    user = "1";
                    break;
                case "4":
                    list(tasks);
                    user = "1";
                    break;
                case "0":
                    exit();
                    break;
                default:
                    System.out.println("That is in invalid option. Please use the options provided. Press 'enter' to try again.");
                    user();
                    user = "1";

            }

        }

    }

    static void menu(){
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit.");
    }

    static List<String> add(List<String> tasks){
        System.out.println("Enter the task would you like to add or 'cancel' to exit: ");
        String user = user();
        int valid = 0;
        while (valid == 0) {
            if(user.trim().equalsIgnoreCase("cancel")){
                break;
            }else{
                try {
                    while (user.trim().equals("") || Integer.parseInt(user) < 2147483647) {
                        System.out.println("Please enter a real task or 'cancel' to exit. Press 'enter' to continue.");
                        user();
                        System.out.println("Enter the task would you like to add or 'cancel' to exit: ");
                        user = user();
                        if(user.trim().equalsIgnoreCase("cancel")){
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    valid += 1;
                    tasks.add(user);
                }
            }
        }
        System.out.println("Press 'enter' to continue.");
        user();
        return tasks;
    }

    static List<String> remove(List<String> tasks){
        if(tasks.size() < 1) {
            System.out.println("You have no tasks listed. Press 'enter' to continue.");
            user();
        }else {
            int valid = 0;
            while(valid == 0) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println("(" + i + ") " + tasks.get(i));
                }
                System.out.println("Enter the index of the task you'd like to remove or 'cancel' to exit: ");
                String user = user();
                if(user.trim().equalsIgnoreCase("cancel")){
                    break;
                }
                int i = 0;
                while(i < tasks.size()){
                    try {
                        if (Integer.parseInt(user) == i) {
                            tasks.remove(i);
                            valid += 1;
                        }
                        i += 1;
                    }catch(NumberFormatException e){
                        i += 1;
                    }
                }
                if(valid == 0){
                    System.out.println("Please enter a valid index or 'cancel' to exit. Press 'enter' to try again.");
                    user();
                }
            }
            System.out.println("Press 'enter' to continue.");
            user();
        }
        return tasks;
    }

    static List<String> update(List<String> tasks) {
        String cancel = "";

        if(tasks.size() < 1) {
            System.out.println("You have no tasks listed. Press 'enter' to continue.");
            user();
        }else {
            int valid = 0;
            while(valid == 0) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println("(" + i + ") " + tasks.get(i));
                }
                System.out.println("Enter the index of the task you'd like to update or 'cancel' to exit: ");
                String user = user();
                if (user.trim().equalsIgnoreCase("cancel")) {
                    cancel = "cancel";
                    break;
                } else {
                    int i = 0;
                    while(i < tasks.size()) {
                        try {
                            if (Integer.parseInt(user) == i) {
                                tasks.remove(i);
                                valid += 1;
                            }
                            i += 1;
                            } catch (NumberFormatException e) {
                             i += 1;
                            }
                    }
                    if (valid == 0) {
                        System.out.println("Please enter a valid index or 'cancel' to exit. Press 'enter' to try again.");
                        user();
                    }
                }
            }
            if (cancel.equals("cancel")) {
                cancel = "";
                //Do nothing and default back to main menu.
            } else {
                System.out.println("What would you like to update this task to?: ");
                String user = user();
                valid = 0;
                while (valid == 0) {
                    if (user.trim().equalsIgnoreCase("cancel")) {
                        cancel = "cancel";
                        break;
                    } else {
                        try {
                            while (user.trim().equals("") || Integer.parseInt(user) < 2147483647) {
                                System.out.println("Please enter a real task or 'cancel' to exit. Press 'enter' to continue.");
                                user();
                                System.out.println("What would you like to update this task to?: ");
                                user = user();
                            }
                        } catch (NumberFormatException e) {
                            tasks.add(user);
                            valid += 1;
                        }
                    }
                }
            }
            System.out.println("Press 'enter' to continue.");
            user();
        }
        return tasks;
    }


    static void list(List<String> tasks){
        if(tasks.size() == 0){
            System.out.println("You have no tasks listed. Press 'enter' to continue.");
            user();
        }else{
            System.out.println(tasks);
            System.out.println("Press 'enter' to continue.");
            user();
        }
    }

    static void exit(){
        System.exit(0);
    }

    static String user(){
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();
        return user;
    }

}
