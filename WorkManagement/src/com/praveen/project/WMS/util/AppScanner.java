package com.praveen.project.WMS.util;

import java.util.Scanner;

public class AppScanner {
    private static final Scanner sc = new Scanner(System.in);
    private AppScanner() {}
    public static Scanner get() { return sc; }
}