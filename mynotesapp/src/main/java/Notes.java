public class Notes {
	protected int id;
	protected int userid;
	
	
	public Notes(int id, int userid, String title, String note) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	protected String title;
	protected String note;
}
