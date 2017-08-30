/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC336PalindromePairs {

	/*
    Brute Force O(n^2 *m)
   
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < words.length-1; i ++)
        {
            for(int j = i +1; j < words.length ; j++)      
            {
                if(isPalin(words[i], words[j]))
                {
                    out.add(new ArrayList<Integer>(Arrays.asList(i,j)));
                }
                
                
                if(isPalin(words[j], words[i]))
                {
                    out.add(new ArrayList<Integer>(Arrays.asList(j,i)));
                }
                
            }
        }
        return out;
    }
    
    
    public boolean isPalin(String s1, String s2)
    {
        String ss = s1+s2;
        int i = 0 , j = ss.length()-1;
        
        while(i<j)
        {
            if(ss.charAt(i++)!=ss.charAt(j--)) return false;
        }
        
        return true;
    }
     */
    
    /*
     * O(n*m^2)
     */
     public List<List<Integer>> palindromePairs(String[] words) 
     {
         int n = words.length;
         List<List<Integer>> out = new ArrayList<List<Integer>>();
         Map<String, Integer> map = new HashMap<String, Integer>();
         
         for(int i = 0 ; i <n ; i++) map.put(words[i], i);
         
         for(int i = 0 ; i <n ; i++)
         {
             String s = words[i];
             
             for(int j = 0 ; j <= s.length(); j++)
             {
                 String s1 = s.substring(0, j);
                 String s2 = s.substring(j);
                // System.out.println("0 to " + (j-1) +s1);
                // System.out.println((j) + " to end " + s2);
                 
            if(isPalin(s1))
             {
                 String s2rev = new StringBuffer(s2).reverse().toString();
                 if(map.containsKey(s2rev) && map.get(s2rev) !=i )
                 {
                     List<Integer> list = new ArrayList<Integer>();
                     list.add(map.get(s2rev));
                     list.add(i);
                     out.add(list);
                 }
             }
             
             if(isPalin(s2))
             {
                 String s1rev = new StringBuffer(s1).reverse().toString();
                 if(map.containsKey(s1rev) && map.get(s1rev) !=i && s2.length()!=0)
                 {
                     List<Integer> list = new ArrayList<Integer>();
                     list.add(i);
                     list.add(map.get(s1rev));
                     out.add(list);
                 }
             }
             }
             
             
         }
         return out;
     }
    
    public boolean isPalin(String s)
    {
        int i = 0 , j = s.length()-1;
        
        while(i<j)
        {
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		LC336PalindromePairs pp = new LC336PalindromePairs();
		System.out.println(pp.palindromePairs(new String[]{"cbciiaecgdhecfgchcc","bi","fbfghhcagidac","djdhcehifgcbd","agadggfccgajhcbfcfj","fbfb","dgcgjj","hidb","ddbd","ci","ig","bc","gc","cigadajciaebbiiid","a","bdcjgfcgebjgficeieia","dbecbgbhbeciaahia","acdeei","edajhjjieejgajfjc","dagagjicecbedfdgije","ecea","djedfcijjbichdda","eaeijajieiajaab","cgc","ieghbgaaacjag","ibgaaeffcd","ded","adhfiaecead","fddidcfibbbfjf","egabfcejeeajdachh","fbcgijdjdabbfjih","abcaj","egge","bfcdibhdfehaedefic","jccgjcdccgaffdg","jhbbihjdjj","gbcgafd","cjicggje","affhchgcficj","hdhhiafbchjefbacgd","jfcajdibcbcedhiege","haejjfhjggaifife","cacfagjdideh","jjfjjh","ecbbca","hdaebedh","dadacceabbf","fajjfcf","ebbifijacbhcffa","jhijgfhcgihjbhc","ccgfgggihbaihfgeeh","ecbdcgedaabhaebccc","jcfefgfaaeah","dffbjhjaiea","gg","fjfhbhac","g","gaeiib","fhbbiicje","jef","ebiibjg","cjajbbdejhbfi","jdajchhifdfiegagaab","idiihbbcifidg","dacjgfaebaghd","cjjddfhjbbjhcjgcih","ccafahcjaab","jefcceff","aejibdbicaighcbbd","afhecejbbihi","iahbidfegja","ejgdceahbcebjcbjfg","aeghd","adccee","eiebcbdagjddbabiffh","hhbcbhbbdjhdbbdiabbc","ceeiiagjjabbbgi","if","jcfehiibcfffajgjjaa","cjjbaj","hebjaf","hiebf","daihdihccb","faehhdiedcfa","cghfhhbjcibbd","cgdfdfd","b","hgcdhicdibgej","bbhjbbeaf","cfajii","dcaehdbcfbcg","ccbagih","jcjbd","h","fdjdefhfhgddadiiii","egjfhdja","aa","hjhhdfjfhcdfecjab","ajfgagbeabjgcdjfghj","fchgif","jdcjdgffihadcgicajjc","ddecghgfbgfihfb","ejafbibffdcaejeahbfh","ibchggaachijfjf","jgibci","fabbhff","ijifdbfhhgfdddca","ccaghhcfgffidbb","ie","dfffi","fca","gcifbhhajeja","edibhcffhfgfhicaf","gijifbbdfhaf","fhbjedhhgejiacic","jifgfdd","ffccbciecaijhbajd","diciha","bcdjhgbbdfjdfh","geghefidfe","dajjbadejdajeejhi","ajeddbbgbacadeiaedc","adcbhfjgccaiffajbd","ife","fadddijgdbecfcjcfji","ggbjdagdhfjgeeg","ebciddbecb","aaeiifacdhaeefai","fcdddcbgd","ffd","fghffdcfciajbafgggjj","jbjaci","fffedfhadabfd","ehdghhfecbe","gcabchbhdijfejgaghc","gghccjjihffjdhbjaad","ab","hgie","hdffbbafaeaajd","dajeea","jjbjihacge","aecgdachd","hghcdja","dgggaecbccdcgd","iacdeicggjcee","cccafejijajedbaghf","efiifidafhhbd","geihjghfbecebgeaeiia","decaccajfe","ehahehcabbbid","iijfbchadehee","hddehjegdbgaiehhjf","ddhieegggceighbe","hbddjggjggfbheg","iidaifd","abafdcijhjh","hi","caccchgiac","hehedaifebjddeieigdj","af","iffahhfcgcidjibehd","gibgjejefbciajhgacje","aiabicgdffjeajg","jbgjficcgc","dj","cjfhbehehahjggbajha","fgfigifacebahahhb","jfbeefigjjgcdabi","gifgcdb","babajigi","ffeejebhejdgeahgefb","cceiehbddgbffaj","aebihb","bhicif","ibgddddcgjidffdij","fhgjebffecjfh","fhjaijcajc","ifjg","gbaijad","hahicgciagjbgigajb","cgecjdfjiiffeccd","ahajgbjgadh","egihchfigghicf","ceeagegcdh","bjbdceijefah","ijecejbjadffgifbih","fggeceddcafdg","eieibfiejheci","ejbaeihfeijegagjcbc","igaifdagdghdjefg","chcahgjie","bfghhedif","dihbabfdbaeheh","bhigdfidhgicafa","e","cfdibc","fchchcbecejddajgje","hhiebjga","echjahh","fb","bbgjcef","iaeg","djfhicibggdgib","efhcjaiciig","fhbiacaeebe","dfcijchjfhcdhaahga","ejdhijeagdbgcj","djhd","ibafgjba","agacgchhcd","efhbe","hibcde","acbhiabiefi","ahfahhcbebbj","je","ieceehcabfjgf","hheibcdajgbbef","iaajjbaijggajeffj","baije","agificiiafiaeceaeag","hcijbccedgdgfgi","ajbgdhhjbdcaeihiag","bjgeb","egibggbff","gfbhedihhdbjjjif","beji","jbeiccbibiadcia","fej","gidfdbbbbeiedh","gfbhjdghgchedgb","ebfhfigjj","hbdcfejijabbedbadj","j","bjdfeebbgjg","ed","abbe","aehhgb","cficjcgibefij","fedeiegbhacda","daeejfbafdacbj","aeifeddh","jgbgacaiacc","becdjibebcddaidcg","ichbe","geachabcaeajhgcb","ffb","aag","ebdgiciiechiced","agjgcjjdia","fdibihdcfhaec","ffhh","habfg","fbhajie","dgcdaajghaihbeifhh","hieadbdijccd","aidhejdai","ggibjdciagjgigb","jjeaeigfaedcgbei","ideihifdjfig","ghbh","db","ijfjg","gdejhffafjegb","ejabgbbddicfafbfidf","iaefbfcijiie","jd","dbdgdabfc","jgecfdcbacg","bgahhcjd","cffgdghachajjicfac","gdfafijggddgi","ja","dajfd","hbgffbecdebeig","hiaiifhjhbejhhefbeif","gfghcbaaibaeijgb","dbbf","ihigaiafefbaadbjiddd","jgfideiifdgccc","ifg","ei","d","dbcgbbbaicigcbebgd","fadbjcdhda","ccfjjacbcicdedjad","figiecbbbdhfh","jhidabccajgf","bcdjchhb","iacehfghbdjbeddei","bicfjhhfhbdabaife","ghhbcaaeeeiacjjjiicc","fdg","hieef","hbgcdcigjejheghc","dcgfgdgji","fachbcefjeeefahbj","gfefhbdihcfehfdfha","cieegcbcbef","hhdjcdggf","dhdhedeifab","bda","fgiggeaccjbagjfc","ighjacdhfdfcghhiie","i","ajaaeeiagbge","edhdffbcaiibi","fbdjdddgfigddhdh","dbjafgebedjiacddd","jdfaedagfed","idebb","jjfcciga","daeddicjgg","ehhgcacjc","ad","ijccaaee","gcijbgfh","gfbjbedichejbdfaagab","hgbjeacadjgeedfcd","gbibihaeffdahdidef","jbeec","jcfeahbjbjhhje","jdgabeeaib","egaiajdeagcfbhebdcef","fbajdddgfceifbdff","ccifgechbedihdahiabc","bjejifhg","abgce","cd","djfjghcefidedbfdehjf","gbfh","cadijecgagcjgfdj","dfhbeijaefgaecgfgc","haahdfb","jaddhfbifchdgaeiei","dgddbaeifhajjgij","ggijcbgdceaagb","fahgibhfbeidg","adeadddjhgjia","jgihfffjhggfdjiiedbc","idihgjj","chaggdeiibja","aigj","jefifaeehhdiiighijhf","hdb","ah","aeafgfgcgbhhfe","fgihieajeg","cfhji","beaajidgcbg","aahacehgfiaiihi","f","dbbbadddbibe","jhib","dacgbdjiaeehgdbijj","jdahbidbiifbhe","hdaaiciehfe","ahfijajcfabhjghf","gcaggiiabibjgcjd","dabafddcfjjdcijiij","hff","dd","ihi","cijahjcecedbheb","ggcbahhgddijejibjbi","ijjii","bjdbddgeiigjcgh","gagcgajfdi","jadbbbejecdhagdb","icaeggfbgcjiifc","hgegaegffgeife","dghbjajjdeegefha","haihe","ccdccgedbd","dceigbh","iacheh","jhcijeiaaiaeha","adabiabdcfchhjdajee","gjdddfecijchhb","iidfeibiiefii","cggeadj","fcjedhhgihaic","bfjajcfjd","gjchgcbea","jbaddjibbiacdbjdddgg","fhbbhdedccbdf","hejjibcaebfab","fdfahfhda","icjhghiafifjbid","bjcggaabbdbj","accf","haejag","ccijefcjch","beaddcefdfeabhf","hc","he","dfaedjabjbigbhbc","ggedbgid","jafebhdaejdhbdbbaif","egcdbhfchiajejcha","bgg","jdcfieficfbacieb","ihbeicifhfbci","gdeijjbjfad","bgd","gcfjcehdde","fah","gigdihdejjjjhghdfd","idjffb","hbjbdbgjiedbeic","jddaeegibiacfffcaede","aacdj","iafjehdaijbcecg","ghfcjahhifdeffdibjc","ffjdbeebffjicf","dfdiebe","adf","aeabjbefbj","hibibb","aebbcfcjacab","behdf","jjejgjhd","haajhihe","agehjdciehj","iaagfaejebecj","degdbfhcagedejafige","ihacehdadhfgdhbcfa","jcfhbceabgiie","hib","gfjeabjhifaiiigjgd","egifjfiaagb","c","fecceefceccgbaa","bffcecfbjgjefbdgee","bgbagbcijicifbjab","abgeggijebjhg","fhaafd","fcif","bfad","igh","ghjacgbigjh","egaaa","gbbibcddchjffibeie","bifibfajcgjae","jgdif","debibejchagefiihdfg","abbb","ih","dchbfcabf","adegeechdhdiafd","jidfgefcccbbei","ebadbjbjiceafe","egheabefghe","aijj","cig","ccgbh","aibhhaffhgdcdc","ihejhcbgcfbgbfdefg","bcc","ffheeacicdfef","efdecebahbgg","eee","chcdhcadbgebfa","gdfegifdjdbhijijiajd","gd","dacj","cdj","dg","defjhcbabdbdjddbhgfe","eccheidaijgf","cbe","bbjdccjebhegceib","heefhfhadeci","cgfaifbia","djbf","haajjdibi","gbd","fd","fiaageiagcacjhh","jaabgibcfdegbjahbd","dhjgbijcibidcgh","gihfgeaceecdgd","gegffdiig","ihaeagahdeij","ajhiajfh","ebhfjbfadaijbhciga","ecdcehddgjfgbagi","jfddabfgiahccafghji","jhfbhahbfeggjgahdjjb","igcbdeb","ic","jej","hifiie","cfgb","hf","digfbjcegfecddebf","hbbbajjhgj","cjibjjedfdggbj","cjabicbjgagdb","jdiccafjde","icjicejejbdhgee","agdjhihiifje","jagaadabhd","fc","ibhha","gafjidc","cehcefiaajajgig","ehejjhjfagefejeja","fbd","jieef","ifbajhdiaibccgcdg","fadhfjhghh","cabjaif","deeeeeebbcebigfidc","bihfaccibdhdabdcddj","afighbfhibfd","bjgijefggdi","bhcc","hae","djeeijbhhadedj","cigcafbidfa","jichgfg","fbgcjfbbfbedjihdbbga","iaheja","hjhjgcfdffgi","egifhfadhagjdcb","hfeagfajbda","adbegbdddahhiii","fdhfijbejaabgcgjgdfb","febjeihfbai","fgfcfjid","ieg","gjeaba","chjifiihaceebjjdgh","cecb","iggjdgjcjgjj","djgdhefh","hjjccgac","fh","ddgfebciffii","jcjjhfadjeed","ehcedcajfjcfei","gfcgbcbibgedffff","iai","eaddgfijcjdeedgaacja","gcf","ccjhbgjbhheehhhg","dbbejbghgifbg","hjecdbbgbfbcifbbbc","gghhfbehjbbgadcedgai","gbcgib","ccafjfdhcc","ahfhjgacgjfeijjgd","aiajdjagc","djijjihiddddcfeffici","cfd","iajggfabdaahajbech","dfcicfafaghe","afjefddbhieagcfaeidf","hejghbjjjibebdedibgd","gaehfceige","ibfidfhfgcgjcjii","jcdeebgbedaid","jebaa","ibhijfedcgc","cdeecjaiia","idhehdfgchbecabhbc","dfbjced","jjfg","ghhjcjbcfcd","jddhaffdjhieai","eaaacjech","dcdhbdceiacagcj","baacaccaeedacj","ij","bbjhijbdifgdgji","abbgiheehacj","jjdabfaebfcicc","jbdhghjdeegfcehfac","bijhbggfjideba","jjeddbifac","cf","jbdebijbh","fig","fcddg","cfda","fejdajjdhgbc","hbfcjfbcfeebci","gijgecadfgcdf","adjjbbdfhciid","cccgadigbia","ecbje","idejhehjghfa","djef","gccie","aaageghahfificgja","abfgbjcfhc","ffcdibhfaeihfhdhhafc","bjffaigfdeefjjhd","fegdh","jbaef","afddeaabd","ajedhghecdjccij","hcaffedifh","iedfiadiaiejfg","cjigjcjebahdi","dibiaibecbchjhhdg","hieiacbajh","afiajcfchfbij","ahjcjaa","hfe","aagacb","cbdjahgj","cighhgad","jbaeee","hicjbjiiacf","eheceehbghjcgjhehdcg","jdhfdihaechehiaeii","ahecigiieaaibgb","jgcfghebhfi","daghadiahaigfcii","gihdgahjccgegdh","ahcgicb","bhhadbfbfijcafc","fifgcfgbdjf","jihheghhgi","cadfcfe","gdegfafccj","jdcchahicbcdhj","fhgddcajbfbfai","abahifigihichgb","jghcegegjaeage","djegbg","gifgbfi","ddigfjfaijjhi","ajfi","eea","agfificiadcfbgf","ecfcgaejiff","fcgj","fgcigcifihfb","ggidgiih","ggbface","jf","ijiifbjfgecbei","ijbdjhjfacjchbbd","gdfiacijjafi","ebic","fgeadf","idbcdgcccgegdjgd","gfffd","jifcjhjchfdgadedha","cjbjbdgedccgbfaci","ggcbhdbfifijbdfcaif","ehiecgj","iggbageach","fbdgh","igecdghadaicbiabihb","ejaigcdheedha","gcfdjjeh","fddbehcdda","ceceeebff","jaaajdgcefhcjhecf","dfjfaieheichhb","egggfjj","gfecababaifgjafjfc","jgaifibfghgfg","ddaaib","cfhcdfbfhaeaje","afffjccjbdaf","ghhjc","fddjja","fae","eebjbecagcfhdhg","dhhjajejah","ggjbggjgghfcceeeefad","hhdgbfiighbhaf","jdefadhfdhfbhj","cihbgdhg","bfifaeafabb","bccd","bfcdibcghifgjgjifcii","bejhejiedjcjjaa","cfdafaefccifae","cdhafddgfhdhjdh","bhcbbehgcdjiha","headbgjhhdgbedf","hagchib","gdejacjb","affajcabifcaihgg","dfgbcicgebhefghhc","idce","jfcbhi","cdgdhacihhdfdeehbibj","jiehjichbeahghcbf","eg","jdgehafafacfbffjgf","ecgjeiggic","cdeagcjhebjbegajicj","ea","cfefhehbihdccdcj","beadcdgcbjfiffaaghc","cjcddchbecfjafih","edccbigcfiifajhcab","bjf","iechigghgaidgfigjcd","iefiadbhhfffjebbg","caajifh","gdfc","iafibbahidh","cjeadghicj","hbecejc","ceafabbiiah","baacfdf","adbfjjegggbfafbdac","hbe","hbcdhb","faihjaeigbijfhhjeg","hjej","fiih","jgejcdeffbecibf","baiecadjb","fgadjhjbcbjdce","hfjdbja","abaihhb","fiaddidgbjijdfbid","jaifbcieeafcgfahfcca","cgaffjbeadjgjeagc","icjeije","ddf","adgfh","bhga","ajcdfcgbibihe","fi","dgghdedeeihj","cij","abfgfhhchgajdaeficc","hh","ijce","jdifaihcga","edicffgecifbcagbb","deecdfbagjbjigd","fdegfgcjdjajihicjif","cbeabbbedichagggb","bhjijddgagcbg","hdebibidfacjbaiccb","abifchhj","ibfibbgeegegfjfhecd","adibhagfgaa","gfgeaeae","jbjjcfb","aadhjafbhjbcfhc","icdcbdhfgecc","dgah","dhijfcb","iiffdhedjg","haj","bfcifdeegcbjigf","dijgfdaaeeghbgfjhahf","hjbhiccbigcecdc","ajjjeehfeagcegchfajc","eajaddfigaaajjdfga","baifdceicfjiefja","gadehcbehdiicgcbdbcf","chjiichief","fbfie","gb","efdccahaggghaeaiijgi","biiebfjbcac","iceaedehgheefgjhifje","cihea","baahbidfbaceeagcc","daj","eac","eahcd","cbaeibbjigiie","fabce","afbegfijjjigd","feddeaideadhgbfaihj","jgaahbai","fjjidgacdhcdaebdgahd","jcibcgdciahffagf","djfdhgah","hgifgiihcbigjjfffcj","ceccdjbbcaif","cjjeeicjdcifigcf","hjbehbgcafediab","bcdjghiehj","bheee","ggegdddahhbcdeciei","ehbjegccfihfaa","gjgbeggjgafdhicjje","gjheijeaahhabafgiid","jaaicbhbfdgaddibdiee","gfbgafjja","cfjgiifgjbde","ggcfgjaghbcefiiafbi","iibghddhgigei","iicibfbeiagbjgccdgc","eghcdgjeacfedeagdc","edjecjcffheegbgcgbg","bcfcfdfheecaahfjdig","bhjcjiabe","defcbadhjdjb","gdcdjdffcgieafbibhj","icjhddc","ggdhddfjechcge","jgehei","aaigcgdfdhbaggghjj","hehbfa","efejhfcj"}));
	}

}
