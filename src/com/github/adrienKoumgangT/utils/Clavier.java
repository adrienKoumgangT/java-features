package com.github.adrienKoumgangT.utils;

import java.io.*;

/**
 * <h3>U Q A M   -   I N F 1 1 2 0   e t   I N F 2 1 2 0</h3>
 *
 * <h1>Classe permettant l'entrée simple au clavier (console).</h1>
 *
 * <p>
 * Séparateur : (utilise par isWhitespace)
 * ----------
 *   voir <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/lang/Character.html#isWhitespace(char)">
 *       java.lang.Character.isWhiteSpace
 *       </a>
 *  <br>
 *   Un caractère est un séparateur en Java si et seulement si l'un des
 *   critères suivants est rencontre :
 *
 * <ul>
 *     <li>
 *         C'est un caractère Unicode espace (SPACE_SEPARATOR, LINE_SEPARATOR, ou PARAGRAPH_SEPARATOR)
 *         mais n'est pas aussi un caractère espace non-scable ('\u00A0', '\u2007', '\u202F').
 *      </li>
 *      <li>
 *          C'est '\u0009', HORIZONTAL TABULATION.
 *      </li>
 *      <li>
 *          C'est '\u000A', LINE FEED.                 LF
 *      </li>
 *      <li>
 *          C'est '\u000B', VERTICAL TABULATION.
 *      </li>
 *      <li>
 *          C'est '\u000C', FORM FEED.
 *      </li>
 *      <li>
 *          C'est '\u000D', CARRIAGE RETURN.           CR
 *      </li>
 *      <li>
 *          C'est '\u001C', FILE SEPARATOR.
 *      </li>
 *      <li>
 *          C'est '\u001D', GROUP SEPARATOR.
 *      </li>
 *      <li>
 *          C'est '\u001E', RECORD SEPARATOR.
 *      </li>
 *      <li>
 *          C'est '\u001F', UNIT SEPARATOR.
 *      </li>
 * </ul>
 *
 * <br>
 *   Voir aussi <a href="http://www.unicode.org">Unicode</a>
 * </p>
 *
 * <p>
 * fins de lignes
 * --------------
 * <br>
 *   Les fins de lignes sont codées de facon différente selon la plateforme :
 * <ul>
 *     <li>
 *         UNIX, Linux et Mac OS X			LF			\n
 *     </li>
 *     <li>
 *         Windows                          CR LF		\r \n
 *     </li>
 *     <li>
 *         Mac OS Classique                 CR			\r
 *     </li>
 * </ul>
 *  La présente classe gere les fins de lignes pour UNIX, Linux, Mac OS X et Windows
 *  </p>
 *
 * @author Louise Laforest (laforest.louise@uqam.ca)
 * @version 2004/10/07
 * @author Adrien Koumgang Tegantchouang
 * @modify 2022/12/16
 */
public class Clavier {

    /**
     * <h3> Vider Tampon </h3>
     *
     * antecedent : -
     * <br>
     * consequent : Vide le tampon d'entrée associe a la console.
     */
    public static void viderTampon() {
        try {
            System.in.skip( System.in.available() );
        } catch( IOException e ) {
            System.out.println ( "Le tampon d'entrée ne peut etre vide." );
        }
    }

    /**
     * <h3> Lire Fin Ligne </h3>
     *
     * antecedent :
     * <br>
     * consequent : Lit les caractères, à partir du curseur.
     * La fin de la ligne est déterminée par :
     * LF (line feed) ou par CR (carriage return) suivi de LF. LF et CR seront lus.
     */
    public static void lireFinLigne() {
        // On ne retourne pas la chaine (String) lue.
        lireString();
    }

    /**
     * <h3> Lire String </h3>
     *
     * antecedent :
     * <br>
     * consequent : Retourne la chaine lue, à partir du curseur.
     * La fin de la chaine est déterminée par :
     * LF (line feed) ou par CR (carriage return) suivi de LF.
     * Ni LF ni CR ne seront presents dans la chaine, mais auront ete lus.
     *
     * @return la chaine lue, à partir du curseur.
     */
    public static String lireString() {
        char nextCharacter;
        StringBuilder result = new StringBuilder();
        boolean finish = false;

        while ( ! finish ) {
            nextCharacter = lireChar(); // Lire un caractère
            if ( nextCharacter == '\r' ) { // CR
                nextCharacter = lireChar();
                if ( nextCharacter == '\n' ) { // LF
                    finish = true;
                } else { // CR doit etre suivi de LF, sous Windows
                    System.out.println ("Erreur fatale dans la methode lireLigne de la classe Clavier.");
                    System.exit(1); // 1 : pour signifier un arret anormal
                } // if non LF
            } else if ( nextCharacter == '\n' ) { // UNIX et Mac OS X
                finish = true;
            } else { // concaténer le caractère à la fin de la chaine
                result.append(nextCharacter);
            }
        }
        
        return result.toString();
    }

