package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class Day01_MeetingRooms {

	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});

		for (int i = 0; i < intervals.length - 1; i++) {
			int previousEnd = intervals[i][1];
			int nextStart = intervals[i + 1][0];
			if (previousEnd > nextStart)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
//		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		System.out.println(canAttendMeetings(intervals));
	}

}
