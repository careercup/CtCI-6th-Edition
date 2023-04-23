package Q16_12_XML_Encoding;

import java.util.ArrayList;

public class Element {
	public ArrayList<Attribute> attributes;
	public ArrayList<Element> children;
	public String name;
	public String value;
	
	public Element(String n) {
		name = n;
		attributes = new ArrayList<Attribute>();
		children = new ArrayList<Element>();
	}
	
	public Element(String n, String v) {
		name = n;
		value = v;
		attributes = new ArrayList<Attribute>();
		children = new ArrayList<Element>();
	}	
	
	public String getNameCode() {
		if (name == "family") {
			return "1";
		} else if (name == "person") {
			return "2";
		} else if (name == "firstName") {
			return "3";
		} else if (name == "lastName") {
			return "4";
		} else if (name == "state") {
			return "5";
		} 
		return "--";
	}
	
	public void insert(Attribute attribute) {
		attributes.add(attribute);
	}
	
	public void insert(Element child) {
		children.add(child);
	}
}
