package com.university.units;

public class Library extends Unit{
     private int booksCount;

     public Library(Integer employees, int booksCount){
        super(employees);
        this.booksCount = booksCount;
    }

    @Override
    public void show(){
         System.out.println("University Library: " + employees() + " employees" );
         System.out.println("Library has " + booksCount + " books");
    }

    public int giveOutBooks(int booksDemandCount){
         if (booksDemandCount > booksCount){
             System.out.println("Library can give out only " + booksCount + " books");
             return -1;
         }
         booksCount -= booksDemandCount;
         System.out.println("Give out " + booksCount + " books");
         System.out.println(booksCount + " books left");
         return booksCount;
    }

    public int receiveBooks(int booksNum){
         booksCount += booksNum;
         System.out.println("Received " + booksNum + " books");
         System.out.println(booksCount + " books left");
         return booksCount;
    }


}
