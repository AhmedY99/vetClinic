/*
 * The Dog class keep to track of characteristics of a dog.
 */
package vetclinic;

/**
 *
 * @author Ayuss
 */
public final class Dog {

    // private properties of the dog 
    private String name;
    private String owner;
    private String breed;
    private double weight;
    private static int dogCount = 0;

    /**
     * Define default constructor Initialize the String empty and the weight to
     * 0
     */
    public Dog() {
        name = "None";
        owner = "None";
        breed = "None";
        weight = 0.0;
        dogCount++;
    }

    /**
     * Define second constructor to initialize Call the appropriate setter
     * methods.
     *
     * @param name
     * @param owner
     * @param breed
     * @param weight
     */
    public Dog(String name, String owner, String breed, double weight) {
        setName(name);
        setOwner(owner);
        setBreed(breed);
        setWeight(weight);
        dogCount++;
    }

    /**
     * Define setName method
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Define setOwner method
     *
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Define setBreed method
     *
     * @param breed
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Define setWeight method to output if the weight is greater than 0 and
     * below 350
     *
     * @param weight
     */
    public void setWeight(double weight) {
        if (weight >= 0 && weight <= 350) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }

    /**
     * Define getName method
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Defines getOwner method
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Defines getBreed method
     *
     * @return breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Defines getWeight method
     *
     * @return double weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Defines getCount method keeps trucks the number of dogCount
     *
     * @return dogCount
     */
    public static int getCount() {
        return Dog.dogCount;
    }

    /**
     *
     * @return a String with a nicely formatted version of the dog’s properties.
     */
    @Override
    public String toString() {
        String output = "";
        output += this.name + " ";
        output += "(" + this.breed + ")";
        output += ", " + this.weight + " lbs ";
        output += "owned by " + this.owner;
        return output;
    }

    public static Dog getHeaviest(Dog[] d) {
        int i;
        Dog a = new Dog();
        a.setWeight(0);

        for (i = 0; i < d.length; i++) {
            if (d[i].getWeight() <= a.getWeight()) {
                a = d[i];
            }
        }
        return a;
    }
}
