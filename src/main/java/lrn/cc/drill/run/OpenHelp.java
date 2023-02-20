package lrn.cc.drill.run;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class OpenHelp {
	
	public void find(String lesson) {
		String url = "https://resources.coderscampus.com/docs/drills/"+ lesson + "/";
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(URI.create(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
