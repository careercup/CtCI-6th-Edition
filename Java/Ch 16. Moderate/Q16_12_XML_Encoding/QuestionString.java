package Q16_12_XML_Encoding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestionString {
	private Map<String, Byte> tagMap;
	private static final Byte[] END = { 0, 1 };

	private ArrayList<String> tokens;
	private int currentTokenIndex;

	public QuestionString(Map<String, Byte> tagMap) {this.tagMap = tagMap;}

	public byte[] encode(char[] input) throws IOException {
		// tokenize
		tokenize(input);
		currentTokenIndex = 0;

		// parse
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		encodeTokens(outputStream);
		return outputStream.toByteArray();
	}

	private void encodeTokens(ByteArrayOutputStream output) 
		throws IOException {
		nextToken("<");

		// read tag name
		String tagName = nextToken();
		output.write(getTagCode(tagName));

		// read attributes
		while (!hasNextToken(">") && !hasNextTokens("/", ">")) {
			// read next attribute
			String key = nextToken();
			nextToken("=");
			String value = nextToken();

			output.write(getTagCode(key));
			for (char c : value.toCharArray()) {
				output.write(c);
			}
			output.write(END[0]);
			output.write(END[1]);
		}

		// end of attributes
		output.write(END[0]);
		output.write(END[1]);

		// finish this element
		if (hasNextTokens("/", ">")) {
			nextToken("/");
			nextToken(">");
		} else {
			nextToken(">");
			// while not the end tag
			while (!hasNextTokens("<", "/")) {
				// encode child
				encodeTokens(output);
			}
			// ending tag
			nextToken("<");
			nextToken("/");
			nextToken(tagName);
			nextToken(">");
		}

		output.write(END[0]);
		output.write(END[1]);
	}

	private String nextToken() throws IOException {
		if (currentTokenIndex >= tokens.size()) {
			throw new IOException("Unexpected end of input.");
		}

		String token = tokens.get(currentTokenIndex);
		currentTokenIndex++;
		return token;
	}

	private void nextToken(String expectedToken) throws IOException {
		if (currentTokenIndex >= tokens.size()) {
			throw new IOException("Unexpected end of input.");
		}

		String token = tokens.get(currentTokenIndex);
		if (token.equals(expectedToken)) {
			currentTokenIndex++;
		} else {
			throw new IOException("Unexpected input. Expected '"
					+ expectedToken + "'; found '" + token + "'.");
		}
	}

	private boolean hasNextToken(String expectedToken) {
		if (currentTokenIndex < tokens.size()) {
			return tokens.get(currentTokenIndex).equals(expectedToken);
		} else {
			return false;
		}
	}

	private boolean hasNextTokens(String... expectedTokens) {
		if (currentTokenIndex + expectedTokens.length > 
			tokens.size()) {
			return false;
		}

		for (int i = 0; i < expectedTokens.length; i++) {
			if (!tokens.get(currentTokenIndex + i)
					.equals(expectedTokens[i])) return false;
		}
		return true;
	}

	private void tokenize(char[] input) {
		tokens = new ArrayList<String>();
		int i = 0;
		while (i < input.length) {
			i = setNextToken(input, i);
		}
	}

	private int setNextToken(char[] input, int inputIndex) {
		int i = inputIndex;
		while (i < input.length && input[i] == ' ') i++;
		if (i == input.length) return i;

		// get 1 char token
		char c = input[i];
		if (c == '<' || c == '>' || c == '=' || c == '/') {
			tokens.add(String.valueOf(c));
			return i + 1;
		}

		// get multiple char token
		StringBuilder string = new StringBuilder();
		do {
			string.append(c);
			i++;
			c = input[i];
			if (c == '<' || c == '>' || c == '=' || 
				c == '/' || c == ' ') {
				break;
			}
		} while (i < input.length);
		tokens.add(string.toString());
		return i;
	}

	private byte getTagCode(String tag) throws IOException {
		Byte tagCode = tagMap.get(tag);
		if (tagCode == null) {
			throw new IOException("Unknown tag: " + tag);
		}
		return tagCode;
	}

	public static void main(String args[]) {
		try {
			Map<String, Byte> tagMap = new HashMap<String, Byte>();
			tagMap.put("a", (byte) 10);
			tagMap.put("root", (byte) 11);
			tagMap.put("href", (byte) 20);
			tagMap.put("target", (byte) 21);
			tagMap.put("name", (byte) 50);
			tagMap.put("id", (byte) 51);

			QuestionString encoder = new QuestionString(tagMap);
			String input;
			byte[] output;

			input = "<root></root>";
			output = encoder.encode(input.toCharArray());
			print(output);

			input = "<root id=a />";
			output = encoder.encode(input.toCharArray());
			print(output);

			input = "<root><a href=abc id=xyz></a><a></a></root>";
			output = encoder.encode(input.toCharArray());
			print(output);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void print(byte[] output) {
		for (byte b : output) {
			System.out.print(b);
			System.out.print(" ");
		}
		System.out.println();
	}
}
