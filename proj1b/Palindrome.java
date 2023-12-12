public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }

        Deque d = wordToDeque(word);

        return isPalindromeHelper(d);
    }

    private boolean isPalindromeHelper(Deque item) {
        if (item.size() <= 1) {
            return true;
        }

        if (item.removeFirst() == item.removeLast()) {
            return isPalindromeHelper(item);
        }

        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        }

        Deque d = wordToDeque(word);

        return isPalindromeHelper(d, cc);
    }

    private boolean isPalindromeHelper(Deque item, CharacterComparator cc) {
        if (item.size() <= 1) {
            return true;
        }

        if (cc.equalChars((char) item.removeFirst(), (char) item.removeLast())) {
            return isPalindromeHelper(item, cc);
        }

        return false;
    }
}