    /**
     * <h3> Lire Byte </h3>
     *
     * consequent : retourne le nombre entier octet lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le séparateur est lu.
     * Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     *
     * @return le nombre entier octet lu, à partir du curseur.
     */
    public static byte lireByte() {
        return Byte.parseByte( lireMot() );
    }

    /**
     * <h3> lire Byte Ln </h3>
     * antecedent : -
     * <br>
     * consequent : retourne le nombre entier octet lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut)
     * Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     * Le reste de la ligne, s'il y a lieu, est lu et ignore.
     *
     * @return le nombre entier octet lu, à partir du curseur.
     */
    public static byte lireByteLn() {
        byte byteLu;
        byteLu = Byte.parseByte( lireMot() );
        if ( ! finDeLigneLue ) {
            lireFinLigne();
        }
        return byteLu;
    }

    /**
     * <h3> Lire Short </h3>
     *
     * antecedent : -
     * <br>
     * consequent : retourne le nombre entier court lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le séparateur est lu. Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     *
     * @return le nombre entier court lu, à partir du curseur.
     */
    public static short lireShort() {
        return Short.parseShort( lireMot() );
    }

    /**
     * <h3> lire Short Ln </h3>
     *
     * antecedent : -
     * <br>
     * consequent : retourne le nombre entier court lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     * Le reste de la ligne, s'il y a lieu, est lu et ignore.
     *
     * @return le nombre entier court lu, à partir du curseur.
     */
    public static short lireShortLn() {
        short shortLu;
        shortLu = Short.parseShort( lireMot() );
        if ( ! finDeLigneLue ) {
            lireFinLigne();
        }
        return shortLu;
    }


    /**
     * <h3> lire Int </h3>
     *
     * antecedent : -
     * <br>
     * consequent : retourne le nombre entier lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le séparateur est lu.
     * Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     *
     * @return le nombre entier lu, à partir du curseur.
     */
    public static int lireInt() {
        return Integer.parseInt( lireMot() );
    }

    /**
     * <h3> lire Int Ln </h3>
     *
     * antecedent : -
     * <br>
     * consequent : retourne le nombre entier lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     * Le reste de la ligne, s'il y a lieu, est lu et ignore.
     *
     * @return le nombre entier lu, à partir du curseur.
     */
    public static int lireIntLn() {
        int intLu;
        intLu = Integer.parseInt( lireMot() );
        if ( ! finDeLigneLue ) {
            lireFinLigne();
        }
        return intLu;
    }

    /**
     * <h3> lire Long </h3>
     *
     * antecedent : -
     * <br>
     * consequent : retourne le nombre entier long lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le séparateur est lu.
     * Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     *
     * @return le nombre entier long lu, à partir du curseur.
     */
    public static long lireLong() {
        return Long.parseLong( lireMot() );
    }

    /**
     * <h3> Lire Long Ln </h3>
     *
     * antecedent : -
     * <br>
     * consequent : retourne le nombre entier long lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le nombre peut commencer par - (négatif) mais ne peut commencer par +.
     * Le reste de la ligne, s'il y a lieu, est lu et ignore.
     *
     * @return le nombre entier long lu, à partir du curseur.
     */
    public static long lireLongLn() {
        long longLu;
        longLu = Long.parseLong( lireMot() );
        if ( ! finDeLigneLue ) {
            lireFinLigne();
        }
        return longLu;
    }

    /**
     * <h3> Lire Float </h3>
     *
     * Antecedent : -
     * <br>
     * Consequent : retourne le nombre reel lu, à partir du curseur.
     * La fin du nombre est determine par un séparateur (voir ci-haut).
     * Le séparateur est lu. Le nombre peut commencer par - (négatif) ou + (positif).
     * Le nombre peut ne pas contenir le point decimal.
     */
    public static float lireFloat() {
        return Float.parseFloat( lireMot() );
    }

