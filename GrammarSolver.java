import java.util.*;
public class GrammarSolver {
private Map<String,String> rulesMap;
private Set<String> keys;

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
keys=rulesMap.keySet();
}
//checks if the map of grammar has a specific non terminal
public boolean grammarContains(String symbol){
return(rulesMap.containsKey(symbol));
}


//returns all of the non terminal symvbols
public String getSymbols(){
    String symbols="[";
    for(String s: keys){
        symbols+=s+", ";
    }
    symbols=symbols.substring(0,symbols.length()-1)+"]";
    return symbols;
}

//start with adj non terminal
public String[] generate(String symbol, int times){
String [] s=new String[times];
    if(times<0||!rulesMap.containsKey(symbol)){
    throw new IllegalArgumentException();
}
for(int i=0;i<times;i++){
    s[i]=genHelp(symbol);
}
return s;
}

private String genHelp(String symbol){
String line=rulesMap.get(symbol);
if(line!=null){
    String[]pieces=line.split("|");
    if(pieces!=null){
        Random random=new Random();
        int rand=random.nextInt(pieces.length);
        return genHelp(pieces[rand]);
    }
    pieces=line.split("\\s+");
    if(pieces!=null){
        Random random=new Random();
        int rand=random.nextInt(pieces.length);
        return genHelp(pieces[rand]);
    }
}
return symbol;
}

}
