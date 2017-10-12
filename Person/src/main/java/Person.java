public class Person {
    private final boolean man;
    private Person spouse;
    private final String name;

    public Person getSpouse() {
        return spouse;
    }

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person other) {
        if (this.man == other.man) return false;
        if (this.spouse == other) return false;

        if (this.spouse != null) this.divorce();
        if (other.spouse != null) other.divorce();
        this.spouse = other;
        other.spouse = this;
        return true;
    }

    public boolean divorce() {
        if (this.spouse == null) return false;
        this.spouse.spouse = null;
        this.spouse = null;
        return true;
    }
}
