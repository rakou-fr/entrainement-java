public class Monome {

    private final float coefficient;

    private final int exposant;
    
    /**
     * crée un monome
     * @param coefficient
     * @param exposant
     * @throws IllegalArgumentException
     */
    public Monome(float coefficient, int exposant)
            throws IllegalArgumentException {
        if (exposant < 0) {
            throw new IllegalArgumentException("exposant négatif");
        }
        this.coefficient = coefficient;
        this.exposant = exposant;
    }

    public float getCoefficient() {
        return this.coefficient;
    }

    public int getExposant() {
        return this.exposant;
    }

    public Monome somme(Monome m) throws ArithmeticException {
        if (this.getExposant() != m.getExposant()) {
            throw new ArithmeticException(
                    "coefficient des deux monômes différents");
        }
        return new Monome(this.getCoefficient() + m.getCoefficient(),
                this.getExposant());
    }

    public Monome produit(Monome m) {
        return new Monome(this.getCoefficient() * m.getCoefficient(),
                this.getExposant() + m.getExposant());
    }

    public Monome dérivée() {
        if (this.getExposant() == 0) {
            return new Monome(0, 0);
        } else {
            return new Monome(this.getCoefficient() * this.getExposant(),
                    this.getExposant() - 1);
        }
    }

    public boolean estNul() {
        return this.getCoefficient() == 0;
    }

    @Override
    public String toString() {
        if (this.coefficient == 0) {
            return "0.0xe" + this.exposant;
        }

        
        if (this.coefficient == -1) {
            return "-x" + (this.exposant == 0 ? "" : "e" + this.exposant);
        }

        
        if (this.coefficient == 1) {
            return "+" + (this.exposant == 0 ? "1.0" : "x" + (this.exposant == 1 ? "" : "e" + this.exposant));
        }
        
        String coefficientStr = this.coefficient + "";
        if (this.exposant == 0) {
            return coefficientStr;
        }

        return coefficientStr + "e" + this.exposant;
    }

    
}