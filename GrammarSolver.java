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


//returns all of the non terminal symbols
public String getSymbols(){
    String symbols="[";
    for(String s: keys){
        symbols+=s+", ";
    }
    symbols=symbols.substring(0,symbols.length()-2)+"]";
    return symbols;
}

//returns times instances of the requested symbol
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
//helper method for generate method by returning 1 instance of given symbol
private String genHelp(String symbol){
String line=rulesMap.get(symbol);
String pieces[];
String words="";
if(line!=null){
    pieces=line.split("\\|");
    if(pieces.length>1){
        Random random=new Random();
        int rand=random.nextInt(pieces.length); 
        words+=genHelp(pieces[rand]);
    }
    else{
    pieces=line.split("\\s+");
    if(pieces.length>1){
        for(String s: pieces){
            if(s.contains("<")){
                words+=genHelp(s);
            }
        }
    }
}
}
else{
    pieces=symbol.split("\\s+");
    for(String s: pieces){
        if(s.contains("<")){
           words+=genHelp(s);
        }
        else{
      words+=s+" ";
        }
    }
}
return words;
}

}
