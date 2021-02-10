package UA_MicroService.BFF_Sync_GenericClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormator {
	public static Calendar calendar = Calendar.getInstance();
	public static SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

	public static String dateFormetor() {
		return formater.format(calendar.getTime());
	}
}
