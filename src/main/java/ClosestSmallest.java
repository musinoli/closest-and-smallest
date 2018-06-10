import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.codewars.com/kata/5868b2de442e3fb2bb000119
 */
class ClosestSmallest {

    static int[][] closest(String numbers) {
        if (numbers.length() == 0) throw new UnsupportedOperationException();
        List<NumberWeight> numberWeights = getNumberWeights(numbers);
        Collections.sort(numberWeights);
        int smallestWeightDiff = Integer.MAX_VALUE;
        NumberWeight smallestFirst = numberWeights.get(0);
        NumberWeight smallestSecond = numberWeights.get(1);
        NumberWeight prev = numberWeights.get(0);
        int currentIndex = 1;
        while (currentIndex < numberWeights.size()) {
            NumberWeight current = numberWeights.get(currentIndex);
            int weightDiff = current.weight - prev.weight;
            if (weightDiff < smallestWeightDiff) {
                smallestWeightDiff = weightDiff;
                smallestFirst = prev;
                smallestSecond = current;
            }
            currentIndex++;
            prev = current;
        }
        return output(smallestFirst, smallestSecond);
    }

    private static List<NumberWeight> getNumberWeights(String numbers) {
        List<NumberWeight> numberWeights = new LinkedList<>();
        StringBuilder numBuilder = new StringBuilder();
        int weight = 0;
        int numIndex = 0;
        for (int i = 0; i < numbers.length(); i++) {
            char current = numbers.charAt(i);
            if (current != ' ') {
                numBuilder.append(current);
                weight += Character.getNumericValue(current);
            }
            if (current == ' ' || i == numbers.length() - 1) {
                numberWeights.add(new NumberWeight(
                        Integer.valueOf(numBuilder.toString()), weight, numIndex++));
                weight = 0;
                numBuilder.setLength(0);
            }
        }
        return numberWeights;
    }

    private static int[][] output(NumberWeight first, NumberWeight second) {
        return new int[][]{{first.weight, first.index, first.number}, {second.weight, second.index, second.number}};
    }

    private static class NumberWeight implements Comparable<NumberWeight> {
        int number, weight, index;

        NumberWeight(int number, int weight, int index) {
            this.number = number;
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(NumberWeight other) {
            int weightCompare = Integer.compare(this.weight, other.weight);
            return weightCompare == 0 ? Integer.compare(this.index, other.index) : weightCompare;
        }
    }
}