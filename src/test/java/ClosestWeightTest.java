import org.junit.Assert;
import org.junit.Test;

public class ClosestWeightTest {

    @Test
    public void run() {
        assertValues("103 123 4444 99 2000", new int[][]{{2, 4, 2000}, {4, 0, 103}});
        assertValues("80 71 62 53", new int[][]{{8, 0, 80}, {8, 1, 71}});
        assertValues("444 2000 445 544", new int[][]{{13, 2, 445}, {13, 3, 544}});
        assertValues("444 2000 445 644 2001 1002", new int[][]{{3, 4, 2001}, {3, 5, 1002}});
        assertValues("239382 162 254765 182 485944 468751 49780 108 54", new int[][]{{9, 1, 162}, {9, 7, 108}});
        assertValues("54 239382 162 254765 182 485944 468751 49780 108", new int[][]{{9, 0, 54}, {9, 2, 162}});
        assertValues("", new int[][]{});
        assertValues("456899 50 11992 176 272293 163 389128 96 290193 85 52", new int[][]{{13, 9, 85}, {14, 3, 176}});
        assertValues("239382 162 254765 182 485944 134 468751 62 49780 108 54", new int[][]{{8, 5, 134}, {8, 7, 62}});
        assertValues("241259 154 155206 194 180502 147 300751 200 406683 37 57", new int[][]{{10, 1, 154}, {10, 9, 37}});
        assertValues("89998 187 126159 175 338292 89 39962 145 394230 167 1", new int[][]{{13, 3, 175}, {14, 9, 167}});
        assertValues("462835 148 467467 128 183193 139 220167 116 263183 41 52", new int[][]{{13, 1, 148}, {13, 5, 139}});
        assertValues("403749 18 278325 97 304194 119 58359 165 144403 128 38", new int[][]{{11, 5, 119}, {11, 9, 128}});
        assertValues("28706 196 419018 130 49183 124 421208 174 404307 60 24", new int[][]{{6, 9, 60}, {6, 10, 24}});
        assertValues("189437 110 263080 175 55764 13 257647 53 486111 27 66", new int[][]{{8, 7, 53}, {9, 9, 27}});
        assertValues("79257 160 44641 146 386224 147 313622 117 259947 155 58", new int[][]{{11, 3, 146}, {11, 9, 155}});
        assertValues("315411 165 53195 87 318638 107 416122 121 375312 193 59", new int[][]{{15, 0, 315411}, {15, 3, 87}});
    }

    private void assertValues(String numbers, int[][] expected) {
        Assert.assertArrayEquals(expected, ClosestWeight.closest(numbers));
    }
}