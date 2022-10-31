import java.util.*;
public class GrammarSolver {
private Map<String,String> rulesMap;
private Set<String> vals;

//constructor that splits rules into non-terminal and termnals and put them into a map
public GrammarSolver(List<String> rules){
if(rules.isEmpty()){
    throw new IllegalArgumentException();
}
rulesMap=new TreeMap<String,String>();
String line="";
for(int i=0;i<rules.size();i++){
line=rules.get(i);
String[]ruleLine=line.split("::=");
rulesMap.put(ruleLine[0],ruleLine[1]);
}
vals=rulesMap.keySet();
}
//checks if the map of grammar has a specific non terminal
public boolean grammarContains(String symbol){
return(rulesMap.containsKey(symbol));
}


//returns all of the non terminal symvbols
public String getSymbols(){
    String symbols="[";
    for(String s: vals){
        symbols+=rulesMap.get(s)+", ";
    }
    symbols.substring(symbols.length());
    return symbols;
}

//start with adj non terminal
//public String[] generate(String symbol, int times){

//}

}
