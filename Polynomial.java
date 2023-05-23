public class Polynomial
{
    double[] coefficients;
        
    public Polynomial()
    {
        coefficients = new double[1];
        coefficients[0] = 0.0;
    }
        
    public Polynomial(double[] coefficients)
    {
        this.coefficients = coefficients;
    }
    
    public Polynomial add(Polynomial other)
    {
        int maxLength = Math.max(coefficients.length, other.coefficients.length);
        double[] result = new double[maxLength];

        for (int i = 0; i < coefficients.length; i++) {
            result[i] += coefficients[i];
        }

        for (int i = 0; i < other.coefficients.length; i++) {
            result[i] += other.coefficients[i];
        }

        return new Polynomial(result);
    }
    
    public double evaluate(double x)
    {
        double result = 0.0;
        for(int i = 0; i < coefficients.length; i++)
        {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }
    
    public boolean hasRoot(double x)
    {
        return evaluate(x) == 0.0;
    }
}