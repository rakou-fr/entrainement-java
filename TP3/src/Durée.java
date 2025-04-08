public class Durée {
    private int heures;
    private int minutes;
    private int secondes;

    public Durée(int heures, int minutes, int secondes){
        if (heures < 0){
            throw new IllegalArgumentException("Heures invalide !");
        } else if (minutes < 0 && minutes > 59) {
        	throw new IllegalArgumentException("Minutes invalide !");
        } else if (secondes < 0 && secondes > 59) {
        	throw new IllegalArgumentException("Seconde invalide !");
        }
		this.heures = heures;
		this.minutes = minutes;
		this.secondes = secondes;
    }

    public int getHeures(){
        return this.heures;
    }

    public int getMinutes(){
        return this.minutes;
    }
    
    public int getSecondes(){
        return this.secondes;
    }

    public boolean égal(Durée d) {
        return this.heures == d.heures && 
        this.minutes == d.minutes && 
        this.secondes == d.secondes;
    }

    public boolean inf(Durée d){
        return this.heures < d.heures || 
        (this.heures == d.heures && this.minutes < d.minutes) ||
        (this.heures == d.heures && this.minutes < d.minutes && this.secondes < d.secondes); 
    }

    public void ajouterUneSeconde(){
        if (this.secondes < 59){
            this.secondes++;
        }else {
            this.secondes = 0;
            if (this.minutes < 59){
                this.minutes++;
            } else {
                this.minutes = 0;
                this.heures++;
            }
        }
    }

    @Override
    public String toString(){
        return this.heures + ":" + this.minutes + ":" + this.secondes;
    }

}