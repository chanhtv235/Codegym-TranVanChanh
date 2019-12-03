package CaseStudyJavaCoreFuramaResort.src.commons;

import models.Customer;

import java.util.Comparator;

public class ComparatorNameCustomer implements Comparator<Customer> {
@Override
    public int compare(Customer c1, Customer c2) {
        if (c1.getCustomerName().compareTo(c2.getCustomerName())==0){
           return compareYear(c1,c2);
        }
        return c1.getCustomerName().compareTo(c2.getCustomerName());
    }
    private int compareYear(Customer c1, Customer c2) {
        String year1= (c1.getBirthdayOfCustomer()).substring(6);
        int yearOld1=Integer.parseInt(year1);
        String year2= (c2.getBirthdayOfCustomer()).substring(6);
        int yearOld2=Integer.parseInt(year2);
        return Integer.compare(yearOld1, yearOld2);

    }
}

