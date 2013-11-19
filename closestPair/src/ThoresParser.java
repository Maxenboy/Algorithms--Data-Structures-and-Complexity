import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;


public class ThoresParser extends BufferedReader {
private ArrayList<Double> list;
	public ThoresParser(Reader in) {
		super(in);
	list=new ArrayList<Double>();
	}
	public ArrayList<Double> parse() throws Exception{
		for(int i =0;i<95;i++){
			String[] temp =readLine().trim().split(" ");
			list.add(Double.parseDouble(temp[2]));
		}
		return list;
	}


}
