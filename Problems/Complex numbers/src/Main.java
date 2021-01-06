class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ComplexNumber)) {
            return false;
        }

        ComplexNumber complexNumber = (ComplexNumber) obj;

        return re == complexNumber.re && im == complexNumber.im;
    }


    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + Float.floatToIntBits(Double.doubleToLongBits(re));
        result = 31 * result + Float.floatToIntBits(Double.doubleToLongBits(im));

        return result;
    }
}