public class WordEntry {
	private String word;
	private int[] pages;
	
	public WordEntry(String word, int[] pages) {
		this.word = word;
		this.pages = pages;
	}
	
	public String getWord() {
		return word;
	}
	
	public int[]  getPages() {
		return pages;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setNumPages(int[] pages) {
		this.pages = pages;
	}
	
	public String page() {
		String result = "";
		for (int i : pages)
			result += " " + i;
		return result;
	}
}