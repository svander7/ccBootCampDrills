package lrn.cc.drill.domain;

public class Lesson {
	private String key;
	private String topic;
	private String targetSeconds;
	private String minReps;

	public Lesson(String lesson) {
		try {
			String[] values = lesson.split(",");
			this.key = values[0];
			this.topic = values[1];
			this.targetSeconds = values[2];
			this.minReps = values[3];
		} catch (Exception e) {
			throw new IllegalArgumentException("This was apparently not parseable as a String[] ??? \n" + lesson);
		}
		
	}

	public String getKey() {
		return key;
	}

	public String getTopic() {
		return topic;
	}

	public String getTargetSeconds() {
		return targetSeconds;
	}

	public String getMinReps() {
		return minReps;
	}
}
