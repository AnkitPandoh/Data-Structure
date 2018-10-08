package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Anagram {
	public static void main(String[] args){
		String[] oarr = new String[]{"abc", "albert", "cat", "gate", "cab", "grow", "act"};
		String[] carr = Arrays.copyOf(oarr, oarr.length);
		Set<String> set = findAnagram(oarr,carr);
		for(String s : set)
			System.out.print(s + " ");
	}
	
	public static Set<String> findAnagram(String[] oarr, String[] carr){
		for(int i=0;i<carr.length;i++){
			char[] arr = carr[i].toCharArray();
			Arrays.sort(arr);
			carr[i] = String.valueOf(arr);
		}
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for(int i=0;i<carr.length;i++){
			if(map.containsKey(carr[i])){
				set.add(oarr[map.get(carr[i])]);
				set.add(oarr[i]);
			}else{
				map.put(carr[i], i);
			}
		}
		return set;
	}
}
