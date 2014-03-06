import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;
import java.util.Locale;
import java.util.Date;

public class Calen {
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar();

		final int cFirstDayOfWeek = cal.getFirstDayOfWeek();
		final int cYear = cal.get(YEAR);
		final int cMonth = cal.get(MONTH);
		final int cDay = cal.get(DAY_OF_MONTH);

		// Header bar output
		System.out.printf("%15s%5d%n", cal.getDisplayName(MONTH, LONG, Locale.US), cal.get(YEAR));

		// Weekday symbols output
		while (cal.get(DAY_OF_WEEK) != cFirstDayOfWeek) {
			cal.add(DAY_OF_MONTH, 1);
		}
		do {
			System.out.printf("%-4s", cal.getDisplayName(DAY_OF_WEEK, SHORT, Locale.US));
			cal.add(DAY_OF_MONTH, 1);
		} while (cal.get(DAY_OF_WEEK) != cFirstDayOfWeek);
		System.out.println();

		// Indent output
		Date td = cal.getTime();
		cal.set(cYear, cMonth, 1);
		final int weekday = cal.get(DAY_OF_WEEK);
		cal.setTime(td);
		while (cal.get(DAY_OF_WEEK) != weekday) {
			System.out.printf("%4s", " ");
			cal.add(DAY_OF_MONTH, 1);
		}

		// Calendar output
		cal.set(cYear, cMonth, 1);
		while (cal.get(MONTH) == cMonth) {
			int day = cal.get(DAY_OF_MONTH);
			System.out.printf("%2d", day);
			if (day == cDay) {
				System.out.print("* ");
			}
			else {
				System.out.print("  ");
			}
			cal.add(DAY_OF_MONTH, 1);
			if (cal.get(DAY_OF_WEEK) == cFirstDayOfWeek) {
				System.out.println();
			}
		}
	}
}