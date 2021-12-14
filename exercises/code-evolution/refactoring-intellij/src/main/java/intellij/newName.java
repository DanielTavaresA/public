package intellij;

public class newName extends superNewName {
    // This name is really bad
    private String name;

    public newName(String s) {
        name = s;
    }

    // This method is very long and hard to understand
    public String longAndComplicatedMethod() {
        // Compute some value of n
        int n = getN();

        // Do some stuff to the string, based on n
        String s = getString(n);

        return s;
    }

    private String getString(int n) {
        String s = name.repeat(n);
        s = s.concat("!!");
        s = s.toUpperCase();
        s = s.replaceAll("[AEIOUY]", "<3");
        s = s.concat(name);
        s = s.repeat(n);
        s = s.substring(s.length()/2);
        return s;
    }

    private int getN() {
        int n = name.length();
        n *= 51;
        n >>= 3;
        n %= 5;
        n = Math.max(n, 1);
        return n;
    }

    // This method returns the length of our attribute

    // Intellij sometimes recognizes code smells and offers you quick fixes
    public void multiplesOf1() {
        int a = 1;
        multiplesN(a);
    }

    private void multiplesN(int a) {
        System.out.printf("=== Multiples of %d ===\n", a);
        for(int i = 1; i <= 12; i++) {
            System.out.printf("%d * %d = ", i, a);
            System.out.print(i * a);
            System.out.print("\n");
        }
    }

    public void multiplesOf2() {
        int a = 2;
        multiplesN(a);
    }
}
