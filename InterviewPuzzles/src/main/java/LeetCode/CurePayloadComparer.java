package LeetCode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CurePayloadComparer {

    static String jsonFolder = "/Users/sambikapathi/Desktop/LEG Cures/json";
    static String masterList = "/Users/sambikapathi/Desktop/LEG Cures/master";
    static String[] ext = {"json"};

    private static Map<String, String> getLoanIdOrgMapping() throws IOException {

        File json = new File(jsonFolder);
        Map<String,String> masterMap = new HashMap<>();
        for (File file : json.listFiles()) {
            String name = file.getName();
            List<String> strings = Files.readAllLines(Paths.get(file.getAbsolutePath()));
            strings.stream().forEach(line -> {
                if (line.contains("entityId")) {
//                    if(line.contains("78994596")){
//                        System.out.println(">>>"+ getName(name));
//                    }
                    masterMap.put(line.split("1000-")[1].split("\",")[0],getName(name));
                }
            });
        }
        return masterMap;
    }

    private static Map<String, String> getLoansFromMasterList() throws IOException {
        Map<String,String> masterMap = new HashMap<>();
        File csvF = new File(masterList);
        for (File csv : csvF.listFiles()) {
            List<String> strings = Files.readAllLines(Paths.get(csv.getAbsolutePath()));
            strings.stream().forEach(line -> {
                String[] split = line.split("\t");
                String value = csv.getName().contains("SR")?split[8]:split[3];
                if( value != null && value.length() > 0) {
                    masterMap.put(split[0], value);
                }else{
//                    System.out.println("->"+split[0]);
                }
            });
        }
        return masterMap;
    }

    private static String getName(String name) {
        if (name.lastIndexOf('-') > 3) {
            return name.substring(0, name.lastIndexOf('-'));
        }
        return name.substring(0, name.indexOf('.'));
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> loanIdOrgMapping = getLoanIdOrgMapping();

        Map<String, String> loansFromMasterList = getLoansFromMasterList();

        Map<String,String> tsdToOrg = new HashMap<>();
        System.out.println(loanIdOrgMapping.size() +" "+loansFromMasterList.size());
        loanIdOrgMapping.entrySet().stream().forEach(entry->{
            String key = entry.getKey();
//            System.out.println(key+" "+loansFromMasterList.get(key));
            if(tsdToOrg.containsKey(entry.getValue())){
                if(!loanIdOrgMapping.get(entry.getKey()).equals(tsdToOrg.get(entry.getValue()))){
                    System.out.println("->"+entry.getKey());
                }else{
                    System.out.println("matched");
                }
            }else{
                tsdToOrg.put(entry.getValue(),loanIdOrgMapping.get(entry.getKey()));
            }
        });

//        loan - tsd
//
//                loan - org

        loansFromMasterList.entrySet().stream().forEach(entry -> {
//            if(loanIdOrgMapping.get(entry.getKey()) == null){
//                System.out.println(entry.getKey() + " "+entry.getValue());
//            }
            System.out.println(entry.getKey()+" "+entry.getValue());
        });
    }
}
