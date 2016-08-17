package methods;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class FunctionCallAlphabet {

    public static void main(String[] args) {
	// ???? a( ???? );    // displays a word beginning with A
        a();
        b();
        c(true);
        d();
        e(9);
        f("Food");
        g();
        h(1);
        System.out.println();
        i(2);
        j(3);
        k();
        l(true, true);
        m(false, false);
        n("Nun");
        o();
        p();
        System.out.println();
        q();
        r(true);
        s(6);
        t("utankhamen");
        u();
        v(1);
        w(4);
        x(1);
        y();
        z(true, false);
    }

    /**
     * ************************************
     * Don't change anything below here!! *
	 ************************************
     */
    public static void a() {
        System.out.print("Ant ");
    }

    public static String b() {
        return "Banana ";
    }

    public static void c(boolean doit) {
        if (doit) {
            System.out.print("Crocodile ");
        }
    }

    public static void d() {
        System.out.print("Doggie ");
    }

    public static void e(int howmany) {
        String s;
        s = "Elephant ";
        int x = 0;
        while (x < howmany) {
            System.out.print(s.charAt(x));
            x = x + 1;
        }

    }

    public static void f(String word) {
        System.out.print(word + " ");
    }

    public static String g() {
        return "Gorilla ";
    }

    public static void h(int reps) {
        int x = 0;
        while (x < reps) {
            System.out.print("Horseradish ");
            x = x + 1;
        }

    }

    public static void i(int ignoredparameter) {
        ignoredparameter = 32;
        String space = Character.toString((char) ignoredparameter);
        System.out.print("Ice_cream" + space);
    }

    public static String j(int whichone) {
        if (whichone == 1) {
            return "Jambalaya ";
        } else if (whichone == 2) {
            return "Juniper ";
        } else {
            return "Jackrabbit ";
        }
    }

    public static void k() {
        // the bird OR the fruit
        System.out.print("Kiwi ");
    }

    public static void l(boolean a, boolean b) {
        if (a && b) {
            System.out.print("Lettuce ");
        } else {
            System.out.print("Lhasa_apso ");
        }
    }

    public static void m(boolean a, boolean b) {
        if (a || b) {
            System.out.print("Mango ");
        } else {
            System.out.print("Monkey! ");
        }
    }

    public static void n(String word) {
        System.out.print(word + " ");
    }

    public static int o() {
        System.out.print("Orangutan ");
        return 1;	// just for kicks; the return value doesn't mean anything
    }

    public static String p() {
        return "Parrot ";
    }

    public static void q() {
        System.out.print("Quail ");
    }

    public static String r(boolean first) {
        if (first) {
            return "Rabbit ";
        } else {
            return "Radish ";
        }
    }

    public static void s(int howmany) {
        String s;
        s = "Snake ";
        int x = 0;
        while (x < howmany) {
            System.out.print(s.charAt(x));
            x = x + 1;
        }
    }

    public static void t(String word) {
        System.out.print(word + " ");
    }

    public static String u() {
        return "Ugli_fruit ";
    }

    public static void v(int reps) {
        int x = 0;
        while (x < reps) {
            System.out.print("Valentine_candy ");
            x = x + 1;
        }
    }

    public static void w(int ignoredparameter) {
        ignoredparameter = 32;
        String space = Character.toString((char) ignoredparameter);
        System.out.print("Walrus" + space);
    }

    public static String x(int whichone) {
        if (whichone == 1) {
            return "X_files ";
        } else {
            return "X_men ";
        }
    }

    public static void y() {
        System.out.print("Yams ");
    }

    public static String z(boolean a, boolean b) {
        if (a || b) {
            return "Zanahorias ";
        } else {
            return "Zebra ";
        }
    }
}
