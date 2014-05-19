/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweetBank;

/**
 *
 * @author vladde
 */
public class SQLInjections {

    public static boolean variableSecureFromSQLInjection_Letters(String t) {
        int count = 0;
        String allowed = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö";
        if (t.contains(" ")) {
            return false;
        } else {
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < allowed.length(); j++) {
                    if (t.charAt(i) == allowed.charAt(j)) {
                        count++;
                    }
                }
            }
            return count == t.length();

        }
    }

    public static boolean variableSecureFromSQLInjection_Numeric(String t) {
        int count = 0;
        String allowed = "0123456789";
        if (t.contains(" ")) {
            return false;
        } else {
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < allowed.length(); j++) {
                    if (t.charAt(i) == allowed.charAt(j)) {
                        count++;
                    }
                }
            }
            return count == t.length();

        }
    }

    public static boolean variableSecureFromSQLInjection(String t) {
        int count = 0;
        String allowed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        if (t.contains(" ")) {
            return false;
        } else {
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < allowed.length(); j++) {
                    if (t.charAt(i) == allowed.charAt(j)) {
                        count++;
                    }
                }
            }
            return count == t.length();

        }
    }

    public static boolean variableSecureFromSQLInjection(String t, boolean a) {
        int count = 0;
        String allowed = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖabcdefghijklmnopqrstuvwxyzåäö0123456789@ ";
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < allowed.length(); j++) {
                if (t.charAt(i) == allowed.charAt(j)) {
                    count++;
                }
            }
        }
        return count == t.length();

    }

}
