package Case_Study.JavaCore.SaveToFile.Models;

import java.util.Comparator;

public class SortName implements Comparator<Customer> {
    public int compare(Customer s1, Customer s2) {
        return s1.getNameCus().compareTo(s2.getNameCus());
    }
}
