//2.08
import java.io.*;
import java.util.*;
public class profe{
public static int perm[];
public static Vector<String> to1 = new Vector<String>();
public static Vector<String> to2 = new Vector<String>();
public static Vector<String> t1 = new Vector<String>();
public static Vector<String> t2 = new Vector<String>();
public static HashSet<String> permu = new HashSet<String>();
public static HashMap<String,Integer> veces = new HashMap<String,Integer>();
public static void main(String args[]) throws IOException{
BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
int a = Integer.parseInt(lector.readLine());
perm = new int[a];
go(0,0,"",-1,false,false);
System.out.println(t1.size()+" "+t2.size());
for(int n = 0;n<t1.size();n++){
String tt[] = t1.get(n).split(" ");
String tt1[] = t2.get(n).split(" ");
int perm[] = new int[tt1.length];
int permi[] = new int[tt1.length];
String t11 = "";
String t12 = "";
for(int nn = 0;nn<tt.length;nn++){
int r = Integer.parseInt(tt[nn]);
int r1 = Integer.parseInt(tt1[nn]);
perm[nn]=r1;
permi[r1-1]=nn;
if(r>2 && r<a)t11+=" "+(r-0);	
if(r1>2 && r1<a)t12+=" "+(r1-0);
}
/*Construyendo bije profe*/
perm[permi[1]]=perm.length+1;
perm[permi[perm.length-1]]=2;
String bijeprof = "";
if(permi[1]==0){
int rma = (perm[permi[perm.length-1]-1]<perm[permi[perm.length-1]+1])?
permi[perm.length-1]+1:permi[perm.length-1]-1;
perm[permi[perm.length-1]]=perm[rma];
perm[rma]=2;
perm[0]--;
}else{
int rma = (perm[permi[perm.length-1]-1]<perm[permi[perm.length-1]+1])?
permi[perm.length-1]+1:permi[perm.length-1]-1;
perm[permi[perm.length-1]]=perm[rma];
perm[rma]=2;
int rma2 = (perm[permi[1]-1]<perm[permi[1]+1])?
permi[1]-1:permi[1]+1;
perm[permi[1]]=perm[rma2];
perm[rma2]=perm.length;
}

for(int nm = 0;nm<perm.length;nm++)
bijeprof+=perm[nm]+" ";
t11 = t11.substring(1);
t12 = t12.substring(1);
if(!veces.keySet().contains(t11))veces.put(t11,1);
else
veces.put(t11,veces.get(t11)+1);
//permu.add(t11);
to1.add(t11+"---"+t1.get(n));
to2.add(t12+"---"+t2.get(n)+"->"+bijeprof);
//System.out.println(t1.get(n)+"--->"+t11+"     "+t12+"<---"+t2.get(n));
}
//System.out.println(veces);
Collections.sort(to1);
Collections.sort(to2);
int solo1 = 0;
int vec = 0;
for(int n = 0;n<to1.size();n++){
String tt = to1.get(n);
tt = tt.substring(0,tt.indexOf("-"));
//if(veces.get(tt)==1)continue;
solo1++;
//if(vec==0)
System.out.println(to1.get(n)+"     "+to2.get(n));
vec = (vec+1)%(a/2-1);
}
System.out.println("Mas de 1:"+solo1/(a/2-1));
//System.out.println(permu.size());
}
public static void go(int a,int b,String c,int d,boolean t,boolean tt){
if(a==perm.length){
if(t && !tt)t1.add(c.substring(1));
if(!t && tt)t2.add(c.substring(1));
}
if((b&1)==1 && !t && !tt)return;
for(int n = 0;n<perm.length;n++){
if((b&(1<<n))!=0)continue;
if(n+1>d && a%2==1)continue;	
if(n+1<d && a%2==0)continue;
perm[a] =n+1;
boolean dt = t?true:false;boolean dtt = tt?true:false;
if(n==perm.length-1 && (b&1)==0)dt=true;
if(n==1 && (b&1)==0)dtt=true;
go(a+1,b|(1<<n),c+" "+(n+1),n+1,dt,dtt);
perm[a]=0; 
}	
}
}