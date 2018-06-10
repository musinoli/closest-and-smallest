import org.junit.Assert;
import org.junit.Test;

public class ClosestSmallestTest {

    @Test
    public void run() {
        assertValues("103 123 4444 99 2000", new int[][]{{2, 4, 2000}, {4, 0, 103}});
        assertValues("80 71 62 53", new int[][]{{8, 0, 80}, {8, 1, 71}});
        assertValues("444 2000 445 544", new int[][]{{13, 2, 445}, {13, 3, 544}});
        assertValues("444 2000 445 644 2001 1002", new int[][]{{3, 4, 2001}, {3, 5, 1002}});
        assertValues("239382 162 254765 182 485944 468751 49780 108 54", new int[][]{{9, 1, 162}, {9, 7, 108}});
        assertValues("54 239382 162 254765 182 485944 468751 49780 108", new int[][]{{9, 0, 54}, {9, 2, 162}});
    }

    private void assertValues(String numbers, int[][] expected) {
        Assert.assertArrayEquals(expected, ClosestSmallest.closest(numbers));
    }
}