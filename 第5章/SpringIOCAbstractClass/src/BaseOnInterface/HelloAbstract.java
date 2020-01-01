package BaseOnInterface;

public abstract class HelloAbstract implements HelloInterface {
    private Random random;

    public void setRandom(Random random) {
        this.random = random;
    }

    public abstract Random createRandom();
} 
