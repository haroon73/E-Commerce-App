package com.example.spiceworld.Variables;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.spiceworld.DB.AppDateBase;

@Entity(tableName = AppDateBase.USER_TABLE)
public class User  {


   @PrimaryKey(autoGenerate = true)
    private int mUserId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;




 private boolean adminIs;

 public User( String firstName, String lastName,  String userName , String password, boolean adminIs) {

  this.firstName = firstName;
  this.lastName = lastName;
  this.password = password;
  this.userName = userName;
  this.adminIs = adminIs;
 }

 public int getUserId() {
  return mUserId;
 }

 public void setUserId(int userId) {
  mUserId = userId;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getUserName() {
  return userName;
 }

 public void setUserName(String userName) {
  this.userName = userName;
 }

 public boolean isAdminIs() {
  return adminIs;
 }

 public void setAdminIs(boolean adminIs) {
  this.adminIs = adminIs;
 }

 // this is toString method


 @Override
 public String toString() {
  return  "Full name: " + firstName +" " + lastName + " \n"+
          "userName: " + userName + "\n" +
          "passowrd :" + password + "\n"+
          "UserId: " + mUserId + "\n\n";
 }
}
