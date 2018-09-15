package com.snippets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReOrderLogFile {
	public static void main (String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a1 9 2 3 1");
		list.add("g3 Act car");
		list.add("zo4 4 7");
		list.add("a2 off KEY dog");
		list.add("a1 Act car[");
		System.out.println("Input list is:");
		System.out.println(list);
		System.out.println(reorder(list));
	}
	
public static List<String> reorder(List<String> list) {
		
    List<String> strAlp = new ArrayList<String>();
    List<String> strNum = new ArrayList<String>();
    List<String> AlpNum = new ArrayList<String>();

    for( String sl :  list){
        String[] slPart = sl.split(" ", 2);
        if(Character.isDigit(slPart[1].charAt(0))){
            strNum.add(sl);
        }
        else {
            strAlp.add(slPart[1].concat(" " + slPart[0]));
        }
    }
    Collections.sort(strAlp);
    for(String sl2 : strAlp){
        String[] part = {sl2.substring(0,sl2.lastIndexOf(" ")), sl2.substring(sl2.lastIndexOf(" ") + 1)};
        AlpNum.add(part[1].concat(" " + part[0]));
    }
    AlpNum.addAll(strNum);
    return AlpNum;
		
	}

}
