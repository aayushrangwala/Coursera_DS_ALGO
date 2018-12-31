import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        //write your code here
        Arrays.sort(segments, new Comparator<Segment> () {
            @Override
            public int compare (Segment a, Segment b) {
                int x = a.end;
                int y = b.end;
                if (x == y) {
                    return 0;
                } else if (x > y) {
                    return 1;
                }
                return -1;
            } 
        });
        

        List<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < segments.length-1 && j < segments.length) {
            if (segments[i].start > segments[j].end) {
                list.add(segments[j].end);
                j++;
                continue;
            } else if (segments[i].start == segments[j].end) {
                j++;
                continue;
            }
            i++;
        }
        if (i == segments.length-1 && j <= segments.length-1 && segments[i].start <= segments[j].end) {
            list.add(segments[j].end);
        }

        /*int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }*/
        return list;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        //int[] points = optimalPoints(segments);
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
