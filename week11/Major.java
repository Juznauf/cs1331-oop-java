public enum Major {
    CS("Computer Science", 4),
    POLSCI("Political Science", 1),
    LAW("Law", 5),
    ECON("Economics", 3),
    BIZ("Business", 2);

    public final String name;
    public final int difficulty;
    
    Major(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public static void main(String[] args) {
        for (Major m: Major.values()) {
            System.out.println(m.name);
        }
    }

}