import java.util.*;
import java.io.*;
public class GrammarSolver {
private Map<String,String> rulesMap;
//fix iterator(change to values)
private Iterator<Iterator> it=rulesMap.iterator();

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
}


public boolean grammarContains(String symbol){
return(rulesMap.containsKey(symbol));
}

//symbols are values
public String getSymbols(){
    String symbols="[";
    while(it.hasNext()){
        symbols+=it.next()+",";
    }
    symbols.substring(symbols.length());
    return "";
}

//public String[] generate(String symbol, int times){

//}

}
