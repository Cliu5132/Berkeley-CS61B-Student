import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionArray = new ArrayDequeSolution<>();
        StringBuilder log = new StringBuilder();

        for (int i = 0; i < 1000; i++) {
            performRandomOperation(testArray, solutionArray, log);
        }
    }

    private void performRandomOperation(StudentArrayDeque<Integer> testArray, ArrayDequeSolution<Integer> solutionArray, StringBuilder log) {
        if (solutionArray.size() == 0) {
            performAddOperation(testArray, solutionArray, log);
        } else {
            performRandomOperationWithNonEmptyDeque(testArray, solutionArray, log);
        }
    }

    private void performAddOperation(StudentArrayDeque<Integer> testArray, ArrayDequeSolution<Integer> solutionArray, StringBuilder log) {
        int addNumber = StdRandom.uniform(1000);
        int headOrBack = StdRandom.uniform(2);

        if (headOrBack == 0) {
            log.append("addFirst(").append(addNumber).append(")\n");
            testArray.addFirst(addNumber);
            solutionArray.addFirst(addNumber);
        } else {
            log.append("addLast(").append(addNumber).append(")\n");
            testArray.addLast(addNumber);
            solutionArray.addLast(addNumber);
        }
    }

    private void performRandomOperationWithNonEmptyDeque(StudentArrayDeque<Integer> testArray, ArrayDequeSolution<Integer> solutionArray, StringBuilder log) {
        int chooseMethod = StdRandom.uniform(4);
        int addNumber = StdRandom.uniform(1000);
        Integer testRemoveNumber = 1;
        Integer solutionRemoveNumber = 1;

        switch (chooseMethod) {
            case 0:
                log.append("addFirst(").append(addNumber).append(")\n");
                testArray.addFirst(addNumber);
                solutionArray.addFirst(addNumber);
                break;
            case 1:
                log.append("addLast(").append(addNumber).append(")\n");
                testArray.addLast(addNumber);
                solutionArray.addLast(addNumber);
                break;
            case 2:
                log.append("removeFirst()\n");
                testRemoveNumber = testArray.removeFirst();
                solutionRemoveNumber = solutionArray.removeFirst();
                break;
            case 3:
                log.append("removeLast()\n");
                testRemoveNumber = testArray.removeLast();
                solutionRemoveNumber = solutionArray.removeLast();
                break;
            default:
        }

        assertEquals(log.toString(), solutionRemoveNumber, testRemoveNumber);
    }
}
