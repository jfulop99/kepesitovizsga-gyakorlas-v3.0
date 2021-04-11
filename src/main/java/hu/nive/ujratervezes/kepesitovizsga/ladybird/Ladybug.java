package hu.nive.ujratervezes.kepesitovizsga.ladybird;

public class Ladybug {

    private String hungarianName;
    private String latinName;
    private String genus;
    private int numberOfPoints;

    public Ladybug(String hungarianName, String latinName, String genus, int numberOfPoints) {
        this.hungarianName = hungarianName;
        this.latinName = latinName;
        this.genus = genus;
        this.numberOfPoints = numberOfPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ladybug ladybug = (Ladybug) o;

        if (numberOfPoints != ladybug.numberOfPoints) return false;
        if (hungarianName != null ? !hungarianName.equals(ladybug.hungarianName) : ladybug.hungarianName != null)
            return false;
        if (latinName != null ? !latinName.equals(ladybug.latinName) : ladybug.latinName != null) return false;
        return genus != null ? genus.equals(ladybug.genus) : ladybug.genus == null;
    }

    @Override
    public int hashCode() {
        int result = hungarianName != null ? hungarianName.hashCode() : 0;
        result = 31 * result + (latinName != null ? latinName.hashCode() : 0);
        result = 31 * result + (genus != null ? genus.hashCode() : 0);
        result = 31 * result + numberOfPoints;
        return result;
    }

    public String getHungarianName() {
        return hungarianName;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getGenus() {
        return genus;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }
}
