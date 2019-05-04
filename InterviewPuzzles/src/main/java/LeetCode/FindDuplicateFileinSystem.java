package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String,List<String>> map = new HashMap<>();
        for(String str : paths){
            String []parts = str.split(" ");
            if(parts.length == 1){
                continue;
            }
            String prefix = parts[0];
            for(int i=1;i<parts.length;i++){
                String fname = prefix+"/"+parts[i].substring(0,parts[i].indexOf('('));
                String content = parts[i].substring(parts[i].indexOf('('));
                List<String> list = map.getOrDefault(content,new ArrayList<>());
                list.add(fname);
                map.put(content,list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            if(entry.getValue().size()>1){
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(new FindDuplicateFileinSystem().findDuplicate(input));
    }
}
