package exercise2.primeNumbers;

/**
 * 3. 3. 2022 - 16:58
 *
 * @author user
 */
public class Number {
    private int value;
    private boolean prime;
    private boolean visible;

    public Number(int value) {
        this.value = value;
        this.prime = false;
        this.visible = true;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isPrime() {
        return this.prime;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
