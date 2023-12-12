public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int number) {
        this.N = number;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Character.isLetter(x) && Character.isLetter(y)) {
            char lowerX = Character.toLowerCase(x);
            char lowerY = Character.toLowerCase(y);

            return Math.abs(lowerX - lowerY) == N;
        } else {
            return x == y;
        }
    }
}
