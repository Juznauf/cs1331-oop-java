public class Complex {
    // these are the data of the ADT
    
    private double real; // declare global variables
    private double imaginary; // declare global variables

    // these are the operations of the ADT

    public Complex(double aReal, double anImaginary) {
        // this is the ADT constructor
        real = aReal;
        imaginary = anImaginary;
    }

    public Complex plus(Complex other) {
        double resultReal = this.real + other.real;
        double resultImaginary = this.imaginary + other.imaginary;
        return new Complex(resultReal, resultImaginary);
    }
}
