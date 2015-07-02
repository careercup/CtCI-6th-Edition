package Q16_12_XML_Encoding;

public class Attribute {
	public String tag;
	public String value;
	public Attribute(String t, String v) {
		tag = t;
		value = v;
	}
	
	public String getTagCode() {
		if (tag == "family") {
			return "1";
		} else if (tag == "person") {
			return "2";
		} else if (tag == "firstName") {
			return "3";
		} else if (tag == "lastName") {
			return "4";
		} else if (tag == "state") {
			return "5";
		} 
		return "--";
	}
}
