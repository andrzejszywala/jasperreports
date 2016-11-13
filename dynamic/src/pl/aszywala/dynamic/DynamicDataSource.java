package pl.aszywala.dynamic;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DynamicDataSource implements JRDataSource {

	private Object[][] data = { { "Katowice", "Jan", "Kowalski", "Staszica 1" },
			{ "Katowice", "Piotr", "Nowak", "Warszawska 11" },
			{ "New York", "Andrew", "May", "172 Seventh Av." },
			{ "New York", "Sylvia", "Ott", "361 College Av." },
			{ "New York", "Bill", "King", "546 College Av." },
			{ "Paris", "Sylvia", "Steel", "269 College Av." },
			{ "Paris", "Sylvia", "Fuller", "158 - 20th Ave." },
			{ "Paris", "Laura", "Miller", "294 Seventh Av." },
			{ "San Francisco","Robert", "White", "549 Seventh Av." },
			{ "San Francisco", "James", "Peterson", "231 Upland Pl." } };

	private int index = -1;

	public DynamicDataSource() {
	}

	public boolean next() throws JRException {
		return (++index < data.length);
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;

		String fieldName = field.getName();

		if ("City".equals(fieldName)) {
			value = data[index][0];
		} else if ("FirstName".equals(fieldName)) {
			value = data[index][1];
		} else if ("LastName".equals(fieldName)) {
			value = data[index][2];
		} else if ("Street".equals(fieldName)) {
			value = data[index][3];
		}

		return value;
	}

}
