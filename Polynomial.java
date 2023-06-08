import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Polynomial {
    double[] coefficients;
    int[] exp;

    public Polynomial() {
        coefficients = new double[1];
        coefficients[0] = 0.0;
        exp = new int[1];
        exp[0] = 0;
    }

    public Polynomial(double[] coefficients, int[] exp) {
        this.coefficients = coefficients;
        this.exp = exp;
    }

    public Polynomial removeZeros(double[] coef, int[] exp) {

        // if coef[i] and exp[i] are both zeroes,
        int count = 0;
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] != 0) {
                count++;
            }
        }

        double[] coef_new = new double[count];
        int[] exp_new = new int[count];

        int pos = 0;
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] != 0) {
                coef_new[pos] = coef[i];
                exp_new[pos] = exp[i];
                pos++;
            }
        }
        return new Polynomial(coef_new, exp_new);
    }

    public Polynomial add(Polynomial other) {
        int maxLength = coefficients.length + other.coefficients.length;
        double[] coefResult = new double[maxLength];
        int[] expResult = new int[maxLength];

        for (int i = 0; i < this.coefficients.length; i++) {
            coefResult[i] += this.coefficients[i];
            expResult[i] = this.exp[i];
        }

        for (int j = this.coefficients.length; j < this.coefficients.length + other.coefficients.length; j++) {
            coefResult[j] += other.coefficients[j - this.coefficients.length];
            expResult[j] = other.exp[j - this.coefficients.length];
        }
        return removeZeros(coefResult, expResult);
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, exp[i]);
        }
        return result;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0.0;
    }

    public int findMax(int[] array) {
        int max = array[0]; // Assume the first element is the maximum

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public Polynomial multiply(Polynomial input) {
        int size1 = findMax(input.exp);
        int size2 = findMax(exp);
        int length = size1 * size2;
        // System.out.println(length);
        double[] coefResult = new double[length];
        int[] expResult = new int[length];

        for (int i = 0; i < input.coefficients.length; i++) // loop through the input first
        {
            for (int j = 0; j < this.coefficients.length; j++) // loop through the calling object
            {
                int currentExp = input.exp[i] + this.exp[j]; // find the multiplied exponents
                expResult[currentExp] = currentExp;
                coefResult[currentExp] += input.coefficients[i] * this.coefficients[j];
            }
        }
        return removeZeros(coefResult, expResult);
    }

    // constructor
    public Polynomial(File file) {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        String[] terms = line.split("(?=[-+])");
        // for(int j = 0; j < terms.length; j++)
        // {
        // System.out.println(terms[j]);
        // }

        coefficients = new double[terms.length];
        exponents = new int[terms.length];

        for (int i = 0; i < terms.length; i++) {
            String[] parts = terms[i].split("x");
            coefficients[i] = Double.parseDouble(parts[0]);
            exponents[i] = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
        }
        reader.close();
    }

    public void saveToFile(String poly) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(poly));
        StringBuilder polynomialText = new StringBuilder();
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] != 0) {
                polynomialText.append(coefficients[i]);
                if (exp[i] != 0) {
                    polynomialText.append("x").append(exp[i]);
                }
            }
        }
        writer.write(polynomialText.toString());
        writer.close();
    }
}
