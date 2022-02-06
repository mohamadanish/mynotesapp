

public class Reminders {

	protected int id;
	
	protected String startdate;
	
	protected String enddate;
	
	protected String task;
	
	

	public Reminders(String startdate, String enddate, String task) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
		this.task = task;
	}

	public Reminders(int id, String startdate, String enddate, String task) {
		super();
		this.id = id;
		this.startdate = startdate;
		this.enddate = enddate;
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	
}
