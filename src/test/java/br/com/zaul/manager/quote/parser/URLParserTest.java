package br.com.zaul.manager.quote.parser;

import org.junit.Assert;
import org.junit.Test;

import br.com.zaul.manager.quote.business.parser.URLParser;

public class URLParserTest {

	private URLParser urlParser = new URLParser();
	
	@Test
	public void testURLWithHttp() {
		String note = "http://zaul.com";
		String parsedNote = "<a target=\"blank\" href=\"http://zaul.com\">http://zaul.com</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithWWW() {
		String note = "www.zaul.com";
		String parsedNote = "<a target=\"blank\" href=\"www.zaul.com\">www.zaul.com</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithHttpAndWWW() {
		String note = "http://www.zaul.com";
		String parsedNote = "<a target=\"blank\" href=\"http://www.zaul.com\">http://www.zaul.com</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAndHttp() {
		String note = "My page is http://zaul.com";
		String parsedNote = "My page is <a target=\"blank\" href=\"http://zaul.com\">http://zaul.com</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAndWWW() {
		String note = "My page is www.zaul.com";
		String parsedNote = "My page is <a target=\"blank\" href=\"www.zaul.com\">www.zaul.com</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAndHttpAndWWW() {
		String note = "My page is http://www.zaul.com";
		String parsedNote = "My page is <a target=\"blank\" href=\"http://www.zaul.com\">http://www.zaul.com</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextAfterAndHttp() {
		String note = "http://zaul.com is my page.";
		String parsedNote = "<a target=\"blank\" href=\"http://zaul.com\">http://zaul.com</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextAfterAndWWW() {
		String note = "www.zaul.com is my page.";
		String parsedNote = "<a target=\"blank\" href=\"www.zaul.com\">www.zaul.com</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextAfterAndHttpAndWWW() {
		String note = "http://www.zaul.com is my page.";
		String parsedNote = "<a target=\"blank\" href=\"http://www.zaul.com\">http://www.zaul.com</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAfterAndHttp() {
		String note = "The http://zaul.com is my page.";
		String parsedNote = "The <a target=\"blank\" href=\"http://zaul.com\">http://zaul.com</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAfterAndWWW() {
		String note = "The www.zaul.com is my page.";
		String parsedNote = "The <a target=\"blank\" href=\"www.zaul.com\">www.zaul.com</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAfterAndHttpAndWWW() {
		String note = "The http://www.zaul.com is my page.";
		String parsedNote = "The <a target=\"blank\" href=\"http://www.zaul.com\">http://www.zaul.com</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	
	
	
	@Test
	public void testURLWithHttpAndBR() {
		String note = "http://zaul.com.br";
		String parsedNote = "<a target=\"blank\" href=\"http://zaul.com.br\">http://zaul.com.br</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithWWWAndBR() {
		String note = "www.zaul.com.br";
		String parsedNote = "<a target=\"blank\" href=\"www.zaul.com.br\">www.zaul.com.br</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithHttpAndWWWAndBR() {
		String note = "http://www.zaul.com.br";
		String parsedNote = "<a target=\"blank\" href=\"http://www.zaul.com.br\">http://www.zaul.com.br</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAndHttpAndBR() {
		String note = "My page is http://zaul.com.br";
		String parsedNote = "My page is <a target=\"blank\" href=\"http://zaul.com.br\">http://zaul.com.br</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAndWWWAndBR() {
		String note = "My page is www.zaul.com.br";
		String parsedNote = "My page is <a target=\"blank\" href=\"www.zaul.com.br\">www.zaul.com.br</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAndHttpAndWWWAndBR() {
		String note = "My page is http://www.zaul.com.br";
		String parsedNote = "My page is <a target=\"blank\" href=\"http://www.zaul.com.br\">http://www.zaul.com.br</a>";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextAfterAndHttpAndBR() {
		String note = "http://zaul.com.br is my page.";
		String parsedNote = "<a target=\"blank\" href=\"http://zaul.com.br\">http://zaul.com.br</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextAfterAndWWWAndBR() {
		String note = "www.zaul.com.br is my page.";
		String parsedNote = "<a target=\"blank\" href=\"www.zaul.com.br\">www.zaul.com.br</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextAfterAndHttpAndWWWAndBR() {
		String note = "http://www.zaul.com.br is my page.";
		String parsedNote = "<a target=\"blank\" href=\"http://www.zaul.com.br\">http://www.zaul.com.br</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAfterAndHttpAndBR() {
		String note = "The http://zaul.com.br is my page.";
		String parsedNote = "The <a target=\"blank\" href=\"http://zaul.com.br\">http://zaul.com.br</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAfterAndWWWAndBR() {
		String note = "The www.zaul.com.br is my page.";
		String parsedNote = "The <a target=\"blank\" href=\"www.zaul.com.br\">www.zaul.com.br</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
	
	@Test
	public void testURLWithTextBeforeAfterAndHttpAndWWWAndBR() {
		String note = "The http://www.zaul.com.br is my page.";
		String parsedNote = "The <a target=\"blank\" href=\"http://www.zaul.com.br\">http://www.zaul.com.br</a> is my page.";
		
		Assert.assertEquals(parsedNote, urlParser.parse(note));
	}
}
