import java.util.*;
class array_list {
	public static void main(String[] args) {
	ArrayList<String> colours = new ArrayList<String>(Arrays.asList("Red","Black","violet","Green","Blue"));
	Iterator it = colours.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	colours.add(0,"pink");
	System.out.println("adding elements: "+colours);
	System.out.println("retrieve element: "+colours.get(3));
	colours.set(3,"skyblue");
	System.out.println("replacing elements: "+colours);
	colours.remove(3);
	System.out.println("removing elements at specified index: "+colours);
	System.out.println(colours.contains("pink"));
	Collections.sort(colours);
	System.out.println("sorting elements: "+colours);
	ArrayList<String> secondlist = new ArrayList<String>(colours);
	System.out.println("copying elements: "+secondlist);
	Collections.shuffle(secondlist);
	System.out.println("shuffle elements: "+secondlist);
}
}
