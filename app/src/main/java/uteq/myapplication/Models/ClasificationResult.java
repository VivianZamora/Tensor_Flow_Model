package uteq.myapplication.Models;

public class ClasificationResult {
    private int identifier = -1;
    private String plateName = "";
    private float precision = 0;

    public ClasificationResult() {
    }

    public ClasificationResult(int identifier, String plateName, float precision) {
        this.identifier = identifier;
        this.plateName = plateName;
        this.precision = precision;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public float getPrecision() {
        return precision;
    }

    public void setPrecision(float precision) {
        this.precision = precision;
    }
}
