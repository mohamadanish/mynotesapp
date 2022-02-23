public class Notes {
	protected int id;
	protected String title;
	
	
	public Notes(int id, String title, String note) {
		super();
		this.id = id;
		this.title = title;
		this.note = note;
	}
	
	
	public Notes(String title, String note) {
		super();
		this.title = title;
		this.note = note;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	protected String note;
}
