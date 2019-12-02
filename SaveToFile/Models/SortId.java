package Case_Study.JavaCore.SaveToFile.Models;

import java.util.Comparator;

public class SortId implements Comparator<Customer> {
        public int compare(Customer s1, Customer s2) {
            if (s1.getIdCardCus() == s2.getIdCardCus())
                return 0;
            else if (s1.getIdCardCus() > s2.getIdCardCus())
                return 1;
            else
                return -1;
        }
}
