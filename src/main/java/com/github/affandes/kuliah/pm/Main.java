package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.Scanner;

public class BrowserHistory {
    private LinkedList<String> history;

    // Constructor
    public BrowserHistory() {
        history = new LinkedList<>();
    }

    
    public void browse(String url) {
        history.addFirst(url);  // Tambahkan ke urutan pertama (paling baru)
        System.out.println("Browsing to: " + url);
    }

    
    public void back() {
        if (!history.isEmpty()) {
            System.out.println("Going back from: " + history.removeFirst());
        } else {
            System.out.println("No history to go back to.");
        }
    }

    
    public void view() {
        if (history.isEmpty()) {
            System.out.println("No browsing history.");
        } else {
            System.out.println("Browsing history:");
            for (String url : history) {
                System.out.println("- " + url);
            }
        }
    }

    
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an action: browse, back, view, or exit:");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "browse":
                    System.out.println("Enter URL to browse:");
                    String url = scanner.nextLine();
                    browserHistory.browse(url);
                    break;

                case "back":
                    browserHistory.back();
                    break;

                case "view":
                    browserHistory.view();
                    break;

                case "exit":
                    System.out.println("Exiting the browser...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid action. Please choose again.");
            }
        }
    }
}
