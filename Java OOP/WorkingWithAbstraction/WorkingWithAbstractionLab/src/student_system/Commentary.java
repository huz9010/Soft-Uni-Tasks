package student_system;

public enum Commentary {

    Excellent ("Excellent student"),
    Average ("Average student"),
    Nice ("Very nice person");

    private String text;

    public String getText() {
        return this.text;
    }

    Commentary(String text) {
        this.text = text;
    }
}