    /**
     * <h3> lire Float Ln </h3>
     *
     * antecedent : -
     * <br>
     * consequent : retourne le nombre reel lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le nombre peut commencer par - (négatif) ou + (positif).
     * Le nombre peut ne pas contenir le point decimal.
     * Le reste de la ligne, s'il y a lieu, est lu et ignore.
     *
     * @return le nombre reel lu, à partir du curseur.
     */
    public static float lireFloatLn() {
        float floatLu;
        floatLu = Float.parseFloat( lireMot() );
        if ( ! finDeLigneLue ) {
            lireFinLigne();
        }
        return floatLu;
    }

    /**
     * <h3> Lire Double </h3>
     *
     * antecedent :
     * <br>
     * consequent : retourne le nombre reel double lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le séparateur est lu. Le nombre peut commencer par - (négatif) ou + (positif).
     * Le nombre peut ne pas contenir le point decimal.
     *
     * @return le nombre reel double lu, à partir du curseur.
     */
    public static double lireDouble() {
        return Double.parseDouble( lireMot() );
    }

    /**
     * <h3> lire Double Ln </h3>
     *
     * antecedent :
     * <br>
     * consequent : retourne le nombre reel double lu, à partir du curseur.
     * La fin du nombre est déterminée par un séparateur (voir ci-haut).
     * Le nombre peut commencer par - (négatif) ou + (positif).
     * Le nombre peut ne pas contenir le point decimal.
     * Le reste de la ligne, s'il y a lieu, est lu et ignore.
     *
     * @return le nombre reel double lu, à partir du curseur.
     */
    public static double lireDoubleLn() {
        double doubleLu;
        doubleLu = Double.parseDouble( lireMot() );
        if ( ! finDeLigneLue ) {
            lireFinLigne();
        }
        return doubleLu;
    }

    /**
     * <h3> lire Char </h3>
     *
     * antecedent : -
     * <br>
     * consequent : Retourne le caractère lu, à partir du curseur.
     * Le curseur est rendu sur le caractère qui suit le caractère lu.
     *
     * @return le caractère lu, à partir du curseur.
     */
    public static char lireChar() {
        int codeAscii = -1; // valeur bidon

        try {
            codeAscii = System.in.read();
        } catch( IOException e ) {
            // on ne fait rien
        }

        return ( char ) codeAscii;
    }

    /**
     * <h3> lire Char Ln </h3>
     *
     * antecedent : -
     * <br>
     * consequent : Retourne le caractère lu, à partir du curseur.
     * Le reste de la ligne est ignoré.
     *
     * @return le caractère lu, à partir du curseur.
     */
    public static char lireCharLn() {
        String ligneLue;
        
        do {
            ligneLue = lireString();
        } while ( ligneLue.length() == 0 );
        
        return ligneLue.charAt(0);
    }

    /**
     * <h3> lire Mot </h3>
     *
     * antecedent : -
     * <br>
     * consequent : Retourne le mot lu, à partir du curseur.
     * Les séparateurs (voir plus haut) de debut sont ignorés.
     * La fin du mot est déterminée par un séparateur. Le séparateur qui suit le mot est lu.
     * Le curseur est rendu sur le premier caractère suivant le séparateur ayant determine la fin du mot.
     *
     * @return le mot lu, à partir du curseur.
     */
    private static String lireMot() {
        String resultat = "";
        char   car;            // caractère lu
        
        finDeLigneLue = false;

        // Sauter les séparateurs
        
        do {
            car =  lireChar();
        } while ( Character.isWhitespace( car ) );
        
        // Car ne contient pas un séparateur.
        // Lire et stocker dans le résultat jusqu'à un séparateur
        
        do {
            resultat = resultat + car;
            car =  lireChar();
        } while ( ! Character.isWhitespace( car ) );

        // Car contient un séparateur.
        // S'il s'agit de CR, il faut qu'il soit suivi de LF
        
        if ( car == '\n' ) {         // LF
            finDeLigneLue = true;
        } else if ( car == '\r' ) {  // CR
            finDeLigneLue = true;
            car = lireChar();
            if ( car != '\n' ) {     // LF
                System.out.println(
                    "Erreur fatale dans la methode lireMot de la classe Clavier.");
                System.exit(1);      // 1 : pour signifier un arret anormal
            }
        }

        return resultat;
        
    }
    
    private static boolean finDeLigneLue; // modifie par lireMot
                
}
