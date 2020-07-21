package common;

import java.util.stream.Stream;


public interface Performance {
	
	public String getName();

	public Stream<Artist> getMusicians();
	
}
