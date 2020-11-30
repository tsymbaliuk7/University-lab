package com.university.units;

public class Rectorate extends Unit{
    private Rector rector;

    public Rectorate(Integer employees, String rectorName){
        super(employees);
        rector = new Rector(rectorName);
    }

    protected Rector getRector() {
        return rector;
    }

     public static class Rector{
       String rectorName;
       public Rector(String rectorName){
           this.rectorName = rectorName;
       }

       @Override
       public String toString(){
           StringBuilder type = new StringBuilder();
           type.append("Rector name: ");
           type.append(rectorName);
           return type.toString();
       }
    }

    @Override
    public void show(){
        System.out.println("University Rectorate: " + this.employees() + " employees" );
        System.out.println(this.rector);
    }


}
