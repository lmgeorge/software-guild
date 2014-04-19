/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package records;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ReportCard {
  int id;
  int recordNum;
  float grade;
  String ltrGrade;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRecordNum() {
    return recordNum;
  }

  public void setRecordNum(int recordNum) {
    this.recordNum = recordNum;
  }

  public float getGrade() {
    return grade;
  }

  public void setGrade(float grade) {
    this.grade = grade;
  }

  public String getLtrGrade() {
    return ltrGrade;
  }

  public void setLtrGrade(String ltrGrade) {
    this.ltrGrade = ltrGrade;
  }
  
  
  
}
