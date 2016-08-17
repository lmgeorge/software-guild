/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.dvdlibraryv3;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.model.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;



/**
 *
 * @author apprentice
 */
public class DvdLibraryImplJX implements DvdLibraryDao {
    
    private List<Dvd> al = new ArrayList<>();
    private final String DVD_FILE ="dvdlist.txt";
    private final String DELIMITER = ",";

    

   
   @Override
    public void add(Dvd dvd) {
        
        al.add(dvd);
    }

    @Override
    public void remove(Dvd dvd) {
     
         al.remove(dvd); 
    
    }
    
    @Override
    public List<Dvd> listAll(){
        return al;
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        
        List<Dvd> newDvd = new ArrayList<>();
        for(int i = 0; i < al.size(); i++){
            if(al.get(i).getTitle().equalsIgnoreCase(title)){
                newDvd.add(al.get(i));
            }
        }                
       return newDvd;

    }

      @Override
    public List<Dvd> getReleasesInLastNYears(int years){
        
        int CurrentYear = LocalDate.now().getYear();
              
      List<Dvd> list = al
              .stream()
              .filter(dvd -> dvd.getReleaseDate().getYear() >= (CurrentYear - years))
              .collect(Collectors.toList());
        
      if(!list.isEmpty()){
          return list;
      }
      else{
          return null;
      }
        
    }
    
      @Override
    public List<Dvd> getByRating(String mpaaRating) {
       //rating G PG PG-13 R NC-17
           
        return  al
                .stream()
                .filter(dvd -> dvd.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
        
    }
    
     @Override
   public List<Dvd> getByStudio(String studio) {
        return al
                .stream()
                .filter(dvd -> dvd.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }
   
    @Override
    public float getAverageAge() {
                
      return (float) al
                .stream()
                .mapToDouble(Dvd::getAge)
                .average()
                .getAsDouble();   
    }
   

    
    @Override
    public void loadFromFile()  {
        Scanner sc = null;
        try {
             sc = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException f) {
           
            FileOutputStream fos = null;
            try { //create file if none exist
                fos = new FileOutputStream(DVD_FILE, true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DvdLibraryImplJX.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DvdLibraryImplJX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        while(sc.hasNext()){
            String currentLine = sc.nextLine();
            String[] currentToken = currentLine.split(DELIMITER);
            Dvd newDVD = new Dvd();
            
            
            newDVD.setTitle(currentToken[0]);
            newDVD.setReleaseDate(((LocalDate.parse(currentToken[1]))));
            newDVD.setMpaaRating(currentToken[2]);
            newDVD.setDirector(currentToken[3]);
            newDVD.setStudio(currentToken[4]);
            newDVD.setNote(currentToken[5]);
           
            
            al.add(newDVD); 
        }
        
        sc.close();
        
        
    }

    @Override
    public void writeToFile() {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException ex) {
            Logger.getLogger(DvdLibraryImplJX.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (out != null) {
            for (int i = 0; i < al.size(); i++) {
                Dvd dvd = al.get(i);
                out.print(dvd.getTitle() + DELIMITER
                        + dvd.getReleaseDate() + DELIMITER
                        + dvd.getMpaaRating() + DELIMITER
                        + dvd.getDirector() + DELIMITER
                        + dvd.getStudio() + DELIMITER
                        + dvd.getNote()+ DELIMITER + "\n");
                
            }
        }

        out.close();

    }   

   
}
