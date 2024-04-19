package activity4;

public class SpecialTopicCourse extends Course {
	private String topic;
	
	public SpecialTopicCourse(String courseNo, String title, String topic) {
		super(courseNo, title);
		this.topic = topic;
	}

	public SpecialTopicCourse(String courseNo, String title, int credit, String topic) {
		super(courseNo, title, credit);
		this.topic = topic;
	}
	
	public String getTopic() {
		return this.topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		return this.getCourseNo() + " - " + this.getTitle() + " (" + this.getCredit() + ") (" + this.topic + ")";
	}

	@Override
	public void printInfo() {
		System.out.println(this.getCourseNo() + " - " + this.getTitle() + " (" + this.getTopic() + ")");
	}
	
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof SpecialTopicCourse) {
			SpecialTopicCourse temp = (SpecialTopicCourse)obj;
			return (this.getCourseNo().equals(temp.getCourseNo()) && this.topic.equals(temp.topic));
		}
		else
			return false;
	}
}
