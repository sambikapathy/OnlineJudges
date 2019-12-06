package javasamples.delete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SysDepen {

    static String[] input = new String[]{"DEPEND   TELNET TCPIP NETCARD", "DEPEND TCPIP NETCARD", "DEPEND DNS TCPIP NETCARD", "DEPEND  BROWSER   TCPIP  HTML", "INSTALL NETCARD", "INSTALL TELNET", "INSTALL foo", "REMOVE NETCARD", "INSTALL BROWSER", "INSTALL DNS", "LIST", "REMOVE TELNET", "REMOVE NETCARD", "REMOVE DNS", "REMOVE NETCARD", "INSTALL NETCARD", "REMOVE TCPIP", "REMOVE BROWSER", "REMOVE TCPIP", "LIST", "END"};


    private void receiveInput(String[] input) {
        Arrays.stream(input).forEach(this::execute);
    }

    private void execute(String input) {
        System.out.println(input);
        String[] parts = input.split("\\s+");
        switch (parts[0]) {
            case "DEPEND":
                addDependency(Arrays.copyOfRange(parts, 1, parts.length));
                break;
            case "INSTALL":
                directInstall.add(parts[1]);
                installDependency(parts[1]);
                break;
            case "REMOVE":
                remove(parts[1]);
                directInstall.remove(parts[1]);
                break;
            case "LIST":
               list();
                break;
        }

        System.out.println("\n");
        //list();
    }

    private void list() {
        installed.stream().forEach(item -> System.out.println(item));
        System.out.println("\n");
    }

    private void remove(String part) {
        if(dependencyCount.get(part) == null) {
            System.out.println("\tremoving "+ part);
            installed.remove(part);
        }else{
            System.out.println("\t"+part +" is still needed");
            return;
        }
        if(dependencies.containsKey(part)) {
            dependencies.get(part).stream().forEach(item -> {
                Integer count = dependencyCount.get(item);
                if (count == null || count == 1) {
                    dependencyCount.remove(item);
                    if(!directInstall.contains(item)) {
                        installed.remove(item);
                    }
                    System.out.println("\tremoving "+ item);
                    //dependencyCount.put(item, 0);
                } else {
                    dependencyCount.put(item, count - 1);
                }
            });
        }

    }
    /*
    HTML
   BROWSER
   DNS
   NETCARD
   foo
   TCPIP
   TELNET

     */

    private void installDependency(String part) {
        if(installed.contains(part)){
           // dependencyCount.put(part, dependencyCount.getOrDefault(part, new Integer(0)) + 1);
            System.out.println("\t"+part+" is already installed");
            return;
        }
        installed.add(part);
        if(dependencies.containsKey(part)) {
            dependencies.get(part).stream().forEach(item -> {
                installDependency(item);
                dependencyCount.put(item, dependencyCount.getOrDefault(item, new Integer(0)) + 1);
                installed.add(item);
            });
        }
    }

    private Map<String, List<String>> dependencies = new HashMap<>();
    private Map<String, Integer> dependencyCount = new HashMap<>();
    private Set<String> installed = new HashSet<>();
    private Set<String> directInstall = new HashSet<>();

    private void addDependency(String[] copyOfRange) {
        List<String> orDefault = dependencies.getOrDefault(copyOfRange[0], new ArrayList<>());
        for (int i = 1; i < copyOfRange.length; i++) {
            orDefault.add(copyOfRange[i]);
        }
        dependencies.put(copyOfRange[0],orDefault);
    }

    public static void main(String[] args) {
        new SysDepen().receiveInput(input);
    }

}
