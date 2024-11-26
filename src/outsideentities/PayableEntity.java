package outsideentities;

import exceptions.*;

public interface PayableEntity {

    void pay(double amount) throws NumberEqualToZeroException, NegativeNumberException;
}