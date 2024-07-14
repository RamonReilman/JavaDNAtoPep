//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.util.Locale;

public class Main {

  static boolean valid_dna(String dna_string) {
    String lower_string = dna_string.toLowerCase();
    HashMap<Character, String> valid_dna = new HashMap<>();
    valid_dna.put('a', "valid");
    valid_dna.put('c', "valid");
    valid_dna.put('g', "valid");
    valid_dna.put('t', "valid");

    for (int i = 0; i < lower_string.length(); i++) {

      if (valid_dna.get(lower_string.charAt(i)) == null) {
        return false;
      }
    }
    return true;
  }

  static String dnaToRna(String dnaStringOld){
    HashMap<Character, Character> ToRna = new HashMap<>();
    ToRna.put('g', 'c');
    ToRna.put('a', 'u');
    ToRna.put('c', 'g');
    ToRna.put('t', 'a');

    String dnaString = dnaStringOld.toLowerCase();
    StringBuilder rnaString = new StringBuilder();

    for(int i = 0; i < dnaString.length(); i++){
      rnaString.append(ToRna.get(dnaString.charAt(i)));
    }

    String rna = rnaString.toString();
    return rna;
  }

  static HashMap<String, Character> hashGen(){
    HashMap<String, Character> codonMap = new HashMap<>();
    codonMap.put("UUU", 'F');
    codonMap.put("UUC", 'F');
    codonMap.put("UUA", 'L');
    codonMap.put("UUG", 'L');
    codonMap.put("CUU", 'L');
    codonMap.put("CUC", 'L');
    codonMap.put("CUA", 'L');
    codonMap.put("CUG", 'L');
    codonMap.put("AUU", 'I');
    codonMap.put("AUC", 'I');
    codonMap.put("AUA", 'I');
    codonMap.put("AUG", '_'); // Start Codon
    codonMap.put("GUU", 'V');
    codonMap.put("GUC", 'V');
    codonMap.put("GUA", 'V');
    codonMap.put("GUG", 'V');
    codonMap.put("UCU", 'S');
    codonMap.put("UCC", 'S');
    codonMap.put("UCA", 'S');
    codonMap.put("UCG", 'S');
    codonMap.put("CCU", 'P');
    codonMap.put("CCC", 'P');
    codonMap.put("CCA", 'P');
    codonMap.put("CCG", 'P');
    codonMap.put("ACU", 'T');
    codonMap.put("ACC", 'T');
    codonMap.put("ACA", 'T');
    codonMap.put("ACG", 'T');
    codonMap.put("GCU", 'A');
    codonMap.put("GCC", 'A');
    codonMap.put("GCA", 'A');
    codonMap.put("GCG", 'A');
    codonMap.put("UAU", 'Y');
    codonMap.put("UAC", 'Y');
    codonMap.put("UAA", '*');  // Stop codon
    codonMap.put("UAG", '*');  // Stop codon
    codonMap.put("CAU", 'H');
    codonMap.put("CAC", 'H');
    codonMap.put("CAA", 'Q');
    codonMap.put("CAG", 'Q');
    codonMap.put("AAU", 'N');
    codonMap.put("AAC", 'N');
    codonMap.put("AAA", 'K');
    codonMap.put("AAG", 'K');
    codonMap.put("GAU", 'D');
    codonMap.put("GAC", 'D');
    codonMap.put("GAA", 'E');
    codonMap.put("GAG", 'E');
    codonMap.put("UGU", 'C');
    codonMap.put("UGC", 'C');
    codonMap.put("UGA", '*');  // Stop codon
    codonMap.put("UGG", 'W');
    codonMap.put("CGU", 'R');
    codonMap.put("CGC", 'R');
    codonMap.put("CGA", 'R');
    codonMap.put("CGG", 'R');
    codonMap.put("AGU", 'S');
    codonMap.put("AGC", 'S');
    codonMap.put("AGA", 'R');
    codonMap.put("AGG", 'R');
    codonMap.put("GGU", 'G');
    codonMap.put("GGC", 'G');
    codonMap.put("GGA", 'G');
    codonMap.put("GGG", 'G');
    return codonMap;
  }

  static String RnaToPeptide(String rnaString){

    HashMap<String, Character> PeptideMap = hashGen();
    StringBuilder peptide = new StringBuilder();
    boolean recordingPeptide = false;
    for(int i = 0; i < rnaString.length(); i+=3){

      try {
        Character aminoAcid = PeptideMap.get(rnaString.substring(i, i + 3));
        if (aminoAcid == '_') {recordingPeptide = true;}
        else if (aminoAcid == '*') {recordingPeptide = false;}
        if (recordingPeptide) {peptide.append(aminoAcid);}
      }

      catch(Exception e){
        System.out.printf("rna string not dividable by 3, ignoring final %d nucleotides.\n", rnaString.length()%3);
      }
    }

    String peptideString = peptide.toString();
    return peptideString;

  }

  public static void main(String[] args) {
    if (args.length == 1){
      if (valid_dna(args[0])){
        System.out.println("Valide dna GANG");
        String rna = dnaToRna(args[0]);
        String peptide = RnaToPeptide(rna.toUpperCase());
        System.out.printf("Dna converted to peptide string: %s\n", peptide);
      }

      else{
        System.out.println("Niet valid dna");
      }
    }
  }
}