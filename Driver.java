public class Driver {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        // System.out.println(p.evaluate(3));
        double[] c1 = { 6, 0, 0, 5 };
        int[] c11 = { 3, 2, 4, 0 };
        Polynomial p1 = new Polynomial(c1, c11);
        double[] c2 = { 0, -2, 0, 0, -9 };
        int[] c22 = { 1, 2, 0, 5, 3 };
        Polynomial p2 = new Polynomial(c2, c22);
        Polynomial s = p1.add(p2);

        // for (int i = 0; i < s.coefficients.length; i++) {
        // System.out.println(s.coefficients[i]);
        // System.out.println(s.exp[i]);
        // }

        // System.out.println("s(3) = " + s.evaluate(3));

        // if(s.hasRoot(3))
        // System.out.println("3 is a root of s");
        // else
        // System.out.println("3 is not a root of s");
        // if(s.hasRoot(1))
        // System.out.println("1 is a root of s");
        // else
        // System.out.println("1 is not a root of s");

        // Polynomial s2 = p1.multiply(p2);
        // for (int i = 0; i < s2.coefficients.length; i++) {
        // System.out.println(s2.coefficients[i]);
        // System.out.println(s2.exp[i]);
        // }

        // System.out.println("s(3) = " + s2.evaluate(3));

        // if(s2.hasRoot(3))
        // System.out.println("3 is a root of s");
        // else
        // System.out.println("3 is not a root of s");
        // if(s2.hasRoot(1))
        // System.out.println("1 is a root of s");
        // else
        // System.out.println("1 is not a root of s");

        Polynomial p3 = new Polynomial(new FileReader("/Users/jiangjin/Desktop/2023 summer/CSCB07/b07lab2/file.txt"));

        // Test the saveToFile method
        polynomial.saveToFile("output.txt");

    }
}
