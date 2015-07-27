package exTwitter;

public class RoutineBean {
	
	private int routine_id;
	private String title;
	private String snippet;
	private String text;
	private int posted;
	private String start_date;
	private String end_date;
	private String post_time;
	
	//以下、ゲッターセッターメソッド
	public int getRoutine_id() {
		return routine_id;
	}
	public void setRoutine_id(int routineId) {
		routine_id = routineId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		if(text.length()>7){
			snippet = text.substring(0,7)+"…";
		}else{
			snippet = text;
		}
	}
	public int getPosted() {
		return posted;
	}
	public void setPosted(int posted) {
		this.posted = posted;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String startDate) {
		start_date = startDate;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String endDate) {
		end_date = endDate;
	}
	public String getPost_time() {
		return post_time;
	}
	public void setPost_time(String postTime) {
		post_time =postTime;
	}
	public String getSnippet(){
		return snippet;
	}
	
	public void sysoutBean(){
		System.out.println(this.routine_id);
		System.out.println(this.title);
		System.out.println(this.text);
		System.out.println(this.posted);
		System.out.println(this.start_date);
		System.out.println(this.end_date);
		System.out.println(this.post_time);
	}
}
