package pojo;

public class BugDetails {
	public String getBugId() {
		return bugId;
	}
	public void setBugId(String bugId) {
		this.bugId = bugId;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	private String bugId;
    private String summary;
    private String steps;
}
